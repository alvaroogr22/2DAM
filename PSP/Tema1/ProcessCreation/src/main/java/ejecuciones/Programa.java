package ejecuciones;

import java.io.*;

public class Programa {

  public static void main(String[] args) {
    File ruta = new File("target\\classes");
    ProcessBuilder pb = new ProcessBuilder("java", "ejecuciones.Chrome");
    // ProcessBuilder pb = new ProcessBuilder("java", "ejecuciones.Notepad");

    pb.directory(ruta);

    try {
      Process p = pb.start();
      InputStream is = p.getInputStream();
      int c;
      while ((c = is.read()) != -1) {
        System.out.print((char) c);
      }
      is.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
