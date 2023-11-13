package ejecuciones;

public class Paint {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ProcessBuilder pb = new ProcessBuilder("mspaint");
    try {
      Process p = pb.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
