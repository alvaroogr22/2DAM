package ejercicio4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ejecutar extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("simple3.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Mi Aplicación JavaFX");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    }