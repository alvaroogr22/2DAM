package redes;

import java.net.*;

public class PruebaInetAddress {

  public static void connect(String[] args) {
    InetAddress dir;
    System.out.println("================================================");
    System.out.println("SALIDA PARA LOCALHOST: ");
    try {
      dir = InetAddress.getLocalHost();
      pruebaMetodos(dir);
      System.out.println("================================================");
      System.out.println("");
      dir = InetAddress.getByName("WWW.CENECMALAGA.ES");
      pruebaMetodos(dir);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

  private static void pruebaMetodos(InetAddress dir) {
    System.out.println("\tMetodo getLocalHost(): " + dir);
  }
}
