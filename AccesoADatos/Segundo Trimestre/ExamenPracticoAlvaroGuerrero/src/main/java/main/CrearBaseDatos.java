package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDatos {

	public static void main(String[] args) {
		//Con este bloque de código creamos la base de datos, conectándonos al gestor y, usando el string con la instrucción adecuada, creándola.
		Connection conn=null;
		Statement stat=null;
		String sql="CREATE DATABASE dbgametop";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/","root","");
			stat=conn.createStatement();
			stat.execute(sql);
			System.out.println("Creada la base de datos dbgametop");
			//Si el mensaje se muestra por consola, la base de datos se habrá creado correctamente.
			//SIEMPRE debemos cerrar las conexiones. Para ello usamos ".close()"
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
