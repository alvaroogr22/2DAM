package Ejercicio3;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class SimpleController {

    @FXML
    private ChoiceBox<String> choiceBoxFormaDePago;

    @FXML
    private ComboBox<String> comboBoxOtrosServicios;

    @FXML
    private RadioButton radioButtonParticular;

    @FXML
    private RadioButton radioButtonEmpresa;

    @FXML
    private ToggleGroup customerTypeGroup;

    @FXML
    private DatePicker datePickerFechaNacimiento;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private GridPane gridPane;

    @FXML
    private CheckBox checkBoxTelevision;

    @FXML
    private CheckBox checkBoxTelefonia;

    @FXML
    private CheckBox checkBoxWifi;

    @FXML
    private Button btnAceptar;

    @FXML
    public void initialize() {
    	choiceBoxFormaDePago.setItems(FXCollections.observableArrayList("Contado", "Transferencia", "Paypal"));
        comboBoxOtrosServicios.setItems(FXCollections.observableArrayList("Opción 1", "Opción 2", "Opción 3"));

        customerTypeGroup = new ToggleGroup();
        radioButtonParticular.setToggleGroup(customerTypeGroup);
        radioButtonEmpresa.setToggleGroup(customerTypeGroup);

        colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            Color color = newValue;
            gridPane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        });


    }

    private String toHexString(Color color) {
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }

}