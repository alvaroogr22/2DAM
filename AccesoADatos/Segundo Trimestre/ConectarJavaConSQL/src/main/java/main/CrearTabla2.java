package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla2 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stmt=null;
		String sql= "CREATE TABLE productos (id INT PRIMARY KEY,"
				+"nombre VARCHAR(60) NOT NULL,"
				+"descripcion VARCHAR (100),"
				+ "precio DOUBLE NOT NULL,"
				+ "categoria VARCHAR(50))";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/empresa","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("Tabla \"productos\" creada correctamente");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
