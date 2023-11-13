package ejecuciones;

public class Chrome {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ProcessBuilder pb = new ProcessBuilder(
      "\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\""
    );
    try {
      Process p = pb.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
