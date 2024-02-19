package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PracticaHashII {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Pedir al usuario que introduzca la contraseña predefinida
		System.out.print("Introduce la contraseña predefinida: ");
		String passPredefinida = scanner.nextLine();
		

		// Generar el hash de la contraseña predefinida
		String adminPassHash = null;
		adminPassHash = hashString(passPredefinida);
		System.out.println("La contraseña a igualar en formato SHA-256 es "+adminPassHash);

		// Pedir al usuario que introduzca su contraseña
		System.out.print("Introduce tu contraseña: ");
		String pass2 = scanner.nextLine();

		// Encriptar la contraseña introducida a hexadecimal con SHA-256
		String passEncriptada = hashString(pass2);

		// Comparar las contraseñas en forma de hash
		if (adminPassHash.equals(passEncriptada)) {
			System.out.println("Contraseña correcta");
		} else {
			System.out.println("Nunca acertarás la admin_password, reinstala Odú. 😈");
		}
	}

	// Método para encriptar la contraseña a hexadecimal con SHA-256
	public static String hashString(String input) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] hashBytes = md.digest(input.getBytes());

		// Convertir bytes a hexadecimal
		StringBuilder hexString = new StringBuilder();
		for (byte b : hashBytes) {
			String hex = Integer.toHexString(0xff & b);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
