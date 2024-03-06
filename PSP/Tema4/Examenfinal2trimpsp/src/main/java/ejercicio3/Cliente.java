package ejercicio3;

import ejercicio2.Haunter;
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
    Haunter pokemon = new Haunter("Haunter", 80, 20, 30);
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

      System.out.println(
        "Nombre:" +
        pokemon.pkName +
        " - Vida:" +
        pokemon.pkVida +
        " - Ataque:" +
        pokemon.pkAtk +
        " - Defensa:" +
        pokemon.pkDef
      );
      System.out.println("¿Quieres que tu Haunter evolucione a Gengar? (Y/N)");
      String respuesta = sc.nextLine();

      oos.writeObject(respuesta);
      if (respuesta.equals("Y")) {
        oos.writeObject(pokemon);

        pokemon = (Haunter) ois.readObject();

        System.out.println(
          "Has recibido un: Nombre:" +
          pokemon.pkName +
          " - Vida:" +
          pokemon.pkVida +
          " - Ataque:" +
          pokemon.pkAtk +
          " - Defensa:" +
          pokemon.pkDef
        );
      } else {
        System.out.println("Muermazo");
      }

      ois.close();
      oos.close();

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
