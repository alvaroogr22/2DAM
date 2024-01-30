package main;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class LlamarAlProcedimiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		CallableStatement cstmt=null; //Para llamar a procedimientos ya creados usamos la interfaz CallableStatement
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/dbgametop","root","");
	
		//Llamar al procedimiento almacenado
		cstmt=conn.prepareCall("call nombreJuego()");
		
		//Ejecutar el procedimiento
		cstmt.execute();
		
		//Obtener los resultados si el procedimiento devuelve algo:
		ResultSet rs=cstmt.getResultSet();
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
		System.out.println();
		System.out.println("Procedimiento invocado correctamente.");
		cstmt.close();
		conn.close();
		rs.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
