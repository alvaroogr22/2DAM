package hash;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ClienteEjercicio3 {

	public static void main(String[] args) {
		Socket cliente = null;

		try {
			cliente = new Socket("localhost", 62000);

			// Envío de mensajes cliente-servidor
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String texto = "El cuco está en el nido";
			byte dataBytes[] = texto.getBytes(); // Texto a bytes
			md.update(dataBytes); // Se introduce texto en bytes a resumir
			byte resumen[] = md.digest();
			oos.writeObject(texto);
			oos.writeObject(Hexadecimal(resumen));

			System.out.println("Fin del mensaje");

			cliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
