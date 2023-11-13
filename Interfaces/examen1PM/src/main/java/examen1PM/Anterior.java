package examen1PM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Anterior extends JFrame {
    private JTextField usuarioField;
    private JPasswordField contraseñaField;

    public Anterior() {
        setTitle("Autenticación");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel usuarioLabel = new JLabel("Nombre de usuario:");
        JLabel contraseñaLabel = new JLabel("Contraseña:");

        usuarioField = new JTextField();
        contraseñaField = new JPasswordField();

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Creamos los campos de login para el usuario y para la contraseña
                String nombreUsuario = usuarioField.getText();
                String contraseña = new String(contraseñaField.getPassword());

                if (verificarAutenticacion(nombreUsuario, contraseña)) {
                    //Si hacemos bien el login se nos abre la VentanaPrincipal
                    dispose();
                    mostrarVentanaPrincipal();
                } else {
                    //Si fallamos en el login nos muestra un error
                    mostrarErrorAutenticacion();
                }
            }
        });

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Al cancelar salimos de la aplicación
                System.exit(0);
            }
        });

        panel.add(usuarioLabel);
        panel.add(usuarioField);
        panel.add(contraseñaLabel);
        panel.add(contraseñaField);
        panel.add(botonAceptar);
        panel.add(botonCancelar);

        add(panel);
        setVisible(true);
    }

    private boolean verificarAutenticacion(String usuario, String contraseña) {
        //Ponemos un usuario y una contraseña
        String usuarioCorrecto = "usuario";
        String contraseñaCorrecta = "contraseña";
        return usuario.equals(usuarioCorrecto) && contraseña.equals(contraseñaCorrecta);
    }

    private void mostrarVentanaPrincipal() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }

    private void mostrarErrorAutenticacion() {
        JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña incorrectos", "Autenticación Fallida",
                JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Anterior();
            }
        });
    }
}