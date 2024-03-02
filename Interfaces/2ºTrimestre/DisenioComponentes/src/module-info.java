module DisenioComponentes {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
	opens Ejercicio3 to javafx.graphics, javafx.fxml;
	opens Ejercicio4 to javafx.graphics, javafx.fxml;
	opens Ejercicio5 to javafx.graphics, javafx.fxml;
	opens Ejercicio6 to javafx.graphics, javafx.fxml;
	opens Ejercicios7y8 to javafx.graphics, javafx.fxml;
	opens Ejercicio9 to javafx.graphics, javafx.fxml;
	opens Ejercicio10 to javafx.graphics, javafx.fxml;
}
