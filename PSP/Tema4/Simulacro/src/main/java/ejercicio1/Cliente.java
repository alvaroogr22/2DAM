package ejercicio1;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6000);

            // Flujo de entrada desde el servidor
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Flujo de salida hacia el servidor
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Lee el mensaje del servidor solicitando la contraseña
            String mensajeServidor = input.readLine();
            System.out.println("Servidor: " + mensajeServidor);

            // Ingresa la contraseña desde la consola
            BufferedReader consolaInput = new BufferedReader(new InputStreamReader(System.in));
            String contraseña = consolaInput.readLine();

            // Envía la contraseña al servidor
            output.println(contraseña);

            // Lee la respuesta del servidor
            String respuestaServidor = input.readLine();
            System.out.println("Servidor: " + respuestaServidor);

            // Cierra la conexión con el servidor
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
