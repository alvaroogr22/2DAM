package examenFinalAD;

import java.io.*;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

public class MainModeloVista {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte opcion;
        String ruta = ".\\";
        String nombreCarpeta;
        String nombreArchivo = null;

        do {
            //Creamos el menú por opciones
            System.out.println();
            System.out.println("Elige una opción:" +
                    "\n\t0 - Salir" +
                    "\n\t1 - Crear carpeta" +
                    "\n\t2 - Crear fichero" +
                    "\n\t3 - Borrar Fichero" +
                    "\n\t4 - Borrar Carpeta" +
                    "\n\t5 - Leer Fichero" +
                    "\n\t6 - Leer Carpeta");

            opcion = Byte.parseByte(sc.nextLine());
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo");
                    break;

                case 1: //Creación de directorio
                    System.out.println("Introduzca el nombre de la carpeta:");
                    nombreCarpeta = sc.nextLine();
                    File carpeta = new File(ruta + nombreCarpeta);

                    if (carpeta.mkdir()) {
                        System.out.println("Carpeta creada.");
                    } else {
                        System.out.println("No se pudo crear la carpeta.");
                    }
                    break;

                case 2: //Creación de archivo
                    System.out.println("Dime el nombre del archivo. Recuerda que tenga la extensión .txt");
                    nombreArchivo = sc.nextLine();
                    System.out.println("¿Quieres escribir un mensaje en el fichero? S/N");
                    String respuesta = sc.nextLine();

                    try (BufferedWriter fw = new BufferedWriter(new FileWriter(ruta + nombreArchivo))) {
                        System.out.println("Archivo " + nombreArchivo + " creado correctamente.");
                        if (respuesta.equalsIgnoreCase("S")) {
                            System.out.println("Escribe el mensaje que contendrá el fichero:");
                            String contenido = sc.nextLine();
                            fw.write(contenido);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3: //Borrar archivos
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

                case 4: //Borrar directorios
                    System.out.println("Introduzca el nombre de la carpeta que desea borrar:");
                    nombreCarpeta = sc.nextLine();
                    File carpetaBorrar = new File(ruta + nombreCarpeta);

                    if (carpetaBorrar.exists()) {
                        try {
                            FileUtils.deleteDirectory(carpetaBorrar);
                            System.out.println("La carpeta " + carpetaBorrar + " se ha borrado correctamente.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("La carpeta " + carpetaBorrar + " no existe.");
                    }
                    break;

                case 5: //Leer fichero
                    System.out.println("Dime el nombre del archivo que quieres leer");
                    nombreArchivo = sc.nextLine();
                    leerArchivo(ruta + nombreArchivo);
                    break;

                case 6: //Leer directorio
                    System.out.println("Dime el nombre de la carpeta de la que quieres información");
                    nombreCarpeta = sc.nextLine();
                    leerCarpeta(ruta + nombreCarpeta);
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 0);
        sc.close();
    }
    //Función de leer archivo
    private static void leerArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
    //Función de leer carpeta
    private static void leerCarpeta(String rutaCarpeta) {
        File carpeta = new File(rutaCarpeta);
        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            for (File archivo : archivos) {
                System.out.println(archivo.getName());
            }
        } else {
            System.out.println("La carpeta no existe.");
        }
    }
}
