package Tema6Ejercicio16Controles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SimpleController implements Initializable {

    @FXML
    private ComboBox<String> comboBox1;

    @FXML
    private RadioButton radioButtonParticular;

    @FXML
    private RadioButton radioButtonEmpresa;

    @FXML
    private ChoiceBox<String> choiceBox1;

    @FXML
    private CheckBox checkBox1, checkBox2, checkBox3;
    
    @FXML
    private DatePicker datapicker;
    @FXML
    private ColorPicker colorpicker;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Configurar elementos del ComboBox
        ObservableList<String> items = FXCollections.observableArrayList("Opción 1", "Opción 2", "Opción 3");
        comboBox1.setItems(items);

        // Configurar elementos del ChoiceBox
        ObservableList<String> items2 = FXCollections.observableArrayList("CONTADO", "TRANSFERENCIA", "PAYPAL");
        choiceBox1.setItems(items2);

        // Configurar ToggleGroup para los RadioButtons
        ToggleGroup toggleGroup = new ToggleGroup();
        radioButtonParticular.setToggleGroup(toggleGroup);
        radioButtonEmpresa.setToggleGroup(toggleGroup);
    }
    @FXML
    private void handleBtnAceptarAction() {
        mostrarResultado();
    }
    // Método para abrir la nueva ventana con los resultados
    @FXML
    private void mostrarResultado() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resultado.fxml"));
            Parent root = loader.load();

            // Obtener el controlador de la nueva ventana
            ResultadoController resultadoController = loader.getController();

            // Construir el mensaje de resultados
            StringBuilder mensaje = new StringBuilder();
            mensaje.append("ComboBox: ").append(comboBox1.getValue()).append("\n");

            if (radioButtonParticular.isSelected()) {
                mensaje.append("RadioButton seleccionado: Particular\n");
            } else if (radioButtonEmpresa.isSelected()) {
                mensaje.append("RadioButton seleccionado: Empresa\n");
            }

            mensaje.append("ChoiceBox: ").append(choiceBox1.getValue()).append("\n");

            if (checkBox1.isSelected()) {
                mensaje.append("Televisión\n");
            }
            if (checkBox2.isSelected()) {
                mensaje.append("Wifi\n");
            }
            if (checkBox3.isSelected()) {
                mensaje.append("Telefonía\n");
            }
            //color y fecha
        mensaje.append("Fecha: ").append(datapicker.getValue()).append("\n");
         mensaje.append("Color: ").append(colorpicker.getValue()).append("\n");
            
            // Mostrar el resultado en la nueva ventana
            resultadoController.mostrarResultado(mensaje.toString());

            // Configurar la nueva ventana y mostrarla
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Resultados");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}