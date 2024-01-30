package ejercicio2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio2EliminarDatos {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		Statement stmt=null;
		System.out.println("Dime el nombre del fabricante que quieres borrar: HP o Lenovo");
		String fabricante=sc.nextLine();
		String sql= "DELETE FROM productos WHERE fabricante='"+fabricante+"'";

		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/tiendapc","root","");
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Datos eliminados correctamente");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

