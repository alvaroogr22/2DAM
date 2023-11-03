package conectamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDatos {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "CREATE DATABASE phoneland";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:17770/", "root", "");
			stmt = conn.createStatement();
			// La creacion de un Statement en Java implica obtener una instanca a partir de
			// un objeto connection
			stmt.execute(sql);
			System.out.println("Base de datos 'phoneland' ok");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace(); // Imprime informacion sobre la excepcion
		}
	}

}
