package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductosModel {
	private Connection conn;

	public ProductosModel(String dbURL, String dbUser, String dbPassword) throws SQLException {
		conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
	}

	public List<Productos> getAllProductos() throws SQLException {
		List<Productos> productos = new ArrayList<>();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM producto");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int codigo = rs.getInt("codigo");
			String nombre = rs.getString("nombre");
			double precio = rs.getDouble("precio");
			int codigoFabricante = rs.getInt("codigo_fabricante");
			productos.add(new Productos(codigo, nombre, precio, codigoFabricante));
		}
		stmt.close();
		rs.close();
		return productos;
	}

	public void close() throws SQLException {
		conn.close();
	}

}
