package InterfacesGraficas;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio3VentanaConBoton {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana con Bot�n");
    	String nombre="Alberto";
		
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra la ventana y la aplicacion

        JButton boton = new JButton("Haz clic aqu�"); //instanciamos el bot�n
        ventana.add(boton); //a�adimos el boton

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//al asociarlo aparece en el mismo sitio
            	JOptionPane.showMessageDialog(ventana, "Bienvenido "+nombre);
                
            }
        });

        ventana.setVisible(true);
    }
}
