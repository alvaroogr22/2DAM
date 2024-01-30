package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjetoServidor {

	public static void main(String[] args) {
		int puerto=6000;
		ServerSocket servidor;
		
		try {
			servidor=new ServerSocket(puerto);
			System.out.println("Esperandop al cliente en el puerto: "+servidor.getLocalPort());
			Socket cliente=servidor.accept(); //Espera una petición de un cliente, el main se detiene.
			
			//Prepara el flujo de salida para objetos
			ObjectOutputStream oos=new ObjectOutputStream(cliente.getOutputStream());
			
			//Creamos el objeto que queremos enviar
			Empleados empleado1=new Empleados("Alvaro", 3000);
			
			//Se envía el objeto empleado1
			oos.writeObject(empleado1);
			
			System.out.println("Envío: "+empleado1.getNombre()+" con un sueldo mensual de "+empleado1.getSueldo());
			
			oos.close();
			cliente.close();
			servidor.close();
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}

}
