package ficheros;

import java.io.*;
public class VerInformacionFicheros2 {
public static void main(String[] args) {
  System.out.println("INFORMACIÓN SOBRE EL FICHERO:");
  File f = new File(".\\src\\ficheros\\VerInformacionDirectorios1.java");
  System.out.println(f.getName());
  
   if(f.exists()){
        System.out.println("Nombre del fichero  : "+f.getName());
        System.out.println("Ruta                : "+f.getPath());
        System.out.println("Ruta absoluta       : "+f.getAbsolutePath());
        System.out.println("Lectura       : "+f.canRead());
        System.out.println("Escritura   : "+f.canWrite());
        System.out.println("Tamaño              : "+f.length()+ " Kb"); // El tamaño es expresado en bytes
		System.out.println("Directorio    : "+f.isDirectory()); 
		System.out.println("Fichero       : "+f.isFile());
		System.out.println("Nombre del directorio padre: "+f.getParent());
  }else {
	  System.out.println("No existe");
  }
 }
}

