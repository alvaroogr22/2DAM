module JavaFxController {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	opens Ejercicio2 to javafx.graphics, javafx.fxml;
	opens Ejercicio3 to javafx.graphics, javafx.fxml;
	opens Ejercicio4 to javafx.graphics, javafx.fxml;
	opens Ejercicio5 to javafx.graphics, javafx.fxml;
	opens Ejercicio6 to javafx.graphics, javafx.fxml;
	opens Ejercicio7 to javafx.graphics, javafx.fxml;
}
