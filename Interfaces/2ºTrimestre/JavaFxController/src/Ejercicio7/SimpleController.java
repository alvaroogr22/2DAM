package Ejercicio7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import java.net.URL;
import java.util.ResourceBundle;

public class SimpleController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicialización, si es necesaria
    }

    @FXML
    private void handleMenuAction(ActionEvent event) {
        // Este método se llamará cuando se seleccione una opción del menú
        MenuItem sourceMenuItem = (MenuItem) event.getSource();
        Menu sourceMenu = (Menu) event.getSource();
        //al definir cada item usando MenuItem sourceMenuitem, getText
        //muestra el texto asignado a cada botón
        System.out.println("Has elegido el Menú: "+sourceMenu.getText());
        System.out.println("Has pulsado la opción: " + sourceMenuItem.getText());
    }
}
