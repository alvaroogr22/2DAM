package Ejercicios7y8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ejercicios7y8 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
	FXMLLoader loader = new FXMLLoader(getClass().getResource("Ejercicios7y8.fxml"));
	Parent root = loader.load();


	primaryStage.setTitle("Mi Aplicación JavaFX");
	primaryStage.setScene(new Scene(root, 750, 300));
	primaryStage.show();
	}

	public static void main(String[] args) {
	launch(args);
	}

}