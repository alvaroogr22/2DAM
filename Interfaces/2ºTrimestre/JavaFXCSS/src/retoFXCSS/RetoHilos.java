package retoFXCSS;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RetoHilos extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("¡Hola desde JavaFX en verdad!");
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);

                Platform.runLater(() -> {
                    btn.setText("Hilo 1 ejecutado");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);

                Platform.runLater(() -> {
                    btn.setText("¡Hilo 2 redy, vamos bien!");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(4500);

                Platform.runLater(() -> {
                    btn.setText("¡Hilo 3 ejecutado! poco más y te hago un jersey");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("JavaFX Hilos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
