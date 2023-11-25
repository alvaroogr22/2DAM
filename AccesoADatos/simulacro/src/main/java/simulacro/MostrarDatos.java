package simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stat = null;
		String sql = "SELECT * from productos";

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33306/simulacro", "root", "");
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				String fabricante = rs.getString("fabricante");
				int precio = rs.getInt("precio");
				String numeroSerie = rs.getString("numero_serie");
				System.out.println("ID: " + id + ", Nombre: " + nombre + " / Descripcion: " + descripcion
						+ " / Fabricante: " + fabricante + " / Precio: " + precio + " / Número de serie: " + numeroSerie);
			}
			rs.close();
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
