package redes;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 2025;
        try {

            Socket cliente = new Socket(host, puerto);
            cliente.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("hola");
    }
}
