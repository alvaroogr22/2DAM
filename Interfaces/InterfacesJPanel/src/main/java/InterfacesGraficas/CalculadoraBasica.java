package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;

public class CalculadoraBasica extends JFrame {
    public CalculadoraBasica() {
        // Configura la ventana
        setTitle("Calculadora B�sica");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Pantalla
        JTextField pantalla = new JTextField();
        pantalla.setEditable(false);
        panel.add(pantalla, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4));

        // Botones
        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String textoBoton : botones) {
            JButton boton = new JButton(textoBoton);
            boton.setFont(new Font("Arial", Font.PLAIN, 18));
            panelBotones.add(boton);
        }

        panel.add(panelBotones, BorderLayout.CENTER);

        // Agrega el panel principal a la ventana
        add(panel);

        // Muestra la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraBasica();
        });
    }
}

