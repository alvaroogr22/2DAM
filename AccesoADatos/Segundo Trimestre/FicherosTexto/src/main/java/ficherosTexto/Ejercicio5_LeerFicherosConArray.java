package ficherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio5_LeerFicherosConArray {

	public static void main(String[] args) {
		
		String[] ficherosTexto= {"Marina.txt","ciudades.txt"};
		
		for(String fichero:ficherosTexto) {
			LeerFicheros(fichero);
		}
	}
	
	
	public static void LeerFicheros(String fichero) {
		try {
			File archivo = new File("./prueba1/"+fichero);
			if(!archivo.exists()) {
				System.err.println("El archivo no existe");
			}
			BufferedReader br=new BufferedReader(new FileReader(archivo));
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
