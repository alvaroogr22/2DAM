package ficherosTexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Ejercicio3_CrearFicheroConTextoArray {

	public static void main(String[] args) {
		String ruta="./prueba1//";
		String nombreArchivo="ciudades.txt";
		String []contenido= {"Malaga","Cordoba","Cadiz","Jaen"};
		
		try {
			BufferedWriter fw=new BufferedWriter(new FileWriter(ruta+nombreArchivo));
			System.out.println("Archivo 'ciudades.txt' creado correctamente");
			
			for(String content:contenido) {
				fw.write(content+"\n");
				fw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("Error al crear el archivo 'ciudades.txt'");
		}

	}

}
