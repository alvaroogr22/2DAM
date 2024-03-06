package ejercicio2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String host = "localhost";
    int puerto = 61000;
    Haunter pokemon = new Haunter("Haunter", 80, 20, 30);

    try {
      Socket cliente = new Socket(host, puerto);

      ObjectOutputStream oos = new ObjectOutputStream(
        cliente.getOutputStream()
      );

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
      ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

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
        System.out.println("Que lastima");
      }

      ois.close();
      oos.close();
      cliente.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
