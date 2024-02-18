package tema6Ejercicio19ProgressSlider;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EjercicioSceneBuilder extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgressSlider.fxml"));
        Parent root = loader.load();


        primaryStage.setTitle("Mi Aplicación JavaFX");
        primaryStage.setScene(new Scene(root, 550, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
