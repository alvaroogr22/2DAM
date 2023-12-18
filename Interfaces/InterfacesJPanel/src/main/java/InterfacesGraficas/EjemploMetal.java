package InterfacesGraficas;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class EjemploMetal {
    public static void main(String[] args) {
        try {
            // Establecer el look and feel de Metal
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            SwingUtilities.updateComponentTreeUI(new JFrame());

            // Crear una ventana Swing
            JFrame frame = new JFrame("Metal Look and Feel Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
