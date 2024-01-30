package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {

	public static void main(String[] args) {
		// Aquí, al igual que en el resto de clases, tenemos que recordar introducir el nombre de nuestra base de datos en el getConnection. Además, en la sentencia sql tenemos que introducir correctamente el nombre tanto de la tabla como de las distintas columnas, siguiendo el mismo orden y respetando tanto mayúsculas como minúsculas.
		Connection conn=null;
		Statement stat=null;
		String sql="INSERT INTO tvideojuegos (idjuego, nombre, anio, compañia, precio, sinopsis, plataforma) VALUES "
				+ "(1, 'The Legend of Zelda: Breath of the Wild',2017,'Nintendo',59.99,'Aventura épica','Nintendo Switch'),"
				+ "(2, 'Red Dead Redemption 2',2018,'Rockstar Games',49.99,'Aventura del viejo oeste','PlayStation 4'),"
				+ "(3, 'Minecraft',2011,'Mojang',29.99,'Mundo abierto y construcción','Multiplataforma')";

		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/dbgametop","root","");
			stat=conn.createStatement();
			stat.execute(sql);
			System.out.println("Datos insertados correctamente en la tabla tvideojuegos");
			//SIEMPRE debemos cerrar las conexiones. Para ello usamos ".close()"
			stat.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}
