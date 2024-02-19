package hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String contra = "Holi";
			byte dataBytes[] = contra.getBytes(); // Texto a bytes
			md.update(dataBytes); // Se introduce texto en bytes a resumir
			byte resumen[] = md.digest(); // Se calcula el resumen
			System.out.println("Contraseña original: " + contra);
			System.out.println("Número de bytes: " + md.getDigestLength());
			System.out.println("Algoritmo: " + md.getAlgorithm());
			System.out.println("Mensaje resumen: " + new String(resumen));
			System.out.println("Mensaje en Hexadecimal: " + Hexadecimal(resumen));
			
			MessageDigest mdu = MessageDigest.getInstance("SHA-256");
			System.out.println("Introduce la contraseña");
			String contrau=sc.nextLine();			
			byte dataBytesu[] = contrau.getBytes(); // Texto a bytes
			mdu.update(dataBytesu); // Se introduce texto en bytes a resumir
			byte resumenu[] = mdu.digest(); // Se calcula el resumen
			System.out.println("Contraseña usuario: " + contrau);
			System.out.println("Número de bytes: " + mdu.getDigestLength());
			System.out.println("Algoritmo: " + mdu.getAlgorithm());
			System.out.println("Mensaje resumen: " + new String(resumenu));
			System.out.println("Mensaje en Hexadecimal: " + Hexadecimal(resumenu));
			
			if(Hexadecimal(resumen).equals(Hexadecimal(resumenu))) {
				System.out.println("Contraseña correcta");
			}else {
				System.out.println("Nunca acertarás la admin_password, reinstala Odú. 😈");
			}
			
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
