package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class PokemonCliente {

  public static void main(String[] args) {
    int puerto = 6000;
    ServerSocket servidor;

    try {
      servidor = new ServerSocket(puerto);
      System.out.println(
        "Esta es la clase Cliente." +
        "\nEsperando al cliente en el puerto: " +
        servidor.getLocalPort()
      );
      Socket cliente = servidor.accept(); //Espera una petición de un cliente, el main se detiene.

      //Prepara el flujo de salida para objetos
      ObjectOutputStream oos = new ObjectOutputStream(
        cliente.getOutputStream()
      );

      //Creamos el objeto que queremos enviar
      Pokemon pokemon1 = new Pokemon("Charizard", 120, 36);

      //Se envía el objeto empleado1
      oos.writeObject(pokemon1);

      System.out.println(
        "Envío: " +
        pokemon1.getNombre() +
        " de nivel " +
        pokemon1.getNivel() +
        " y una vida de " +
        pokemon1.getVida()
      );

      ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

      //Prácticamente es un copia-pega del input del cliente

      pokemon1 = (Pokemon) ois.readObject();

      oos.close();
      cliente.close();
      servidor.close();
    } catch (IOException | ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
