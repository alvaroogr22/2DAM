package ficherostexto;

import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2CrearFicheroMalagaVacio {
    public static void main(String[] args) {
        String ruta = "c:\\prueba1\\";
        String nombreArchivo = "malaga.txt";

        try (FileWriter fw = new FileWriter(ruta + nombreArchivo)) {
            System.out.println("Archivo malaga.txt creado correctamente (vacio).");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al crear el archivo malaga.txt");
        }
    }
}
