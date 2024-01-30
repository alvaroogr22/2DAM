package menuExamen;

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
		String ruta = ".\\";
		String nombreCarpeta;
		String nombreArchivo = null;
		String nombreCarpetaBorrar = null;
		String respuesta = null;

		do {
			System.out.println();
			System.out.println("Elige una opción:" + "\n\t0 - Salir" + "\n\t1 - Crear carpeta" + "\n\t2 - Crear fichero"
					+ "\n\t3 - Borrar Fichero" + "\n\t4 - Borrar Carpeta" + "\n\t5 - Leer Fichero"
					+ "\n\t6 - Leer Carpeta");

			opcion = Byte.parseByte(sc.nextLine());
			switch (opcion) {
			case 0: //Si el usuario selecciona esta opción, saldrá de la ejecución.
				System.out.println("Saliendo");
				break;

			case 1: //Al seleccionar esta opción, se crea una carpeta. El usuario introducirá el nombre de la misma y se creará en la carpeta del examen.
				System.out.println("Introduzca el nombre de la carpeta:");
				nombreCarpeta = sc.nextLine();

				File carpeta = new File(nombreCarpeta);

				if (carpeta.mkdir()) {
					System.out.println("Carpeta creada.");
				} else {
					System.out.println("No se pudo crear la carpeta.");
					if (carpeta.exists()) {
						System.out.println("La carpeta ya existe.");
					}
				}
				break;

			case 2: //Al seleccionar esta opción, se crea un fichero en formato txt. El usuario introducirá el nombre del fichero y luego, si quiere introducir algún mensaje. En caso afirmativo, podrá escribirlo y se creará el fichero con ese contenido. En caso negativo, se creará un archivo vacío.
				BufferedWriter fw = null;
				System.out.println("Dime el nombre del archivo. Recuerda que tenga la extensión .txt");
				nombreArchivo = sc.nextLine()+".txt";
				System.out.println("¿Quieres escribir un mensaje en el fichero? S/N");
				respuesta = sc.nextLine();
				if (respuesta.equalsIgnoreCase("S")) {
					System.out.println("Escribe el mensaje que contendrá el fichero");
					String contenido = sc.nextLine();
					try {
						fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Archivo " + nombreArchivo + " creado correctamente.");
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
				}
				if (respuesta.equalsIgnoreCase("N")) {
					try {
						fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Archivo " + nombreArchivo + " creado correctamente.");
					break;
				}
				System.out.println("Error al introducir la respuesta. Introduce S/N");
				break;
				
				
			case 3: //Al seleccionar esta opción, se elimina un fichero en formato txt. El usuario introducirá el nombre del fichero y, si existe, se borrará. 
				//IMPORTANTE: Para que funcione tiene que crearse el archivo en una ejecución y borrarlo en una ejecución distinta
				
				System.out.println("Dime el nombre del archivo que quieres borrar");
                nombreArchivo = sc.nextLine();
                File archivoBorrar = new File(ruta + nombreArchivo);

                if (archivoBorrar.exists()) {
                    boolean borrado = archivoBorrar.delete();
                    if (borrado) {
                        System.out.println("El fichero " + nombreArchivo + " ha sido borrado con éxito.");
                    } else {
                        System.out.println("No se pudo borrar el fichero.");
                    }
                } else {
                    System.out.println("El fichero no existe en la ubicación especificada.");
                }
                break;
     

			case 4://Al seleccionar esta opción, eliminará una carpeta. El usuario introducirá el nombre de la carpeta y, si existe, se borrará. Si no, aparecerá un mensaje diciendo que la carpeta no existe y se volverá al menú principal.
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

			case 5: //Al seleccionar esta opción, leerá el contenido de un fichero .txt. El usuario introducirá el nombre del fichero y, si existe, se mostrará el contenido. Si no, aparecerá un mensaje diciendo que la carpeta no existe y se volverá al menú principal.
				System.out.println("Dime el nombre del archivo que quieres leer");
				nombreArchivo = sc.nextLine();
				File archivo = new File(ruta + nombreArchivo);
				if (!archivo.exists()) {
					System.err.println("El archivo no existe");
					return; // para salir del programa
				}

				try {
					FileReader fr = new FileReader(archivo);
					BufferedReader br = new BufferedReader(fr);
					String linea;
					while ((linea = br.readLine()) != null) {
						System.out.println("El contenido del archivo es: \n"
								+linea);
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
			case 6: //Al seleccionar esta opción, mostrará la metadata de una carpeta. El usuario introducirá el nombre de la carpeta y, si existe, mostrará el nombre, su ruta relativa, absoluta, la lectura, la escritura, su tamaño en kb, si es un directorio y si es un fichero, así como su directorio padre.
				System.out.println("Dime el nombre de la carpeta de la que quieres información");
				File direc = new File(sc.nextLine());
				if (direc.exists()) {
					System.out.println("Nombre del directorio: " + direc.getName());
					System.out.println("Ruta: " + direc.getPath());
					System.out.println("Ruta absoluta: " + direc.getAbsolutePath());
					System.out.println("Lectura: " + direc.canRead());
					System.out.println("Escritura: " + direc.canWrite());
					System.out.println("Tamaño: " + direc.length() + " Kb");
					System.out.println("Directorio: " + direc.isDirectory());
					System.out.println("Fichero: " + direc.isFile());
					System.out.println("Nombre del directorio padre: " + direc.getParent());
				} else {
					System.out.println("El directorio no existe");
				}

			}

		} while (opcion != 0);
		sc.close();

	}
}
