package ejecuciones;

import java.io.*;

public class Notepad {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    ProcessBuilder pb = new ProcessBuilder("Notepad");
    try {
      Process p = pb.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
