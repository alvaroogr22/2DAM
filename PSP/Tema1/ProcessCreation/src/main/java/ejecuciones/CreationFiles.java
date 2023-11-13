package ejecuciones;

import java.io.*;

public class CreationFiles {

  public static void main(String[] args) {
    ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "tasklist");
    File fOut = new File("Salida.txt");
    File fErr = new File("Error.txt");
    pb.redirectOutput(fOut);
    pb.redirectError(fErr);
    try {
      pb.start();
    } catch (Exception e) {
      // TODO: handle exception
    }
  }
}
