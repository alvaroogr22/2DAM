package ficherostexto;

import java.io.*;

public class Ejercicio4LeerFicheros {

    public static void main(String[] args) {
       
        try {
            // Creamos el archivo malaga.txt
            File archivo = new File("c:/prueba1/ciudades.txt");
            // Verificamos si el archivo existe antes de intentar leerlo
            if (!archivo.exists()) {
                System.out.println("El archivo ciudades.txt no existe.");
                return; // Salimos del programa si el archivo no existe
            }
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            // Leemos el contenido del fichero malaga.txt
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            // Cerramos los recursos
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


