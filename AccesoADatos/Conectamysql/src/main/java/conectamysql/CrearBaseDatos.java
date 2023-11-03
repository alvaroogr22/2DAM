package conectamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDatos {

	public static void main(String[] args) {
		Connection conn = null;
		Statement cstmt = null;
		String sql = "CREATE DATABASE empresa";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:17770/", "root", "");
			cstmt = conn.createStatement();
			// La creacion de un Statement en Java implica obtener una instanca a partir de
			// un objeto connection
			cstmt.execute(sql);
			System.out.println("Base de datos 'phoneland' ok");
			conn.close();
			cstmt.close();
		} catch (SQLException e) {
			e.printStackTrace(); // Imprime informacion sobre la excepcion
		}
	}

}
