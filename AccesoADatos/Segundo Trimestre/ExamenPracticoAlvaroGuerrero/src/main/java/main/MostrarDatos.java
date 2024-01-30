package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {

	public static void main(String[] args) {
		// Aquí, al igual que en el resto de clases, tenemos que recordar introducir el nombre de nuestra base de datos en el getConnection. Además, en la sentencia sql tenemos que introducir correctamente el nombre tanto de la tabla como de las distintas columnas, siguiendo el mismo orden y respetando tanto mayúsculas como minúsculas.
		Connection conn = null;
		Statement stat = null;
		String sql = "SELECT * from tvideojuegos";

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33306/dbgametop", "root", "");
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("idjuego");
				String nombre = rs.getString("nombre");
				int anio = rs.getInt("anio");
				String compañia = rs.getString("compañia");
				Float precio = rs.getFloat("precio");
				String sinopsis = rs.getString("sinopsis");
				String plataforma = rs.getString("plataforma");
				System.out.println("ID: " + id + "\nNombre: " + nombre + " \nAño: " + anio
						+ " \nCompañía: " + compañia + " \nPrecio: " + precio + " \nSinopsis: " + sinopsis+" \nPlataforma: "+plataforma);
				System.out.println("|------------------ESTO ES UN SEPARADOR------------------|");
			}
			
			//SIEMPRE debemos cerrar las conexiones. Si tenemos rs, stat y conn, debemos cerrar LAS TRES"
			rs.close();
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
