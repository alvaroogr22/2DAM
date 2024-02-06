package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class PokemonServidor {

  public static void main(String[] args) {
    String host = "localhost";
    int puerto = 6000;
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    Socket cliente;
    try {
      cliente = new Socket(host, puerto);
      System.out.println(
        "Esta es la clase Servidor." +
        "\nConectado con el servidor en el puerto " +
        cliente.getPort()
      );

      // Flujo de entrada para objetos
      ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

      // Le decimos que va a recibir un objeto de la clase Empleados. No tiene que
      // llamarse igual que el objeto que hemos enviado. Debemos crear una excepción
      // por si la clase no existiese.

      Pokemon pokemon1 = (Pokemon) ois.readObject();
      ObjectOutputStream oos = new ObjectOutputStream(
        cliente.getOutputStream()
      );
      System.out.println("Se ha recibido al pokemon " + pokemon1.getNombre());
      System.out.println("Entrenador Pancetero quiere luchar. ¿Aceptas? (Y/N)");
      String respuesta = sc.nextLine();

      if (respuesta.equalsIgnoreCase("N")) {
        oos.writeObject(pokemon1);
        System.out.println("Te has rajao");
        ois.close();
        oos.close();
        cliente.close();
      }
      if (respuesta.equalsIgnoreCase("Y")) {
        int numeroAzar = r.nextInt(0, 101);
        if (numeroAzar < 50) {
          pokemon1.setVida(0);
          oos.writeObject(pokemon1);
          System.out.println(
            "El numero que ha salido es el " +
            numeroAzar +
            ". Has perdido" +
            "\nPokemon: " +
            pokemon1.getNombre() +
            ", vida: " +
            pokemon1.getVida()
          );
          ois.close();
          oos.close();
          cliente.close();
        } else {
          pokemon1.setNivel(pokemon1.getNivel() + 1);
          oos.writeObject(pokemon1);
          System.out.println(
            "El numero que ha salido es el " +
            numeroAzar +
            ". Has ganado." +
            "\nPokemon: " +
            pokemon1.getNombre() +
            ", nivel: " +
            pokemon1.getNivel()
          );
          ois.close();
          oos.close();
          cliente.close();
        }
      }
    } catch (IOException | ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
