package conectarmysql;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertarDatos {

	public static void main(String[] args) throws SQLException {
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;
		String sql = "INSERT INTO productos (id, nombre, tipo_de_gama, marca, precio, numero_de_serie)"
				+ "VALUES (1, 'Portatil1', 'Portatil gama alta', 'HP', 1500, '111'),"
				+ "(2, 'Portatil2', 'Portatil gama baja', 'APPLE', 1000, '222'),"
				+ "(3, 'Monitor1', 'Monitor gama alta', 'LG', 800, '333'),"
				+ "(4, 'Monitor2', 'Monitor gama baja', 'HP', 200, '444')";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:17770/simulacro", "root", "");
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Datos insertados en la tabla productos");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}