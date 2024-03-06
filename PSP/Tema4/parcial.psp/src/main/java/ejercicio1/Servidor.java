package ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Servidor {
	public static void main(String[] args) {
		ServerSocket servidor = null;
		Socket cliente = null;
		int puerto = 6000;

		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Esperando al cliente en el puerto: " + puerto);
			cliente = servidor.accept();
			
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String texto = "cenec";
			byte dataBytes[] = texto.getBytes(); // Texto a bytes
			md.update(dataBytes); // Se introduce texto en bytes a resumir
			byte resumen[] = md.digest();
			oos.writeObject("Ingresa la contraseña: ");
			
			InputStream input = cliente.getInputStream(); // Recibe entrada de bajo nivel
			ObjectInputStream ois = new ObjectInputStream(input); // Transforma ese bajo nivel en proceso
			String cadenaLeida = ois.readObject().toString(); // Transforma el objeto en una cadena de texto y lo lee
			
			
			if(Hexadecimal(resumen).equals(cadenaLeida)) {
				System.out.println("Acceso permitido");
			}else {
				System.out.println("Acceso denegado");
			}
			


	
		

			cliente.close();
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	}

	// Convierte un array de bytes en hexadecimal
	static String Hexadecimal(byte[] resumen) {
		String hex = " ";
		for (int i = 0; i < resumen.length; i++) {
			String h = Integer.toHexString(resumen[i] & 0xFF);
			if (h.length() == 1)
				hex += "0";
			hex += h;

		}
		return hex.toUpperCase();
	}
}
