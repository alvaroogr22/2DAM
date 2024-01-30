package modelovistacontroladorsimulacro;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel {
    private Connection conn;

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public ClienteModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Establece la conexión con la base de datos
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    // Método para obtener todos los clientes de la base de datos y devolverlos como una lista
    public List<Producto> getAllProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>(); // Inicializa una lista para almacenar los clientes
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM productos"); // Crea una declaración SQL

        // Ejecuta una consulta SQL para obtener todos los clientes de la tabla "clientes"
        ResultSet rs = stmt.executeQuery();

        // Itera a través de los resultados y crea objetos Cliente para cada fila
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            String fabricante = rs.getString("fabricante");
            Float precio = rs.getFloat("precio");
            String numeroSerie = rs.getString("numero_serie");
            productos.add(new Producto(id, nombre, descripcion, fabricante, precio, numeroSerie)); // Agrega cada Cliente a la lista
        }

        stmt.close(); // Cierra la declaración
        rs.close(); // Cierra el resultado
        return productos; // Devuelve la lista de clientes
    }

    // Método para cerrar la conexión a la base de datos
    public void close() throws SQLException {
        conn.close();
    }
}

