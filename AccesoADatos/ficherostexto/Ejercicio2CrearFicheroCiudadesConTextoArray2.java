package ficherostexto;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Ejercicio2CrearFicheroCiudadesConTextoArray2 {
    public static void main(String[] args) {
        String ruta = "c:\\prueba1\\";
        String nombreArchivo = "productos.txt";
        String [] contenido={"Portatil","Monitor","Móvil","Altavoces"};
        
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
            System.out.println("Archivo productos.txt creado correctamente).");
          
            for (String content: contenido) {
            	fw.write(content+"\n");
            }          
            
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al crear el archivo productos.txt");
        }
    }
}
