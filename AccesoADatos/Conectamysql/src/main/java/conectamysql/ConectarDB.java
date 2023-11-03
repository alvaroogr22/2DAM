package conectamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarDB {

	public static void main(String[] args) {
		Connection connect = null;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:17770/empresa", "root", "");
			if (connect != null) {
				System.out.println("La conexión se ha realizado correctamente");
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
