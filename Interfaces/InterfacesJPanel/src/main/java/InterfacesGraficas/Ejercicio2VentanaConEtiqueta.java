package InterfacesGraficas;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ejercicio2VentanaConEtiqueta {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana con Etiqueta");
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel texto=new JLabel("Hola Alberto");
        ventana.getContentPane().add(texto);
                
        ventana.setVisible(true);
    }
}
