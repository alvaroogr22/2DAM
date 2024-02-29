package ejercicio1;

import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Servidor {
    private static final String CONTRASENA_ALMACENADA = "cenec";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Servidor esperando conexiones en el puerto 6000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado desde: " + socket.getInetAddress());

                // Flujo de entrada del cliente
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Flujo de salida hacia el cliente
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // Pide la contraseña al cliente
                output.println("Por favor, ingrese la contraseña:");
                String contraseñaCliente = input.readLine();

                // Verifica la contraseña
                if (verificarContraseña(contraseñaCliente)) {
                    output.println("Acceso permitido");
                } else {
                    output.println("Acceso denegado");
                }

                // Cierra la conexión con el cliente
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean verificarContraseña(String contraseñaCliente) {
        String contraseñaAlmacenadaEncriptada = encriptarContraseña(CONTRASENA_ALMACENADA);
        String contraseñaClienteEncriptada = encriptarContraseña(contraseñaCliente);

        return contraseñaAlmacenadaEncriptada.equals(contraseñaClienteEncriptada);
    }

    private static String encriptarContraseña(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] resumen = md.digest(contraseña.getBytes());

            return Hexadecimal(resumen);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método Hexadecimal
    static String Hexadecimal(byte[] resumen) {
        StringBuilder hex = new StringBuilder();
        for (byte b : resumen) {
            hex.append(String.format("%02x", b));
        }
        return hex.toString().toUpperCase();
    }
}
