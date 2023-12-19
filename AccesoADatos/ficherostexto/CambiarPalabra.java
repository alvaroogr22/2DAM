package ficherostexto;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CambiarPalabra {

    public static void main(String[] args) {

        String rutaArchivo = "c:\\prueba\\ciudades.txt";
        String palabraBuscada = "Sevilla";
        String nuevaPalabra = "Málaga";

        try {
            // Lectura del archivo
            File archivo = new File(rutaArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            // Escritura en el archivo temporal
            File archivoTemporal = new File("temp.txt");
            FileWriter fw = new FileWriter(archivoTemporal);
            BufferedWriter bw = new BufferedWriter(fw);

            String linea;
            while ((linea = br.readLine()) != null) {
                String nuevaLinea = linea.replaceAll(palabraBuscada, nuevaPalabra);
                bw.write(nuevaLinea + "\n");
            }

            // Cierre de recursos
            br.close();
            bw.close();
            fr.close();
            fw.close();

            // Renombrar el archivo temporal al original
            archivo.delete();
            archivoTemporal.renameTo(archivo);

            System.out.println("Palabra cambiada exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al leer/escribir el archivo: " + e.getMessage());
        }
    }
}
