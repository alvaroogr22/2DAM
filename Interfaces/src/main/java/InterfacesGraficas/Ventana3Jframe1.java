package InterfacesGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class Ventana3Jframe1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana3Jframe1 frame = new Ventana3Jframe1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana3Jframe1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Boton 2");
		btnNewButton_1.setBounds(5, 5, 213, 84);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setBounds(218, 5, 213, 84);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(5, 89, 213, 84);
		contentPane.add(label_1);
		
		JButton btnNewButton = new JButton("Boton 1");
		btnNewButton.setBounds(218, 5, 213, 84);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Boton 3");
		btnNewButton_2.setBounds(128, 89, 213, 84);
		contentPane.add(btnNewButton_2);
	}

}
