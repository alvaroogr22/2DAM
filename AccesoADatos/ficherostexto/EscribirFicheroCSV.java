package ficherostexto;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribirFicheroCSV {

    public static void main(String[] args) {
        FileWriter fichero = null;
        PrintWriter escribir = null;

        try {
            Scanner datosScanner = new Scanner(System.in);
            System.out.print("Introduce los datos a escribir: ");
            String datos = datosScanner.nextLine();

            fichero = new FileWriter("datos.csv");
            escribir = new PrintWriter(fichero);

            escribir.print(datos);
            escribir.print(",Escribimos desde Eclipse");

            System.out.println("Datos escritos correctamente en datos.csv");

        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        } finally {
            try {
                if (fichero != null)
                    fichero.close();
            } catch (Exception e2) {
                System.out.println("Error al cerrar el archivo: " + e2.getMessage());
            }
        }
    }
}
