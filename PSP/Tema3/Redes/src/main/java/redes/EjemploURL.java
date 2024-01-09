package redes;

import java.net.*;

public class EjemploURL {

  public static void main(String[] args) {
    URL url;
    try {
      System.out.println("Constructor simple para una URL");
      url = new URL("https://youtube.com/watch?v=euOEE1lK410");
      Visualizar(url);
    } catch (MalformedURLException e) {
      System.out.println(e);
    }
  }

  private static void Visualizar(URL url) {
    System.out.println("\tURL complete: " + url);
    System.out.println("\tgetProtocol(): " + url.getProtocol());
    System.out.println("\tgetHost(): " + url.getHost());
    System.out.println("\tgetDefaultPort(): " + url.getHost());
    System.out.println("\tgetPort(): " + url.getPort());
    System.out.println("\tgetPath(): " + url.getPath());
    System.out.println("\tgetQuery(): " + url.getQuery());
    System.out.println("\tgetFile(): " + url.getFile());
    System.out.println("\tgetAuthority(): " + url.getAuthority());
    System.out.println("================================================");
  }
}
