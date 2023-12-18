package InterfacesGraficas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana0 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		JFrame ventana=new JFrame();
		JPanel panel=new JPanel();
		JButton boton=new JButton("Aceptar");
		boton.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			JFrame ventanaNueva=new JFrame("Nueva ventana");
			ventanaNueva.setSize(200, 200);
			ventanaNueva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ventanaNueva.add(new JLabel("has pulsado el bot�n "+boton));
			ventanaNueva.setVisible(true);
		
		}
		});
		
		ventana.getContentPane().add(panel);
		ventana.setSize(300,300);
		ventana.setLocation(300,300);
		ventana.setVisible(true);
		
		panel.setLayout(null);
		boton.setBounds(30,10,200,100);
		panel.add(boton);
		
		
		
		
		
		
	}

	
}
