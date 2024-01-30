package ficherosTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2_CrearFichero {

	public static void main(String[] args) {
		String ruta="./prueba1//";
		String nombreArchivo="Marina.txt";
		String contenido="Mi novia Marina es lo mejor que me ha pasado en la vida";
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(ruta+nombreArchivo));
			System.out.println("Archivo 'Marina.txt' creado correctamente.");
			fw.write(contenido);
			fw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error al crear el archivo 'Marina.txt'");
		}
				
	}

}
