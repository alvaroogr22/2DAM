package ficherostexto;

import java.io.File;
public class Ejercicio6ListarFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f=new File("c:\\prueba");
		String [] ficheros=f.list();
		for (String nomfile: ficheros) {
			System.out.println(nomfile); 
			
			
		}
			
		
	}

}
