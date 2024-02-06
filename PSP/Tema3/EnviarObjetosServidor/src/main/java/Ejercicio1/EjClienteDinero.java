package Ejercicio1;

import java.io.*;
import java.net.*;

public class EjClienteDinero{
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;
        System.out.println("PROGRAMA CLIENTE INICIADO.....");
        Socket cliente = new Socket(host, puerto);

        double cantidadEuros = 100; // Cantidad de euros que deseas convertir
        OutputStream salida = cliente.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        // Enviamos la cantidad de euros al servidor
        flujoSalida.writeDouble(cantidadEuros);

        // Creamos un flujo de entrada para recibir las cantidades convertidas del servidor
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

        // Recibimos las cantidades convertidas del servidor
        double cantidadDolares = flujoEntrada.readDouble();
        double cantidadLibras = flujoEntrada.readDouble();

        System.out.println("Cantidad de euros convertida a dólares: " + cantidadDolares);
        System.out.println("Cantidad de euros convertida a libras: " + cantidadLibras);

        // Cerramos streams y socket
        flujoSalida.close();
        flujoEntrada.close();
        cliente.close();
    }
}