package InterfacesGraficas;
import javax.swing.*;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Ejercicio5FrameOptionPane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana=new JFrame("Usuario y clave");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra la ventana y la aplicacion
		ventana.setSize(400,400);
		
		JButton boton = new JButton("Entrar");
		boton.setBounds(242, 295, 120, 43);
		 

	        // Establece el color del texto en el bot�n (en este caso, blanco)
	       
	        boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(ventana, "Bienvenido ");	
				
			}
		});
		ventana.getContentPane().setLayout(null);
		ventana.getContentPane().add(boton);
		ventana.setVisible(true);
	}

}
