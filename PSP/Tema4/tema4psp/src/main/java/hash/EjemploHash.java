package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EjemploHash {

	public static void main(String[] args) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String texto = "Si Estiik se tira por un puente, ¿tú también?";
			byte dataBytes[] = texto.getBytes(); // Texto a bytes
			md.update(dataBytes); // Se introduce texto en bytes a resumir
			byte resumen[] = md.digest(); // Se calcula el resumen
			System.out.println("Mensaje original: " + texto);
			System.out.println("Número de bytes: " + md.getDigestLength());
			System.out.println("Algoritmo: " + md.getAlgorithm());
			System.out.println("Mensaje resumen: " + new String(resumen));
			System.out.println("Mensaje en Hexadecimal: " + Hexadecimal(resumen));
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
