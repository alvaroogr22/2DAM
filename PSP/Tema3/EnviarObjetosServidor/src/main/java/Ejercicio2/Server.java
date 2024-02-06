package Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            // Configurar el servidor
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor esperando conexiones...");

            // Esperar a que un cliente se conecte
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado desde " + socket.getInetAddress());

            // Configurar flujos de entrada y salida
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Recibir los números del cliente
            int numero1 = input.readInt();
            int numero2 = input.readInt();

            // Realizar la suma
            int resultado = numero1 + numero2;

            // Enviar el resultado de vuelta al cliente
            output.writeInt(resultado);

            // Cerrar conexiones
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
