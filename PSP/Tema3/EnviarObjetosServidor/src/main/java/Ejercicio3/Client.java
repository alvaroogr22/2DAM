package Ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Configurar el cliente
            Socket socket = new Socket("127.0.0.1", 43456);

            // Configurar flujos de entrada y salida
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Obtener la operación y los números desde el usuario
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese la operación (suma(1), resta(2), multiplicacion(3), division(4)): ");
            String operacion = scanner.nextLine();

            System.out.print("Ingrese el primer número: ");
            double numero1 = scanner.nextDouble();

            System.out.print("Ingrese el segundo número: ");
            double numero2 = scanner.nextDouble();

            // Enviar la operación y los números al servidor
            output.writeUTF(operacion);
            output.writeDouble(numero1);
            output.writeDouble(numero2);

            // Recibir el resultado de vuelta
            double resultado = input.readDouble();
            System.out.println("El resultado de la operación es: " + resultado);

            // Cerrar conexión
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
