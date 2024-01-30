package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		String sql="CREATE TABLE tvideojuegos (idjuego INT PRIMARY KEY,"
				+"nombre varchar(50) NOT NULL,"
				+"anio INT,"
				+"compañia varchar(50),"
				+"precio decimal(10,2),"
				+"sinopsis varchar(150),"
				+"plataforma VARCHAR(50))";
		
		try { //Tenemos que tener en cuenta que, para que esta clase funcione correctamente, debemos añadir el nombre de la base de datos previamente creada después del puerto.
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/dbgametop","root","");
			stat=conn.createStatement();
			stat.execute(sql);
			System.out.println("Creada la tabla tvideojuegos");
			//SIEMPRE debemos cerrar las conexiones. Para ello usamos ".close()"
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}
