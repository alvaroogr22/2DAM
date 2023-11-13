package ejecuciones;

import java.io.*;

public class CMD {

  public static void main(String[] args){
    // ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "ipconfig");
    ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "tasklist");

    try {
      Process p = pb.start();

      InputStream is = p.getInputStream();

      int c;
      while ((c = is.read()) != -1) {
        System.out.print((char) c);
      }
      is.close();
      InputStream err = p.getErrorStream();
      int errc;
      while ((errc = err.read())!= -1) {
        System.out.print((char) errc);
      }
    } catch (Exception e) {
        e.printStackTrace();
        }
  }
}
