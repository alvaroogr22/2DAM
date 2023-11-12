package InterfacesGraficas;

import javax.swing.*;
import java.awt.Color;

public class EjercicioComponentUI extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bot�n Personalizado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        JButton button = new JButton("Bot�n Personalizado");
        button.setBackground(Color.CYAN);
        button.setForeground(Color.RED);

        // Establecer el tama�o y la ubicaci�n del bot�n
        button.setBounds(50, 50, 200, 30); // (x, y, ancho, alto)

        frame.setLocation(300, 300);
        frame.setSize(300, 200);

        panel.add(button);
        frame.setVisible(true);
    }
}
