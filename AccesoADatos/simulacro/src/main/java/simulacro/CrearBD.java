package simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		Statement stat=null;
		String sql="CREATE DATABASE simulacro";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/","root","");
			stat=conn.createStatement();
			stat.execute(sql);
			System.out.println("Creada la base de datos Simulacro");
			
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
