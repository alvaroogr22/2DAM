package ficherostexto;

import java.io.File;

public class ExisteFile {
	public static void main(String[] args) {
				String nombreFichero = "c:\\prueba\\malaga.txt";
		File fichero = new File(nombreFichero);
		if (fichero.exists()) {
			fichero.delete();
			System.out.println("El fichero se ha borrado correctamente.");
		} else {
			System.out.println("El fichero " + nombreFichero + " no existe.");
		}
	}
}