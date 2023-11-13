package ejecuciones;

public class Calculadora {

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
