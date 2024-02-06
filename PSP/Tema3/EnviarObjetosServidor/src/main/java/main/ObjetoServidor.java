package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjetoServidor {

  public static void main(String[] args) {
    int puerto = 6000;
    ServerSocket servidor;

    try {
      servidor = new ServerSocket(puerto);
      System.out.println(
        "Esperando al cliente en el puerto: " + servidor.getLocalPort()
      );
      Socket cliente = servidor.accept(); //Espera una petición de un cliente, el main se detiene.

      //Prepara el flujo de salida para objetos
      ObjectOutputStream oos = new ObjectOutputStream(
        cliente.getOutputStream()
      );

      //Creamos el objeto que queremos enviar
      Empleados empleado1 = new Empleados("Alvaro", 3000);

      //Se envía el objeto empleado1
      oos.writeObject(empleado1);

      System.out.println(
        "Envío: " +
        empleado1.getNombre() +
        " con un sueldo mensual de " +
        empleado1.getSueldo()
      );

      ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());

      //Prácticamente es un copia-pega del input del cliente

      empleado1 = (Empleados) ois.readObject();
      System.out.println(
        "Se ha recibido al empleado " +
        empleado1.getNombre() +
        " con la modificación de sueldo a " +
        empleado1.getSueldo() +
        " euros."
      );

      oos.close();
      cliente.close();
      servidor.close();
    } catch (IOException | ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
