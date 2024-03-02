package application;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.SQLException;
import java.util.List;

public class Controller {


    @FXML
    private TableView<Productos> tableViewProductos;

    @FXML
    private TableColumn<Productos, Integer> codigoColumn;

    @FXML
    private TableColumn<Productos, String> nombreColumn;

    @FXML
    private TableColumn<Productos, Double> precioColumn;
    
    @FXML
    private TableColumn<Productos, Integer> codigoFabricanteColumn;


    private ProductosModel model;


    public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Inicializa el modelo de la base de datos
        model = new ProductosModel(dbURL, dbUser, dbPassword);


        // Configura las columnas de la TableView utiliza instrucciones tipo lambda, cada columna de la tabla le //corresponde un campo de la base de datos
        codigoColumn.setCellValueFactory(cellData -> cellData.getValue().codigoProperty().asObject());
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        precioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        //codigoFabricanteColumn.setCellValueFactory(cellData -> cellData.getValue().codigoFabricanteProperty().asObject());



        // Al inicializar el controlador, carga los juegos desde la base de datos
        try {
            cargarProductos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void cargarProductos() throws SQLException {
        // Limpiar la TableView antes de cargar nuevos datos
        tableViewProductos.getItems().clear();


        List<Productos> productos = model.getAllProductos();
    
        // Agrega los datos a la TableView
        tableViewProductos.getItems().addAll(productos);
    }


    @FXML
    private void cerrarConexion() {
        // Cierra la conexión a la base de datos
        try {
            model.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
