package modelovistacontrolador;
<<<<<<<< HEAD:AccesoADatos/ModeloVistaControlador/src/main/java/modelovistacontrolador/ClienteModel.java
========

>>>>>>>> b5b0ff9d8ceaf5475dd92794131a5e3a5436b50f:AccesoADatos/Examen1AGomez/src/main/java/modelovistacontrolador/ClienteModel.java
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ClienteModel {
    private Connection conn;

    // Constructor que recibe la URL de la base de datos, el usuario y la contraseña
    public ClienteModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Establece la conexión con la base de datos
        conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
    }

    // Método para obtener todos los clientes de la base de datos y devolverlos como
    // una lista
    public List<Cliente> getAllClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>(); // Inicializa una lista para almacenar los clientes
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tvideojuegos"); // Crea una declaración SQL

        // Ejecuta una consulta SQL para obtener todos los clientes de la tabla
        // "clientes"
        ResultSet rs = stmt.executeQuery();

        // Itera a través de los resultados y crea objetos Cliente para cada fila
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            int anio = rs.getInt("anio");
            String compañia = rs.getString("compañía");
            Float precio = rs.getFloat("precio");
            String sinopsis = rs.getString("sinopsis");
            clientes.add(new Cliente(id, nombre, anio, compañia, precio, sinopsis)); // Agrega cada Cliente a la lista
        }

        stmt.close(); // Cierra la declaración
        rs.close(); // Cierra el resultado
        return clientes; // Devuelve la lista de clientes
    }

    // Método para cerrar la conexión a la base de datos
    public void close() throws SQLException {
        conn.close();
    }
}