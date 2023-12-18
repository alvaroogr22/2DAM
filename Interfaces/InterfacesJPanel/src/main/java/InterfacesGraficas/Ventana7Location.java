package InterfacesGraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana7Location extends JFrame {
    private JLabel etiquetaMensaje, etiquetaMensaje1;

    public Ventana7Location() {
        setTitle("Ejemplo con setLocation"); // Ponemos t�tulo a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana, cerramos la aplicaci�n

        // Creamos el contenedor para los botones
        JPanel panelBotones = new JPanel();

        String[] botones = {"arriba", "abajo", "izquierda", "derecha"};

        for (String botonText : botones) {
            JButton boton = new JButton("Boton " + botonText);
            // Le a�adimos el listener para cada bot�n
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String textoBoton = ((JButton) e.getSource()).getText();

                    if (textoBoton.equals("Boton arriba")) {
                        // Cambiar la ubicaci�n de la ventana si se puls� el bot�n "arriba"
                        setLocation(100, 100); // Cambia las coordenadas seg�n lo desees
                    } else if (textoBoton.equals("Boton abajo")) {
                        // Cambiar la ubicaci�n de la ventana si se puls� el bot�n "abajo"
                        setLocation(100, 200); // Cambia las coordenadas seg�n lo desees
                    } else if (textoBoton.equals("Boton izquierda")) {
                        // Cambiar la ubicaci�n de la ventana si se puls� el bot�n "izquierda"
                        setLocation(200, 100); // Cambia las coordenadas seg�n lo desees
                    } else if (textoBoton.equals("Boton derecha")) {
                        // Cambiar la ubicaci�n de la ventana si se puls� el bot�n "derecha"
                        setLocation(600, 200); // Cambia las coordenadas seg�n lo desees
                    }
                }
            });

            panelBotones.add(boton);
        }

        // Agregamos el layout, en este caso, BorderLayout en el centro
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.CENTER);

        pack(); // Ajusta el tama�o de los elementos del JFrame
        setLocation(300, 300); // Establece la ubicaci�n inicial de la ventana
        
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ventana7Location();
            }
        });
    }
}

