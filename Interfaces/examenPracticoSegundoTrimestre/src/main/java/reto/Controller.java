package reto;

import java.sql.SQLException;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

  @FXML
  private TableView<Estudiante> tableViewEstudiante;

  @FXML
  private TableColumn<Estudiante, String> nombreColumn;

  @FXML
  private TableColumn<Estudiante, String> correoColumn;

  @FXML
  private TableColumn<Estudiante, String> telefonoColumn;

  @FXML
  private TableColumn<Estudiante, String> cursoColumn;

  @FXML
  private TableColumn<Estudiante, String> fechaColumn;

  @FXML
  private TextField nombreTF;

  @FXML
  private TextField correoTF;

  @FXML
  private TextField telefonoTF;

  @FXML
  private TextField cursoTF;

  @FXML
  private TextField fechaTF;

  @FXML
  private Button btnAñadir;

  @FXML
  private Button btnBorrar;

  @FXML
  private Button btnMostrar;

  private EstudianteModel model;

  public void inicializar(String dbURL, String dbUser, String dbPassword)
    throws SQLException {
    model = new EstudianteModel(dbURL, dbUser, dbPassword);

    btnAñadir.setOnAction(event -> agregarEstudiante());

    btnMostrar.setOnAction(event -> mostrarRegistros());

    btnBorrar.setOnAction(event -> borrarFilaSeleccionada());
  }

  @FXML
  private void mostrarRegistros() {
    nombreColumn.setCellValueFactory(cellData ->
      new SimpleStringProperty(cellData.getValue().getNombre())
    );
    correoColumn.setCellValueFactory(cellData ->
      new SimpleStringProperty(cellData.getValue().getCorreo_electronico())
    );
    telefonoColumn.setCellValueFactory(cellData ->
      new SimpleStringProperty(cellData.getValue().getTelefono())
    );
    cursoColumn.setCellValueFactory(cellData ->
      new SimpleStringProperty(cellData.getValue().getCurso())
    );
    fechaColumn.setCellValueFactory(cellData ->
      new SimpleStringProperty(cellData.getValue().getFecha_inscripcion())
    );

    // Limpiar la TableView antes de cargar nuevos datos
    tableViewEstudiante.getItems().clear();

    try {
      List<Estudiante> libro = model.getAllLibros();

      // Agrega los datos a la TableView
      tableViewEstudiante.getItems().addAll(libro);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private void limpiarCampos() {
    nombreTF.clear();
    correoTF.clear();
    telefonoTF.clear();
    cursoTF.clear();
    fechaTF.clear();
  }

  @FXML
  private void agregarEstudiante() {
    String nombre = nombreTF.getText();
    String correo_electronico = correoTF.getText();
    String telefono = telefonoTF.getText();
    String curso = cursoTF.getText();
    String fecha_inscripcion = fechaTF.getText();

    Estudiante nuevoEstudiante = new Estudiante(
      0,
      nombre,
      correo_electronico,
      telefono,
      curso,
      fecha_inscripcion
    );
    try {
      model.agregarEstudiante(nuevoEstudiante);

      String mensaje =
        "Estudiante añadido:\n" +
        "Nombre: " +
        nombre +
        "\n" +
        "Correo: " +
        correo_electronico +
        "\n" +
        "Teléfono: " +
        telefono +
        "\n" +
        "Curso: " +
        curso +
        "Fecha Inscripción: " +
        fecha_inscripcion;

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Estudiante Añadido");
      alert.setHeaderText(null);
      alert.setContentText(mensaje);
      alert.showAndWait();
      limpiarCampos();
    } catch (SQLException e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error al añadir estudiante");
      alert.setHeaderText("Error");
      alert.setContentText("Has dejado algún campo sin rellenar");
      alert.showAndWait();
    }
  }

  @FXML
  private void borrarFilaSeleccionada() {
    Estudiante estudianteSeleccionado = tableViewEstudiante
      .getSelectionModel()
      .getSelectedItem();

    if (estudianteSeleccionado != null) {
      try {
        model.borrarRegistro(estudianteSeleccionado.getNombre());

        tableViewEstudiante.getItems().remove(estudianteSeleccionado);

        limpiarCampos();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("estudiante borrado");
        alert.setHeaderText(null);
        alert.setContentText("Se ha borrado el estudiante seleccionado");
        alert.showAndWait();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Error al borrar el estudiante");
      alert.setHeaderText(null);
      alert.setContentText("Por favor, selecciona un estudiante para borrar");
      alert.showAndWait();
    }
  }

  @FXML
  private void cerrarConexion() {
    try {
      model.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
