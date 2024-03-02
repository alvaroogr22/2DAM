package Ejercicio4;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SimpleController {

	@FXML
	private void pulsame(ActionEvent event) {
		String idBotonPulsado = ((Button) event.getSource()).getId();
		System.out.println("Botón pulsado: " + idBotonPulsado);
		switch(idBotonPulsado) {
		case "Boton1":
			System.out.println("Has pulsado el boton 1");
			break;
		case "Boton2":
			System.out.println("Has pulsado el boton 2");
			break;
		case "Boton3":
			System.out.println("Has pulsado el boton 3");
			break;
		case "Boton4":
			System.out.println("Has pulsado el boton 4");
			break;
		}
	}
}
