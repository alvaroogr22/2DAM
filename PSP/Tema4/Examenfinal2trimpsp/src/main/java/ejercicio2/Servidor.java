package ejercicio2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

  public static void main(String[] args) {
    int puerto = 61000;
    ServerSocket servidor;

    try {
      servidor = new ServerSocket(puerto);

      System.out.println(
        "Esperando al cliente en el puerto: " + servidor.getLocalPort()
      );
      Socket cliente = servidor.accept(); // Espera una petición de un cliente, el main se detiene.

      ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
      ObjectOutputStream oos = new ObjectOutputStream(
        cliente.getOutputStream()
      );

      String respuesta = (String) ois.readObject();
      if (respuesta.equals("Y")) {
        Haunter pokemon = (Haunter) ois.readObject();

        String nName = "Gengar";
        System.out.println(pokemon.pkName + " esta evolucionando en " + nName);
        pokemon.pkName = nName;
        pokemon.pkVida = pokemon.pkVida * 2;
        pokemon.pkAtk = pokemon.pkAtk * 2;
        pokemon.pkDef = pokemon.pkDef * 2;
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

        oos.writeObject(pokemon);
      }

      ois.close();
      cliente.close();
      servidor.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
