package ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Cliente {

  public static void main(String[] args) {
    Socket cliente = null;
    Scanner sc = new Scanner(System.in);
    try {
      cliente = new Socket("localhost", 6000);

      InputStream input = cliente.getInputStream(); // Recibe entrada de bajo nivel
      ObjectInputStream ois = new ObjectInputStream(input); // Transforma ese bajo nivel en proceso
      String cadenaLeida = ois.readObject().toString(); // Transforma el objeto en una cadena de texto y lo lee
      System.out.println("Servidor: " + cadenaLeida);

      ObjectOutputStream oos = new ObjectOutputStream(
        cliente.getOutputStream()
      );
      MessageDigest md = MessageDigest.getInstance("MD5");
      String texto = sc.nextLine();
      byte dataBytes[] = texto.getBytes(); // Texto a bytes
      md.update(dataBytes); // Se introduce texto en bytes a resumir
      byte resumen[] = md.digest();
      oos.writeObject(Hexadecimal(resumen));

      System.out.println("Fin del mensaje");

      cliente.close();
    } catch (
      IOException | ClassNotFoundException | NoSuchAlgorithmException e
    ) {
      e.printStackTrace();
    }
  }

  // Convierte un array de bytes en hexadecimal
  static String Hexadecimal(byte[] resumen) {
    String hex = " ";
    for (int i = 0; i < resumen.length; i++) {
      String h = Integer.toHexString(resumen[i] & 0xFF);
      if (h.length() == 1) hex += "0";
      hex += h;
    }
    return hex.toUpperCase();
  }
}
