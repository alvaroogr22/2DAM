package ejecuciones;

public class Investiga {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ProcessBuilder pb = new ProcessBuilder("Calc");
    try {
      Process p = pb.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
