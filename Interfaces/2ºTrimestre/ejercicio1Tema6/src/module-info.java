module ejercicio1Tema6 {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens Ejercicio to javafx.graphics, javafx.fxml;
	exports Ejercicio;
}
