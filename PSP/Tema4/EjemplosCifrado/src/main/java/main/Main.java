package main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

	public static void main(String[] args) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			String texto="Se dice Odú porque lo dice Estiik.";
			byte dataBytes[]=texto.getBytes(); //Se pasa el texto a bytes
			md.update(dataBytes);//Se introduce texto en bytes a resumir
			byte resumen[]=md.digest();//Se calcula el resumen
			
			System.out.println("Mensaje original: "+texto);
			System.out.println("Numero de bytes: "+md.getDigestLength());
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+new String(resumen));
			System.out.println("Mensaje en Hexadecimal: "+Hexadecimal(resumen));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	static String Hexadecimal(byte[] resumen) {
		String hex=" ";
		for (int i = 0; i < resumen.length; i++) {
			String h=Integer.toHexString(resumen[i] & 0xFF);
			if(h.length()==1) 
				hex+="0";
				hex+=h;
			
		}
		return hex.toUpperCase();
	}

}
