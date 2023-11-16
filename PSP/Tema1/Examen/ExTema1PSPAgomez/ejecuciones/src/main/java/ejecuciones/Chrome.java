package ejecuciones;

public class Chrome {

  public static void main(String[] args) {
    //ProcessBuilder pb = new ProcessBuilder("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"");
    ProcessBuilder pb = new ProcessBuilder("CMD","/C","start chrome");
    try {
      Process p = pb.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
