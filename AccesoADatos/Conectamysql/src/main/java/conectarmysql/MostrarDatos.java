package conectarmysql;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MostrarDatos {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;
		String sql = "SELECT * FROM productos";
		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:17770/simulacro", "root", "");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String tipo_de_gama = rs.getString("tipo_de_gama");
				String marca = rs.getString("marca");
				Double precio = rs.getDouble("precio");
				String numero_de_serie = rs.getString("numero_de_serie");
				System.out.println("id: " + id
						+ ", Nombre: " + nombre
						+ ", Tipo_de_gama: " + tipo_de_gama
						+ ", Marca: " + marca
						+ ", Precio: " + precio
						+ ", Numero_de_serie: " + numero_de_serie);
			}

			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}