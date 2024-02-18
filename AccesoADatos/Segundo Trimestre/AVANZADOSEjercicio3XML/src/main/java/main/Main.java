package main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Main {

	public static void main(String[] args) {
		// Ruta del archivo XML
		String xmlFilePath = "datos.xml";

		// Conexión a la base de datos
		Connection connection = null;

		try {
			// Cargar el driver JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establecer la conexión a la base de datos (cambiar la URL, usuario y
			// contraseña según tu configuración)
			connection = DriverManager.getConnection("jdbc:mysql://localhost:33306/actividad", "root", "");

			// Crear la tabla alumno si no existe
			String createTableSQL = "CREATE TABLE IF NOT EXISTS alumno (nombre VARCHAR(100), apellido VARCHAR(100), telefono VARCHAR(20), direccion VARCHAR(255), cp VARCHAR(10), email VARCHAR(100))";
			connection.prepareStatement(createTableSQL).execute();

			// Leer el archivo XML
			File xmlFile = new File(xmlFilePath);
			SAXBuilder saxBuilder = new SAXBuilder();
			Document document = saxBuilder.build(xmlFile);
			Element rootElement = document.getRootElement();

			// Iterar sobre los elementos del XML y almacenarlos en la base de datos
			for (Element alumnoElement : rootElement.getChildren("alumno")) {
				String nombre = alumnoElement.getChildText("nombre");
				String apellido = alumnoElement.getChildText("apellido");
				String telefono = alumnoElement.getChildText("telefono");
				String direccion = alumnoElement.getChildText("direccion");
				String cp = alumnoElement.getChildText("cp");
				String email = alumnoElement.getChildText("email");

				// Insertar datos en la tabla alumno
				String insertSQL = "INSERT INTO alumno (nombre, apellido, telefono, direccion, cp, email) VALUES (?, ?, ?, ?, ?, ?)";
				PreparedStatement ps = connection.prepareStatement(insertSQL);
				ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setString(3, telefono);
				ps.setString(4, direccion);
				ps.setString(5, cp);
				ps.setString(6, email);
				ps.executeUpdate();
			}

			System.out.println("Datos almacenados correctamente en la base de datos.");

		} catch (ClassNotFoundException | SQLException | IOException | JDOMException e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexión a la base de datos
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
