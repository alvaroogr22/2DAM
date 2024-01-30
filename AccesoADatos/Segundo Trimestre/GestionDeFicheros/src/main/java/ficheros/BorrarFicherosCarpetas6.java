package ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;
//hay que tener cuidado con la versi�n debe ser la adecuada///

public class BorrarFicherosCarpetas6 {
	public static void main(String[] args) {
		try {

			// no añade, pisa el fichero con los datos que se metan si se ejecuta de nuevo

			Scanner scanner = new Scanner(System.in);
			String opcion;
			String ruta = "C:\\prueba\\";

			do {
				System.out.println("Seleccione una opci�n:");
				System.out.println("A - Crear carpeta");
				System.out.println("B - Borrar carpeta");
				System.out.println("C - Salir");

				opcion = scanner.nextLine();

				switch (opcion) {
				case "A":
					System.out.println("Introduzca el nombre de la carpeta:");
					String nombreCarpeta = scanner.nextLine();

					File carpeta = new File(ruta + nombreCarpeta);

					if (!carpeta.exists()) {

						carpeta.mkdirs(); // crea la carpeta si no existe
						System.out.println("La carpeta " + nombreCarpeta + " se ha creado correctamente.");
						// escribir el nombre del fichero y de la carpeta"
						BufferedWriter bw = new BufferedWriter(
								new FileWriter(ruta + nombreCarpeta + "\\" + nombreCarpeta + ".txt"));
						bw.write(nombreCarpeta);

						System.out.println("Fichero creado");

						bw.close();
					} else {
						System.out.println("La carpeta " + nombreCarpeta + " ya existe.");
					}
					break;

				case "B":
					System.out.println("Introduzca el nombre de la carpeta que desea borrar:");
					String nombreCarpetaBorrar = scanner.nextLine();
					File carpetaBorrar = new File(ruta + nombreCarpetaBorrar);

					if (carpetaBorrar.exists()) {
						FileUtils.deleteDirectory(carpetaBorrar);
						carpetaBorrar.delete();
						System.out.println("La carpeta " + nombreCarpetaBorrar + " se ha borrado correctamente.");
					} else {
						System.out.println("La carpeta " + nombreCarpetaBorrar + " no existe.");
					}
					break;

				case "C":
					System.out.println("Saliendo...");
					break;

				default:
					System.out.println("Opci�n inv�lida.");
					break;
				}

			} while (!opcion.equals("C"));

			scanner.close();

		} catch (IOException ioe) {
			System.out.println("No se ha podido escribir en el fichero");
		}
	}
}
