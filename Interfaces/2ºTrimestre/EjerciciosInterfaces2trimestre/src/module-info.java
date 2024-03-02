module EjerciciosInterfaces2trimestre {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens ejercicios1y2 to javafx.graphics, javafx.fxml;
	opens ejercicio2 to javafx.graphics, javafx.fxml;
}
