package InterfacesGraficas;
import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class Ejercicio4FrameJOptionPane {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame ventana=new JFrame("Nueva ventana");
		JButton boton=new JButton("Pulsa aqui");
		boton.setBounds(106, 56, 109, 36);
		ventana.setSize(300,300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);
		ventana.getContentPane().add(boton);
		   boton.addActionListener(new ActionListener() 
	        {
	            public void actionPerformed(ActionEvent e) 
	               {
	            	//al asociarlo aparece en el mismo sitio
	            	String nombre = JOptionPane.showInputDialog(ventana, 
	        				"Dime tu nombre", "Datos personales", 
	        				JOptionPane.QUESTION_MESSAGE);
	                	            }
	        });
		   ventana.setVisible(true);
		}		
}
