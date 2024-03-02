package Ejercicio2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.collections.*;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Cargar el archivo FXML
        Parent root = FXMLLoader.load(getClass().getResource("Ejercicio2.fxml"));

        Scene scene = new Scene(root, 600, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ejercicio2ControllersAvanzado");

        String desktopPath = System.getProperty("user.home") + "/Desktop";
        String imagePath = desktopPath + "/IconoJuego.png";
        String imageUrl = "file:" + imagePath;

        primaryStage.getIcons().add(new Image(imageUrl));
        
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
