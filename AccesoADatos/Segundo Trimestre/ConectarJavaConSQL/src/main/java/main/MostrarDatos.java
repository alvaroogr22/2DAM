package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String sql= "INSERT INTO clientes (id, nif, nombre, edad)"
				+"VALUES (1, '11111', 'Alvaro', '29')";

		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/empresa","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("Datos insertados en la tabla \"clientes\" correctamente");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
