package ejecuciones;

import java.io.*;
import java.util.Scanner;

public class CambioDeHora {

  private static void cambiarFecha(Process p, String fecha) {
    OutputStream os = p.getOutputStream();
    OutputStreamWriter ow = new OutputStreamWriter(os);
    BufferedWriter bw = new BufferedWriter(ow);
    try {
      bw.write(fecha);
      bw.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void mostrarResultadosDir(Process p) {
    InputStream is = p.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String linea;
    try {
      while ((linea = br.readLine()) != null) {
        System.out.println(linea);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void mostrarErroresDir(Process p) {
    InputStream is = p.getErrorStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String linea;
    try {
      while ((linea = br.readLine()) != null) {
        System.out.println(linea);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    System.out.println("Dame la nueva fecha: ");
    String fecha = teclado.nextLine();
    ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "date");

    try {
      Process p = pb.start();
      cambiarFecha(p, fecha);
      p.waitFor();
      mostrarResultadosDir(p);
      mostrarErroresDir(p);
    } catch (Exception e) {
      System.out.println("Error al lanzar el comando en cmd");
    }
  }
}
