package ficherostexto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class EjercicioFinalTema1 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String opcion;
            String ruta = "C:\\";

            do {
                System.out.println("Seleccione una opción:");
                System.out.println("A - Crear carpeta");
                System.out.println("B - Crear fichero");
                System.out.println("C - Borrar fichero");
                System.out.println("D - Borrar carpeta");
                System.out.println("E - Leer fichero");
                System.out.println("F - Salir");
                //podemos añadir ver información del archivo
                opcion = scanner.nextLine();

                switch (opcion) {
                    case "A":
                        System.out.println("Introduzca el nombre de la carpeta:");
                        String nombreCarpeta = scanner.nextLine();
                        File carpeta = new File(ruta + nombreCarpeta);

                        if (!carpeta.exists()) {
                            carpeta.mkdirs(); // crea la carpeta si no existe
                            System.out.println("La carpeta " + nombreCarpeta + " se ha creado correctamente.");
                        } else {
                            System.out.println("La carpeta " + nombreCarpeta + " ya existe.");
                        }
                        break;

                    case "B":
                        System.out.println("Introduzca el nombre de la carpeta:");
                        String nombreCarpetaFichero = scanner.nextLine();
                        File carpetaFichero = new File(ruta + nombreCarpetaFichero);

                        if (carpetaFichero.exists()) {
                            System.out.println("Introduzca el nombre del fichero:");
                            String nombreFichero = scanner.nextLine();

                            try (BufferedWriter bw = new BufferedWriter(
                                    new FileWriter(ruta + nombreCarpetaFichero + "\\" + nombreFichero + ".txt"))) {
                                System.out.println("Introduzca el nombre:");
                                String nombre = scanner.nextLine();
                                bw.write("Nombre: " + nombre);
                                bw.newLine();

                                System.out.println("Introduzca los apellidos:");
                                String apellidos = scanner.nextLine();
                                bw.write("Apellidos: " + apellidos);
                                bw.newLine();

                                System.out.println("Introduzca la dirección:");
                                String direccion = scanner.nextLine();
                                bw.write("Dirección: " + direccion);

                                System.out.println("Fichero creado correctamente.");
                            } catch (IOException e) {
                                System.out.println("No se ha podido escribir en el fichero");
                            }
                        } else {
                            System.out.println("La carpeta " + nombreCarpetaFichero + " no existe.");
                        }
                        break;

                    case "C":
                        System.out.println("Introduzca el nombre de la carpeta:");
                        String nombreCarpetaBorrarFichero = scanner.nextLine();
                        File carpetaBorrarFichero = new File(ruta + nombreCarpetaBorrarFichero);

                        if (carpetaBorrarFichero.exists()) {
                            System.out.println("Introduzca el nombre del fichero a borrar:");
                            String nombreFicheroBorrar = scanner.nextLine();
                            File ficheroBorrar = new File(
                                    ruta + nombreCarpetaBorrarFichero + "\\" + nombreFicheroBorrar + ".txt");

                            if (ficheroBorrar.exists()) {
                                ficheroBorrar.delete();
                                System.out.println("El fichero " + nombreFicheroBorrar + ".txt se ha borrado correctamente.");
                            } else {
                                System.out.println("El fichero " + nombreFicheroBorrar + ".txt no existe.");
                            }
                        } else {
                            System.out.println("La carpeta " + nombreCarpetaBorrarFichero + " no existe.");
                        }
                        break;

                    case "D":
                        System.out.println("Introduzca el nombre de la carpeta a borrar:");
                        String nombreCarpetaBorrar = scanner.nextLine();
                        File carpetaBorrar = new File(ruta + nombreCarpetaBorrar);

                        if (carpetaBorrar.exists()) {
                            // Borrar carpeta y su contenido
                            FileUtils.deleteDirectory(carpetaBorrar);
                            System.out.println("La carpeta " + nombreCarpetaBorrar + " se ha borrado correctamente.");
                        } else {
                            System.out.println("La carpeta " + nombreCarpetaBorrar + " no existe.");
                        }
                        break;

                    case "E":
                        System.out.println("Introduzca el nombre de la carpeta:");
                        String nombreCarpetaLeer = scanner.nextLine();
                        File carpetaLeer = new File(ruta + nombreCarpetaLeer);

                        if (carpetaLeer.exists()) {
                            System.out.println("Introduzca el nombre del fichero a leer:");
                            String nombreFicheroLeer = scanner.nextLine();
                            File ficheroLeer = new File(ruta + nombreCarpetaLeer + "\\" + nombreFicheroLeer + ".txt");

                            if (ficheroLeer.exists()) {
                                try (BufferedReader br = new BufferedReader(new FileReader(ficheroLeer))) {
                                    String linea;
                                    while ((linea = br.readLine()) != null) {
                                        System.out.println(linea);
                                    }
                                } catch (IOException e) {
                                    System.out.println("No se puede leer el fichero.");
                                }
                            } else {
                                System.out.println("El fichero " + nombreFicheroLeer + ".txt no existe en la carpeta.");
                            }
                        } else {
                            System.out.println("La carpeta " + nombreCarpetaLeer + " no existe.");
                        }
                        break;

                    case "F":
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

            } while (!opcion.equals("F"));

            scanner.close();

        } catch (IOException ioe) {
            System.out.println("Error en la operación.");
        }
    }
}
