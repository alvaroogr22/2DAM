package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		Statement stmt=null;
		System.out.println("Dime el nombre de la base de datos (TiendaPc)");
		String nombreBaseDatos=sc.nextLine();
		String sql="CREATE DATABASE "+nombreBaseDatos;
		String sql2= "CREATE TABLE productos (id INT PRIMARY KEY,"
				+"nombreProduct VARCHAR(40) NOT NULL,"
				+"fabricante VARCHAR (30))";
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/tiendapc","root","");
			stmt=conn.createStatement();
			stmt.execute(sql);
			System.out.println("Base de datos "+nombreBaseDatos+" creada correctamente");
			stmt.execute(sql2);
			System.out.println("Tabla creada correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
