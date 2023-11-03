package Examen3;

import java.util.Random;
import java.util.Scanner;

public class CompetenciaCiclista {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Ejercicio 1
		String nombreCompetencia;
		do {
			System.out.println(
					"Introduce el nombre de la competición (debe empezar con 'Vuelta' y tener al menos dos espacios): ");
			nombreCompetencia = scanner.nextLine();
		} while (!nombreCompetencia.matches("^Vuelta.*\\s.*\\s.*"));

		// Ejercicio 2
		nombreCompetencia = nombreCompetencia.replaceAll("([aeiouAEIOU])", "$1".toUpperCase());
		System.out.println("Nombre de la competición modificado: " + nombreCompetencia);

		// Ejercicio 3
		int caracteresNoLetras = 0;
		for (char c : nombreCompetencia.toCharArray()) {
			if (!Character.isLetter(c)) {
				caracteresNoLetras++;
			}
		}
		System.out.println("Número de caracteres que no son letras: " + caracteresNoLetras);

		// Ejercicio 4
		System.out.print("Introduce el número de etapas de la competición: ");
		int numEtapas = scanner.nextInt();
		short[] etapas = new short[numEtapas];

		// Ejercicio 5
		Random rand = new Random();
		for (int i = 0; i < numEtapas; i++) {
			etapas[i] = (short) (rand.nextInt(121) + 80);
		}

		// Ejercicio 6
		int distanciaTotal = 0;
		for (short etapa : etapas) {
			distanciaTotal += etapa;
		}
		System.out.println("Distancia total de la competición: " + distanciaTotal + " kilómetros");

		// Ejercicio 7
		short distanciaRecursiva = cuentaKilometros(etapas, 0, 0);
		System.out.println("Distancia total de la competición (recursiva): " + distanciaRecursiva + " kilómetros");

		// Ejercicio 8
		short etapaMasLarga = etapaMasLarga(etapas);
		System.out.println("Distancia de la etapa más larga: " + etapaMasLarga + " kilómetros");

		// Ejercicio 9
		String[] corredores = new String[numEtapas + 1];
	}

	// Ejercicio 7 (función recursiva)
	public static short cuentaKilometros(short[] etapas, int index, int distanciaAcumulada) {
		if (index == etapas.length) {
			return (short) distanciaAcumulada;
		} else {
			return cuentaKilometros(etapas, index + 1, distanciaAcumulada + etapas[index]);
		}
	}

	// Ejercicio 8
	public static short etapaMasLarga(short[] etapas) {
		short max = 0;
		for (short etapa : etapas) {
			if (etapa > max) {
				max = etapa;
			}
		}
		return max;
	}
}