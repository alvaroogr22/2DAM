package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioEliminarTabla {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String sql= "DROP TABLE productos";

		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/tiendapc","root","");
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Tabla eliminados correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

