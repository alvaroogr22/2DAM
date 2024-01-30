package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		byte opcion;
		String ruta = "./simulacroGestionFicheros/";
		String nombreCarpeta;
		String nombreArchivo = null;
		String nombreCarpetaBorrar=null;

		do {
			System.out.println();
			System.out.println("Elige una opción:"
					+ "\n\t0 - Salir"
					+ "\n\t1 - Crear carpeta"
					+ "\n\t2 - Crear fichero"
					+ "\n\t3 - Borrar Fichero"
					+ "\n\t4 - Borrar Carpeta"
					+ "\n\t5 - Leer Fichero");
			
			opcion = Byte.parseByte(sc.nextLine());
			switch (opcion) {
			case 0:
				System.out.println("Saliendo");
				break;
				
			case 1:
				System.out.println("Introduzca el nombre de la carpeta:");
				nombreCarpeta = sc.nextLine();

				File carpeta = new File(nombreCarpeta);

				if(carpeta.mkdir()) {
					System.out.println("Carpeta creada.");
				} else {
					System.out.println("No se pudo crear la carpeta.");
					if(carpeta.exists()) {
						System.out.println("La carpeta ya existe.");
					}
				}
				break;
				
			case 2:
				System.out.println("Dime el nombre del archivo");
				nombreArchivo=sc.nextLine();
				System.out.println("Escribe el mensaje que contendrá el fichero");
				String contenido=sc.nextLine();
				BufferedWriter fw = null;
				try {
					fw = new BufferedWriter(new FileWriter(ruta+nombreArchivo));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					System.out.println("Archivo 'Marina.txt' creado correctamente.");
				try {
					fw.write(contenido);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fw.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
				
			case 3:
				
				break;
				
			case 4:
				System.out.println("Introduzca el nombre de la carpeta que desea borrar:");
				nombreCarpeta = sc.nextLine();
				File carpetaBorrar = new File(ruta + nombreCarpeta);

				if (carpetaBorrar.exists()) {
					try {
						FileUtils.deleteDirectory(carpetaBorrar);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					carpetaBorrar.delete();
					System.out.println("La carpeta " + carpetaBorrar + " se ha borrado correctamente.");
				} else {
					System.out.println("La carpeta " + carpetaBorrar + " no existe.");
				}
				break;
				
			case 5:
				File archivo=new File(ruta+nombreArchivo);
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
				
				break;

			}

	}while (opcion!=0);
		sc.close();

}
}
