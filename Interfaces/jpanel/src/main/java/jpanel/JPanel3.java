package jpanel;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JPanel3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UIManager.put("OptionPane.yesButtonText", "Toma pa ti chulo");
		UIManager.put("OptionPane.noButtonText", "Va ce que no");
		UIManager.put("OptionPane.cancelButtonText", "Ea cilenciao");

		boolean opcion = false;
		do {
		int codigo = JOptionPane.showConfirmDialog(null,
				"¿Quieres donar un euro para una buena causa?","Donacion",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		if (codigo==JOptionPane.YES_OPTION) {
			System.out.println("Has pulsado en SI");
			JOptionPane.showMessageDialog(null,"Gracia");
			opcion=true;
		}else if (codigo == JOptionPane.NO_OPTION){
			System.out.println("Has pulsado en NO");
			JOptionPane.showMessageDialog(null,"Paga rata gorda");
		}else {
			System.out.println("Has pulsado en cancelar");
			JOptionPane.showMessageDialog(null,"Paga rata gorda");
		}
		}while (opcion!=true);
	}
}
