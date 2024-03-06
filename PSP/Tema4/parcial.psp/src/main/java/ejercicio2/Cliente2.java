package ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente2 {
	public static void main(String[] args) {
		Socket cliente = null;
		Scanner sc = new Scanner(System.in);
		try {
			cliente = new Socket("localhost", 61000);
			
			Pikachu pikachu = new Pikachu();
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			oos.writeObject(pikachu);
			
			InputStream input = cliente.getInputStream(); // Recibe entrada de bajo nivel
			ObjectInputStream ois = new ObjectInputStream(input); // Transforma ese bajo nivel en proceso
			String cadenaLeida = ois.readObject().toString(); // Transforma el objeto en una cadena de texto y lo lee
			System.out.println("Servidor: " + cadenaLeida);
			
			String respuesta = sc.nextLine();
			oos.writeObject(respuesta);
			if(respuesta.toUpperCase().equals("Y")) {
				pikachu.setNombre("Raichu");
				oos.writeObject(pikachu);
				oos.writeObject("Felicidades, tu Pikachu ha evolucionado a Raichu");
			}else {
				oos.writeObject("Qué lástima.");
			}
			
			

			System.out.println("Fin del mensaje");

			cliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}