package jpanel;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class JPanelLargo {

	public static void main(String[] args) {
		UIManager.put("OptionPane.yesButtonText", "Toma pa ti chulo");
		UIManager.put("OptionPane.noButtonText", "Va ce que no");
		UIManager.put("OptionPane.cancelButtonText", "Ea cilenciao por pezao");

		boolean opcion = false;
		do {
			int codigo = JOptionPane.showConfirmDialog(null, "¿Quieres donar un euro para una buena causa?", "Donacion",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (codigo == JOptionPane.YES_OPTION) {
				boolean opcion2 = false;
				JOptionPane.showMessageDialog(null, "Gracia");
				opcion = true;
				do {
					int codigo2 = JOptionPane.showConfirmDialog(null,
							"Ahora que mas donao, ¿me deja er telefono pa llama?", "Te van a roba",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
					UIManager.put("OptionPane.yesButtonText", "Toma pa ti chulo");
					UIManager.put("OptionPane.noButtonText", "Va ce que no");
					UIManager.put("OptionPane.cancelButtonText", "Ni de coña loko");

					if (codigo2 == JOptionPane.YES_OPTION) {
						opcion2 = true;
						JOptionPane.showMessageDialog(null, "Ea po te quea sin movi pisha");
					} else if (codigo == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Como que no, a que te pincho");
					} else {
						JOptionPane.showMessageDialog(null, "O me lo da o te rajo");
					}
				} while (opcion2 != true);

			} else if (codigo == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Paga rata gorda");
			} else {
				JOptionPane.showMessageDialog(null, "No me va cilencia");
			}
		} while (opcion != true);
	}

}
