package ejercicio2;

import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 61000);

            // Flujo de entrada desde el servidor
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Flujo de salida hacia el servidor
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Envía el nombre del Pikachu al servidor
            output.println("Pikachu");

            // Lee la pregunta del servidor
            String preguntaServidor = input.readLine();
            System.out.println("Servidor: " + preguntaServidor);

            // Pregunta al usuario si quiere usar el piedratrueno
            BufferedReader consolaInput = new BufferedReader(new InputStreamReader(System.in));
            String respuestaUsuario = consolaInput.readLine();

            // Envia la respuesta del usuario al servidor
            output.println(respuestaUsuario);

            // Lee la respuesta final del servidor
            String respuestaFinal = input.readLine();
            System.out.println("Servidor: " + respuestaFinal);

            // Cierra la conexión con el servidor
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
