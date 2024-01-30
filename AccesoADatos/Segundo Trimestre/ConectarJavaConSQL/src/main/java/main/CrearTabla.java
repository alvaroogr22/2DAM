package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String sql= "CREATE TABLE clientes (id INT PRIMARY KEY,"
				+"nif VARCHAR(10) NOT NULL,"
				+"nombre VARCHAR(60) NOT NULL,"
				+"edad VARCHAR (2))";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/empresa","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("Tabla \"clientes\" creada correctamente");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
