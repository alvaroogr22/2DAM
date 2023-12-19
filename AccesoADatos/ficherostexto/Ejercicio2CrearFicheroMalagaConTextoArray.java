package ficherostexto;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Ejercicio2CrearFicheroMalagaConTextoArray {
    public static void main(String[] args) {
        String ruta = "c:\\prueba1\\";
        String nombreArchivo = "ciudades.txt";
        String [] contenido={"Córdoba","Málaga","Córdoba","Cádiz","Almeria","Huelva","Jaen"};
        
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
            System.out.println("Archivo ciudades.txt creado correctamente).");
          
            for (String content: contenido) {
            	fw.write(content+"\n");
            }          
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al crear el archivo ciudades.txt");
        }
    }
}
