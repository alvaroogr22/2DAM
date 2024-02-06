package main;

import java.io.*;
import java.net.*;

public class EjemploServidor {

  public static void main(String[] args) throws IOException {
    //APERTURA DEL SOCKETç

    int numeroPuerto = 6000;
    //En el programa servidor se crea un objeto ServerSocket invocando al método ServerSocket()
    //en el que indicamos el número de puerto por el que el servidor escucha las peticiones de conexión de clientes.| ServerSocket servidor = new ServerSocket (numeroPuerto);
    ServerSocket servidor = new ServerSocket(numeroPuerto);
    System.out.println("Esperando al cliente....");
    //Necesitamos tambien un objeto Socket para aceptar las peticiones clientes.
    Socket clienteConectado = servidor.accept();
    // CREO FLUJO DE ENTRADA DEL CLIENTE
    InputStream entrada = clienteConectado.getInputStream();
    DataInputStream flujoEntrada = new DataInputStream(entrada);
    // EL CLIENTE ENVIA UN MENSAJE
    System.out.println("Recibiendo del CLIENTE: \n\t" + flujoEntrada.readUTF());
    // CREO FLUJO DE SALIDA AL CLIENTE
    OutputStream salida = clienteConectado.getOutputStream();
    DataOutputStream flujoSalida = new DataOutputStream(salida);
    // ENVIO UN SALUDO AL CLIENTE
    flujoSalida.writeUTF("Hola, don José.");
    // CERRAR STREAMS Y SOCKETS
    entrada.close();
    flujoEntrada.close();
    salida.close();
    flujoSalida.close();
    clienteConectado.close();
    servidor.close();
  }
}
