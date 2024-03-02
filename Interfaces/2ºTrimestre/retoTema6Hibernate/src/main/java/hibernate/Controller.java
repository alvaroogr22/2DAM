package hibernate;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller implements Initializable{

    @FXML
    private TableView<TVideojuegos> tableViewJuegos;

    @FXML
    private TableColumn<TVideojuegos, String> nombreColumn;

    @FXML
    private TableColumn<TVideojuegos, Integer> anioColumn;
    
    @FXML
    private TableColumn<TVideojuegos, String> compColumn;
    
    @FXML
    private TableColumn<TVideojuegos, Double> precioColumn;
    
    @FXML
    private TableColumn<TVideojuegos, String> sinopColumn;
    
    @FXML
    private TableColumn<TVideojuegos, String> platColumn;
    
    private SessionFactory sessionFactory;

    // ExecutorService para cargar los datos en un hilo separado
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private void inicializar() {
    	  System.out.println("Cantidad de fabricantes recuperados: ");
        sessionFactory = new Configuration().configure().buildSessionFactory();
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        anioColumn.setCellValueFactory(cellData -> cellData.getValue().anioProperty().asObject());
        compColumn.setCellValueFactory(cellData -> cellData.getValue().compañiaProperty());
        precioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        sinopColumn.setCellValueFactory(cellData -> cellData.getValue().sinopsisProperty());
        platColumn.setCellValueFactory(cellData -> cellData.getValue().plataformaProperty());

        System.out.println("Inicializando Controller...");
        cargarFabricantesAsync();
    }

    private void cargarFabricantesAsync() {
        executorService.submit(() -> {
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                List<TVideojuegos> tVideojuegos = session.createQuery("from TVideojuegos", TVideojuegos.class).list();
                System.out.println("Cantidad de videojuegos recuperados: " + tVideojuegos.size());
                // Actualizar la tabla en el hilo de la interfaz de usuario
                tableViewJuegos.getItems().clear();
                tableViewJuegos.getItems().addAll(tVideojuegos);
                System.out.println("Cantidad de videojuegos recuperados: " + tVideojuegos.size());
                session.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void cerrarConexion() {
        executorService.shutdown();
        sessionFactory.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		inicializar();
	}
}