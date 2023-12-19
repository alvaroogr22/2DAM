package ficherostexto;

import java.io.File;

public class Ejercicio1CrearCarpeta {
	public static void main(String[] args) {
	    String ruta = "c:\\prueba1\\";
	    File fichero = new File(ruta);

	    if (fichero.mkdir()) {
	        System.out.println("Carpeta creada");
	    } else {
	        // Manejar errores
	        System.err.println("No se pudo crear la carpeta");
	        if (fichero.exists()) {
	            System.err.println("La carpeta ya existe");
	        }
	    }

	    if (fichero.isDirectory()) {
	        System.out.println(fichero.canRead());
	    }
	}
	}
