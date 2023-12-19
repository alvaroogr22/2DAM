package Ejercicios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ExamenFinal extends JFrame {

    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField edadField;
    private JTextArea comentariosArea;
    private JCheckBox javaCheckBox;
    private JCheckBox pythonCheckBox;
    private JRadioButton bachilleratoRadioButton;
    private JRadioButton cicloMedioRadioButton;
    private JRadioButton cicloSuperiorRadioButton;

    public ExamenFinal() {
        super("Formulario de Registro - FP");

        // Creamos componentes
        nombreField = new JTextField(20);
        apellidosField = new JTextField(20);
        edadField = new JTextField(3);
        comentariosArea = new JTextArea(5, 20);
        javaCheckBox = new JCheckBox("Java");
        pythonCheckBox = new JCheckBox("Python");
        bachilleratoRadioButton = new JRadioButton("Bachillerato");
        cicloMedioRadioButton = new JRadioButton("Ciclo Medio");
        cicloSuperiorRadioButton = new JRadioButton("Ciclo Superior");

        // Agrupamos botones de radio
        ButtonGroup nivelEstudiosGroup = new ButtonGroup();
        nivelEstudiosGroup.add(bachilleratoRadioButton);
        nivelEstudiosGroup.add(cicloMedioRadioButton);
        nivelEstudiosGroup.add(cicloSuperiorRadioButton);

        // Botón para la carga del currículum
        JButton cargarCurriculumButton = new JButton("Cargar Curriculum");
        cargarCurriculumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarCurriculum();
            }
        });

        // Botones para aceptar y cerrar
        JButton aceptarButton = new JButton("Aceptar");
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInformacion();
            }
        });

        JButton cerrarButton = new JButton("Cerrar");
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAgradecimiento();
            }
        });

        // Diseño
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Componentes del panel
        agregarComponente(panel, new JLabel("Nombre:"), gbc);
        gbc.gridx++;
        agregarComponente(panel, nombreField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        agregarComponente(panel, new JLabel("Apellidos:"), gbc);
        gbc.gridx++;
        agregarComponente(panel, apellidosField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        agregarComponente(panel, new JLabel("Edad:"), gbc);
        gbc.gridx++;
        agregarComponente(panel, edadField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        agregarComponente(panel, new JLabel("Comentarios:"), gbc);
        gbc.gridx++;
        agregarComponente(panel, new JScrollPane(comentariosArea), gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        agregarComponente(panel, new JLabel("Lenguajes de Programación:"), gbc);
        gbc.gridx++;
        agregarComponente(panel, javaCheckBox, gbc);
        gbc.gridx++;
        agregarComponente(panel, pythonCheckBox, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        agregarComponente(panel, new JLabel("Nivel de Estudios:"), gbc);
        gbc.gridx++;
        agregarComponente(panel, bachilleratoRadioButton, gbc);
        gbc.gridx++;
        agregarComponente(panel, cicloMedioRadioButton, gbc);
        gbc.gridx++;
        agregarComponente(panel, cicloSuperiorRadioButton, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        agregarComponente(panel, cargarCurriculumButton, gbc);
        gbc.gridx++;
        agregarComponente(panel, aceptarButton, gbc);
        gbc.gridx++;
        agregarComponente(panel, cerrarButton, gbc);

        // Ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        pack();
        setLocationRelativeTo(null); // Centrar en la pantalla
    }

    private void agregarComponente(JPanel panel, JComponent componente, GridBagConstraints gbc) {
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(componente, gbc);
    }

    private void mostrarInformacion() {
        // Recogida de información de los campos
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Información del Alumno:\n");
        mensaje.append("Nombre: ").append(nombreField.getText()).append("\n");
        mensaje.append("Apellidos: ").append(apellidosField.getText()).append("\n");
        mensaje.append("Edad: ").append(edadField.getText()).append("\n");
        mensaje.append("Comentarios: ").append(comentariosArea.getText()).append("\n");

        // Lenguajes de programación
        mensaje.append("Lenguajes de Programación: ");
        if (javaCheckBox.isSelected()) {
            mensaje.append("Java ");
        }
        if (pythonCheckBox.isSelected()) {
            mensaje.append("Python");
        }
        mensaje.append("\n");

        // Nivel de estudios
        mensaje.append("Nivel de Estudios: ");
        if (bachilleratoRadioButton.isSelected()) {
            mensaje.append("Bachillerato");
        } else if (cicloMedioRadioButton.isSelected()) {
            mensaje.append("Ciclo Medio");
        } else if (cicloSuperiorRadioButton.isSelected()) {
            mensaje.append("Ciclo Superior");
        }

        JOptionPane.showMessageDialog(this, mensaje.toString(), "Información del Alumno",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void cargarCurriculum() {
        // Implementar la lógica para cargar el currículum utilizando JFileChooser
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
        }
    }

    private void mostrarAgradecimiento() {
        // Cuadro de agradecimiento
        JOptionPane.showMessageDialog(this, "Gracias por usar nuestro programa, nos vemo makitroki", "Agradecimiento",
                JOptionPane.INFORMATION_MESSAGE);
        // Cerramos aplicación
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ExamenFinal().setVisible(true);
            }
        });
    }
}
