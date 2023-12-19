package ficheros;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class BorrarCarpeta7 {
    public static void main(String[] args) throws IOException {
        // Especifica la ruta de la carpeta que quieres borrar
        File carpeta = new File("/ruta/a/la/carpeta");

        // Borra la carpeta y todos sus archivos y subdirectorios
        if (carpeta.exists() && carpeta.isDirectory()) {
            System.out.println("El directorio existe.");
            FileUtils.deleteDirectory(carpeta);
            System.out.println("El directorio ha sido borrado.");
        } else {
            System.out.println("El directorio no existe o no es un directorio válido.");
        }
        
    }
}
