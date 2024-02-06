package Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Configurar el servidor
            ServerSocket serverSocket = new ServerSocket(43456);
            System.out.println("Servidor esperando conexiones...");

            // Esperar a que un cliente se conecte
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado desde " + socket.getInetAddress());

            // Configurar flujos de entrada y salida
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Recibir la operación y los números del cliente
            String operacion = input.readUTF();
            double numero1 = input.readDouble();
            double numero2 = input.readDouble();

            // Realizar la operación y obtener el resultado
            double resultado = 0;

            switch (operacion) {
                case "1":
                    resultado = numero1 + numero2;
                    break;
                case "2":
                    resultado = numero1 - numero2;
                    break;
                case "3":
                    resultado = numero1 * numero2;
                    break;
                case "4":
                    if (numero2 != 0) {
                        resultado = numero1 / numero2;
                    } else {
                        System.out.println("Error: División por cero.");
                        resultado = Double.NaN;  // Representa "Not a Number" en caso de error
                    }
                    break;
                default:
                    System.out.println("Operación no reconocida.");
                    resultado = Double.NaN;
            }

            // Enviar el resultado de vuelta al cliente
            output.writeDouble(resultado);

            // Cerrar conexiones
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
