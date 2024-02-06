package Ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Configurar el cliente
            Socket socket = new Socket("127.0.0.1", 12345);

            // Configurar flujos de entrada y salida
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Enviar dos números al servidor
            output.writeInt(5);
            output.writeInt(10);

            // Recibir el resultado de vuelta
            int resultado = input.readInt();
            System.out.println("El resultado de la suma es: " + resultado);

            // Cerrar conexión
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
