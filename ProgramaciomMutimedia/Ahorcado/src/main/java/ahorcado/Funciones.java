package ahorcado;

import javax.swing.JOptionPane;

public class Funciones {

	public static char obtenerLetra(String mensaje) {
		String entrada;
		do {
			entrada = JOptionPane.showInputDialog(mensaje);
		} while (entrada == null || entrada.isEmpty());
		return entrada.charAt(0);
	}

	public static String dibujarAhorcado(byte intentos) {
		String[] ahorcado = {
				" ________",
				"|       |",
				"|       O",
				"|      /|\\",
				"|      / \\",
				"|________"
		};

		StringBuilder dibujo = new StringBuilder();
		for (int i = 0; i < 6 - intentos; i++) {
			dibujo.append(ahorcado[i]).append("\n");
		}
		return dibujo.toString();
	}

	public static boolean palabraAdivinada(char[] letrasAdivinadas) {
		for (char c : letrasAdivinadas) {
			if (c == '_') {
				return false;
			}
		}
		return true;
	}
}