package Ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;
import java.net.*;

public class EjServidorDinero {
    public static void main(String[] args) throws IOException {
        int numeropuerto = 6000;
        System.out.println("Esperando al cliente....");
        ServerSocket servidor = new ServerSocket(numeropuerto);
        Socket clienteConectado = servidor.accept();

        InputStream entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);

        double cantidadEuros = flujoEntrada.readDouble(); // Leemos la cantidad de euros enviada por el cliente

        // Realizamos la conversión de euros a dólares y libras esterlinas
        double cantidadDolares = cantidadEuros * 1.12; // Suponiendo un cambio fijo de 1 euro = 1.12 dólares
        double cantidadLibras = cantidadEuros * 0.87; // Suponiendo un cambio fijo de 1 euro = 0.87 libras esterlinas

        OutputStream salida = clienteConectado.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);

        // Enviamos la cantidad convertida al cliente
        flujoSalida.writeDouble(cantidadDolares);
        flujoSalida.writeDouble(cantidadLibras);

        // Cerramos streams y sockets
        entrada.close();
        flujoEntrada.close();
        salida.close();
        flujoSalida.close();
        clienteConectado.close();
        servidor.close();
    }
}