package redes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        int puerto = 2025;
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchado en el puerto: " + servidor.getLocalPort());
        Socket cliente = servidor.accept();
        Socket cliente2 = servidor.accept();
        servidor.close();
    }
}
