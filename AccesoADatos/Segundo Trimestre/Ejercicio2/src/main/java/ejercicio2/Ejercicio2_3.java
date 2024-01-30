package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2_3 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String sql= "INSERT INTO productos (id, nombreProduct, fabricante)"
				+"VALUES (1, 'Portatil', 'HP'),"+ "(2, 'Tablet', 'Lenovo')";

		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/tiendapc","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}