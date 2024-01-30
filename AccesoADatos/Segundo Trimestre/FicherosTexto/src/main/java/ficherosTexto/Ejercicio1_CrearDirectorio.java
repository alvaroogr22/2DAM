package ficherosTexto;

import java.io.File;

public class Ejercicio1_CrearDirectorio {

	public static void main(String[] args) {
		String ruta = "./prueba1";
		File fichero = new File(ruta);
		
		if(fichero.mkdir()) {
			System.out.println("Carpeta creada.");
		} else {
			System.out.println("No se pudo crear la carpeta.");
			if(fichero.exists()) {
				System.out.println("La carpeta ya existe.");
			}
		}
	}
}