package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearProcedimiento {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement presta=null; //Ya no usamos Statement, sino PreparedStatement
		
		//Primero dropeamos cualquier procedimiento que existiese con el mismo nombre. Obviamente la primera vez que lo ejecutemos no servirá para nada, pero si ejecutamos esta clase más veces sí que eliminará el procedimiento previamente existente para crear uno nuevo y así evitar posibles errores.
		String dP="DROP PROCEDURE IF EXISTS nombreJuego";
		String cP ="CREATE PROCEDURE nombreJuego() "+
				"BEGIN " +
				"SELECT * FROM tvideojuegos;" +
				"END;";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33306/dbgametop","root","");
			if(conn!=null) {
				System.out.println("Conexion a la base de datos correcta");
				System.out.println();
			}
			presta = conn.prepareStatement(dP);
			presta.executeUpdate();
			presta = conn.prepareStatement(cP);
			presta.executeUpdate();
			System.out.println("Procedimiento nombreJuego creado con éxito. "
					+ "\nAlberto, esto es un positivillo, ¿no? ;)");
			
			
			//Como siempre, cerramos las conexiones.
			presta.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
