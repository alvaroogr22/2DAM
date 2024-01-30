package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio2_4 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String sql= "SELECT * FROM productos";

		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/tiendapc","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while (rs.next()) {
				int id=rs.getInt("id");
				String nombre=rs.getString("nombreProduct");
				String fabricante=rs.getString("fabricante");
				System.out.println("id: "+id+", nombre: "+nombre+", fabricante: "+fabricante);
			}
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
