package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Servidor {

	// Método para recibir el mensaje encriptado del cliente
	public void recibirMensajeDelCliente(String mensajeEncriptado) {
		
		int numeropuerto = 6000;
		try {
			ServerSocket servidor = new ServerSocket(numeropuerto);
			System.out.println("ESTA ES LA CLASE SERVIDOR."
					+ "\nEsperando al cliente....");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Encriptar el mensaje recibido a hexadecimal con SHA-256
		String mensajeRecibidoEncriptado = encriptarSHA256("El cuco está en el nido.");

		// Comparar los códigos hexadecimales
		if (mensajeEncriptado.equals(mensajeRecibidoEncriptado)) {
			System.out.println("Mensaje recibido.");
		} else {
			System.out.println("El mensaje ha sido interceptado");
		}
	}

	// Método para encriptar un mensaje a hexadecimal con SHA-256
	public String encriptarSHA256(String mensaje) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(mensaje.getBytes());

			// Convertir bytes a hexadecimal
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
