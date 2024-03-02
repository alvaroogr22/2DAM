package segundoEjercicio4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SegundoEjercicio4JavaFXCSS.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        // Cargar el archivo CSS
        scene.getStylesheets().add(getClass().getResource("segundoEjercicio4.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    }
