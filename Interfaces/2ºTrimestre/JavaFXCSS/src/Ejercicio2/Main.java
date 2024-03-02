package Ejercicio2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

@Override
public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Ejercicio2JavaFXCSS.fxml"));
    Parent root = loader.load();

    Scene scene = new Scene(root);

    // Cargar el archivo CSS
    scene.getStylesheets().add(getClass().getResource("ejercicio2.css").toExternalForm());

    primaryStage.setScene(scene);
    primaryStage.show();
}

public static void main(String[] args) {
    launch(args);
}
}