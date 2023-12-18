package jpanel;

import javax.swing.JOptionPane;

public class JPanel2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Un imput
		JOptionPane.showMessageDialog(null, "Wena tarde", null, 0);		
		String nombre = JOptionPane.showInputDialog(null,
				"Dime tu nombre", "Datos personales",
				JOptionPane.QUESTION_MESSAGE);
		if (nombre==null || nombre == "") {
			System.out.println("Hola "+nombre);
			
		}else {
			System.out.println("Has cancelado");
		}

	}

}
