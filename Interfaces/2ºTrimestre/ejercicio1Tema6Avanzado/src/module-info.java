module ejercicio1Tema6Avanzado {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens ejercicio to javafx.graphics, javafx.fxml;
}
