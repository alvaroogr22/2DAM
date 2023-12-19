package ficheros;

import java.io.File;

public class BorrarFicheros6 {
    public static void main(String[] args) {
        String ruta = ".\\src\\ficheros\\ejercicio1";
        String nombreFichero = "fichero1.txt"; // Nombre del fichero que deseas borrar

        // Combinar la ruta del directorio con el nombre del fichero
        String rutaFichero = ruta + File.separator + nombreFichero;

        File fichero = new File(rutaFichero);

        if (fichero.exists()) {
            boolean borrado = fichero.delete();
            if (borrado) {
                System.out.println("El fichero ha sido borrado con éxito.");
            } else {
                System.out.println("No se pudo borrar el fichero.");
            }
        } else {
       System.out.println("El fichero no existe en la ubicación especificada.");
        }
    }
}
