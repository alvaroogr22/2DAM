package application;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
// 1º creamos dos jpane uno para el formulario y otro para los botones
//2º vamos añadiendo los diferentes elementos
// para que los campos tengan el mismo tamaño, introducimos un layout, denominado gridlayout
// quedando como tenemos en este ejemplo
// 9 son la filas
// 1 las columnas
// 5 y 5 distancia en pixeles horizontal y vertical entre las celdas

public class PruebaSimulacro extends JFrame {
	private JTextField textField;
	private JTextField textField_1;

	public PruebaSimulacro() {

		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel formulario = new JPanel();
		formulario.setBackground(new Color(255, 255, 128));
		getContentPane().add(formulario, BorderLayout.NORTH);
		formulario.setLayout(new GridLayout(7, 5, 5, 5));

		JLabel lblNewLabel_1 = new JLabel("Apellidos");
		formulario.add(lblNewLabel_1);

		textField = new JTextField();
		formulario.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre");
		formulario.add(lblNewLabel);

		textField_1 = new JTextField();
		formulario.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Ocupacion");
		formulario.add(lblNewLabel_2);

		JComboBox comboBox_ocupacion = new JComboBox();
		comboBox_ocupacion.setModel(new DefaultComboBoxModel(
				new String[] { "Desempleado", "Trabajador por cuenta propia", "trabajador por cuenta ajena" }));
		formulario.add(comboBox_ocupacion);

		JLabel lblEstudios = new JLabel("Estudios----------------");
		lblEstudios.setBackground(new Color(0, 128, 255));
		formulario.add(lblEstudios);

		JLabel label_1 = new JLabel("-----------------");
		formulario.add(label_1);

		JLabel lblNewLabel_Estudios = new JLabel("Estudios");
		formulario.add(lblNewLabel_Estudios);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Sin estudios", "Grado medio", "Grado superior", "Licenciado o grado" }));
		formulario.add(comboBox);

		JPanel botones = new JPanel();
		botones.setBackground(new Color(128, 255, 0));
		botones.setForeground(new Color(255, 128, 64));
		FlowLayout flowLayout = (FlowLayout) botones.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(botones, BorderLayout.SOUTH);

		JButton btnNewButton_Aceptar = new JButton("Aceptar");
		botones.add(btnNewButton_Aceptar, BorderLayout.SOUTH);

		JButton btnNewButton_cancelar = new JButton("Cancelar");
		botones.add(btnNewButton_cancelar);
		setLocationRelativeTo(null);

		pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new PruebaSimulacro().setVisible(true);
		});
	}

}