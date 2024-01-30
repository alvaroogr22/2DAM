package ficherosTexto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio4_LeerFicheros {

	public static void main(String[] args) {
		File archivo=new File("./prueba1/ciudades.txt");
		if(!archivo.exists()) {
			System.err.println("El archivo no existe");
			return; //para salir del programa
		}
		
		try {
			FileReader fr = new FileReader(archivo);
			BufferedReader br=new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
