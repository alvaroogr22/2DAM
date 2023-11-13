package InterfacesGraficas;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Ventana4Jframe extends JFrame {  	
	
	
	

    public static void main(String[] args) {
    	 JFrame ventana1=new JFrame("Ventana4");
         // Establecer el layout a null para posicionamiento absoluto.
    	 ventana1.setSize(300, 300);
         ventana1.setVisible(true);
         
    	 JPanel panel=new JPanel();
         panel.setLayout(null);
     
         ventana1.getContentPane().add(panel);
        
         JButton botonBienvenido = new JButton("Bienvenido");
         botonBienvenido.setBounds(50, 50, 100, 50); // Posici�n (x, y) y tama�o (ancho, alto) del bot�n en relaci�n al panel.
         panel.add(botonBienvenido);
    
    	
    }
}

