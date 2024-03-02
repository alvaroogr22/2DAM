package ejercicio2;

import javafx.event.ActionEvent;
import javafx.fxml.*;

public class Controller {
	@FXML
	private void handleButtonClick(ActionEvent event) {
		System.out.println("Has pulsado el boton");
	}

	@FXML
	private void pulsame(ActionEvent event) {
		System.out.println("has pulsado el botoncito");
	}
}
