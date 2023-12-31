package ahorcado;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {

  public static void main(String[] args) {
    String[] palabras = {
      "agua",
      "calco",
      "mastodonte",
      "gimnasio",
      "fuerte",
      "tremendo",
      "mundo",
    };
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    int intentos = 6;
    String palabraCorrecta = palabras[r.nextInt(palabras.length)];

    char[] letrasAdivinadas = new char[palabraCorrecta.length()];
    for (int i = 0; i < letrasAdivinadas.length; i++) {
      letrasAdivinadas[i] = '_';
    }

    JOptionPane.showMessageDialog(
      null,
      "Vamos a jugar al ahorcado, intenta adivinar la palabra"
    );

    do {
      String palabraActual = new String(letrasAdivinadas);
      String mensaje =
        "La palabra: " + palabraActual + "\nVidas: " + intentos + "\nTu letra:";
      char letra = Character.toLowerCase(Funciones.obtenerLetra(mensaje));
      boolean letraAdivinada = false;

      for (int i = 0; i < palabraCorrecta.length(); i++) {
        if (palabraCorrecta.charAt(i) == letra) {
          letrasAdivinadas[i] = letra;
          letraAdivinada = true;
        }
      }

      if (!letraAdivinada) {
        intentos--;
        JOptionPane.showMessageDialog(
          null,
          "¡Como decía Chiquito, ERROOL!" +
          "\n" +
          Funciones.dibujarAhorcado((byte) intentos)
        );
      }

      if (intentos == 0 || Funciones.palabraAdivinada(letrasAdivinadas)) {
        if (Funciones.palabraAdivinada(letrasAdivinadas)) {
          JOptionPane.showMessageDialog(
            null,
            "¡👑Que máquina eres, has ganado chulo👑! " + "\n" + palabraCorrecta
          );
        } else {
          JOptionPane.showMessageDialog(
            null,
            "💀Te has cagado encima y te has ahorcado💀" +
            "\n La palabra era" +
            palabraCorrecta
          );
        }
        break;
      }
    } while (true);
  }
}
