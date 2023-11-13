package examen1PM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//¡¡¡¡¡¡ANOTACIÓN EL LOGIN DE LA VENTANA ES!!!!!!
//	Usuario: usuario
//  Contraseña: contraseña

public class Main extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Anterior(); //Muestra la ventana de la autentificación
            }
        });
    }

    public Main() {
        //Config del JFrame inicial
        setTitle("Examen Práctico");
        setSize(400, 300);
        setLocation(300, 300);

        //Creamos un panel principal con BorderLayout que se llama BotonPanel
        JPanel botonPanel = new JPanel(new BorderLayout());

        //Creamos dos paneles con Flowlayout
        JPanel panelNorte = new JPanel(new FlowLayout());
        JPanel panelSur = new JPanel(new FlowLayout());

        //Creamos la brra del menú
        JMenuBar menuBar = new JMenuBar();

        //Hacemos un menú llamado Botones
        JMenu menuBotones = new JMenu("Botones");

        //Nombre de los botones
        String[] nombresBotones = {"Botón 1", "Botón 2", "Botón 3", "Botón 4", "Botón 5", "Botón 6"};

        //Hacemos un bucle para asignarle a cada botón
        for (String nombreBoton : nombresBotones) {
            JMenuItem menuItem = new JMenuItem(nombreBoton);
            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    procesarBoton(((JMenuItem) e.getSource()).getText());
                }
            });
            menuBotones.add(menuItem);
        }

        //Hacemos que cada uno de los paneles se asignen a su posición Norte arriba y Sur abajo
        botonPanel.add(panelNorte, BorderLayout.NORTH);
        botonPanel.add(panelSur, BorderLayout.SOUTH);

        //Asocuamos los botones al menú
        menuBar.add(menuBotones);

        //Asignamos el Menú al JFrame main
        setJMenuBar(menuBar);

        //Creamos botones
        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");
        JButton boton3 = new JButton("Botón 3");
        JButton boton4 = new JButton("Botón 4");
        JButton boton5 = new JButton("Botón 5");
        JButton boton6 = new JButton("Botón 6");

        //Configuración que van a usar los botones
        configurarBoton(boton1);
        configurarBoton(boton2);
        configurarBoton(boton3);
        configurarBoton(boton4);
        configurarBoton(boton5);
        configurarBoton(boton6);

        //Acciones de los botones
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarBoton(((JButton) e.getSource()).getText());
            }
        });
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarBoton(((JButton) e.getSource()).getText());
            }
        });
        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarBoton(((JButton) e.getSource()).getText());
            }
        });
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarBoton(((JButton) e.getSource()).getText());
            }
        });
        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarBoton(((JButton) e.getSource()).getText());
            }
        });
        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarBoton(((JButton) e.getSource()).getText());
            }
        });

        //3 botones al panelnorte
        panelNorte.add(boton1);
        panelNorte.add(boton2);
        panelNorte.add(boton3);

        //3 botones al panelsur
        panelSur.add(boton4);
        panelSur.add(boton5);
        panelSur.add(boton6);

        //Añadimos el panel de botones para que aparezcan los botones
        add(botonPanel);

        //Hago visible el JFrame main
        setVisible(true);
    }

    private void configurarBoton(JButton boton) {
        // Configuración de botones con el fondo en RGB(135, 206, 250) y texto en negro
        boton.setBackground(new Color(135, 206, 250));
        boton.setForeground(Color.BLACK);
    }

    private void procesarBoton(String boton) {
        //Creamos una ventana al pursar un botón con el texto ""Se ha pulsado el botón " + boton"
        JFrame ventanaInfo = new JFrame("Información");
        ventanaInfo.setSize(300, 150);
        ventanaInfo.setLocationRelativeTo(this);

        JLabel etiqueta = new JLabel("Se ha pulsado el botón " + boton);
        JButton botonCerrar = new JButton("Cerrar");

        //Hacemos que un botón cerrar cierre esa ventana
        botonCerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaInfo.dispose();
            }
        });

        //Creamos un panel para asignar la etiqueta y el boton cerrar
        JPanel panelInfo = new JPanel(new BorderLayout());
        panelInfo.add(etiqueta, BorderLayout.CENTER);
        panelInfo.add(botonCerrar, BorderLayout.SOUTH);

        //Agregamos el panelInfo a la ventana
        ventanaInfo.add(panelInfo);

        //Hacemos visible la ventana de la información
        ventanaInfo.setVisible(true);
    }
}
