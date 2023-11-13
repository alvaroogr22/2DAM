package InterfacesGraficas;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
//usando un bucle para que me rellene la ventana con
//varios botones, sin metodo constructor
public class Ventana5ConMetodos extends JFrame {
    private JPanel panel; //contenedor variable
   //propiedades, absolute layout, visibilidad, contenedor 
    private void inicializarVentana() { 
        setSize(300, 300);
        setVisible(true);
        panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);
    }
//botones, x, y, ancho, alto
    private void agregarBoton(String nombreBoton, int x, int y) {
        JButton botonBienvenido = new JButton(nombreBoton);
        botonBienvenido.setBounds(x, y, 100, 50); // Posici�n (x, y) y tama�o (ancho, alto) del bot�n en relaci�n al panel.
        panel.add(botonBienvenido);
    }
//a�adimos botones usando un bucle
    
    public static void main(String[] args) {
    	Ventana5ConMetodos ventana=new Ventana5ConMetodos();
    	ventana.inicializarVentana();
    	String [] botones= {"Boton 1", "Boton 2", "Boton 3"};
    	int y=50;
    	for (String boton:botones  ) {
    		ventana.agregarBoton(boton,50,y);
    		y=y+50;    		
    	}
    			
    		    	
    	
    	
    	//int y=50;
    	//for (int i=1; i<4;i++) {
    	// 		ventana.agregarBoton("Boton "+i,50,y);
    	//	y=y+50;
    	//}
    	
    	
    	
    
    
    }
}
