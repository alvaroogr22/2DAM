package ficherostexto;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Ejercicio2CrearFicheroMalagaConTexto {
    public static void main(String[] args) {
        String ruta = "c:\\prueba1\\";
        String nombreArchivo = "Granada.txt";
        String contenido="Granada es lo mejor del mundo";
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
            System.out.println("Archivo Granada.txt creado correctamente).");
            fw.write(contenido);
                      
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al crear el archivo malaga.txt");
        }
    }
}
