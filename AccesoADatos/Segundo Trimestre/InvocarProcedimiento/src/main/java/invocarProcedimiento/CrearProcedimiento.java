package invocarProcedimiento;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearProcedimiento {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement presta=null; //Ojo que aqui se cambia ya el nombre de la variable
		String dropProcedure="DROP PROCEDURE IF EXISTS ObtenerClientes";
		String createProcedure ="CREATE PROCEDURE ObtenerClientes() "+
				"BEGIN " +
				"SELECT * FROM clientes;" +
				"END;";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33306/empresa","root","");
			if(conn!=null) {
				System.out.println("Conexion a la base de datos correcta");
			}
			presta = conn.prepareStatement(dropProcedure);
			presta.executeUpdate();
			presta = conn.prepareStatement(createProcedure);
			presta.executeUpdate();
			System.out.println("Procedimiento creado");
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
