package ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(61000);
            System.out.println("Servidor esperando conexiones en el puerto 61000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado desde: " + socket.getInetAddress());

                // Flujo de entrada del cliente
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // Flujo de salida hacia el cliente
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                // Recibe el nombre del cliente
                String nombreCliente = input.readLine();
                System.out.println("Servidor: Cliente se llama " + nombreCliente);

                // Pregunta al cliente si quiere evolucionar a Raichu
                output.println("¿Quieres usar piedratrueno en tu " + nombreCliente + "? (Y/N)");

                // Lee la respuesta del cliente
                String respuestaCliente = input.readLine();

                if ("Y".equalsIgnoreCase(respuestaCliente)) {
                    // Envia el mensaje y el nombre modificado al cliente
                    output.println("Felicidades, tu " + nombreCliente + " ha evolucionado a Raichu");
                } else {
                    // Envia un mensaje de lástima al cliente
                    output.println("Qué lástima. Tu " + nombreCliente + " sigue siendo un Pikachu.");
                }

                // Cierra la conexión con el cliente
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
