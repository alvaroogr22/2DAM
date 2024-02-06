package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjetoCliente {

  public static void main(String[] args) {
    String host = "localhost";
    int puerto = 6000;

    Socket cliente;
    try {
      cliente = new Socket(host, puerto);
      System.out.println(
        "Conectado con el servidor en el puerto " + cliente.getPort()
      );

      //Flujo de entrada para objetos
      ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

      //Le decimos que va a recibir un objeto de la clase Empleados. No tiene que llamarse igual que el objeto que hemos enviado. Debemos crear una excepción por si la clase no existiese.

      Empleados empleado1 = (Empleados) ois.readObject();
      System.out.println("Se ha recibido al empleado " + empleado1.getNombre());

      //Podemos modificar el objeto recibido con sus métodos setter (empleado)
      empleado1.setSueldo(4000);

      //Flujo de salida para objetos (Igual que el servidor)
      ObjectOutputStream oos = new ObjectOutputStream(
        cliente.getOutputStream()
      );

      //Enviamos el objeto empleado
      oos.writeObject(empleado1);

      System.out.println(
        "Se ha modificado el sueldo del empleado " +
        empleado1.getNombre() +
        " a " +
        empleado1.getSueldo() +
        "€. "
      );

      //Cerramos todas las entradas y el socket
      ois.close();
      oos.close();
      cliente.close();
    } catch (IOException | ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
