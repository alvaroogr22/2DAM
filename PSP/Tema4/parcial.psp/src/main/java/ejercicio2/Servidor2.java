package ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor2 {
	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 61000;

		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando al cliente en el puerto: " + puerto);
			cliente = servidor.accept();
			
			InputStream input = cliente.getInputStream(); // Recibe entrada de bajo nivel
			ObjectInputStream ois = new ObjectInputStream(input); // Transforma ese bajo nivel en proceso
			Pikachu pikaRecibido = (Pikachu) ois.readObject();
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			oos.writeObject("¿Quieres usar piedratrueno en tu " + pikaRecibido.getNombre() + "? (Y/N)");
			
			String respuestaRecibida = ois.readObject().toString();
			String mensaje="";
			if(respuestaRecibida.toUpperCase().equals("Y")) {
				pikaRecibido = (Pikachu) ois.readObject();
				mensaje = ois.readObject().toString();
			}else {
				mensaje = ois.readObject().toString();
			}
			System.out.println(mensaje);

			cliente.close();
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();	
		}
	}
}	
