package conectarmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		String sql = "CREATE TABLE productos (id INT PRIMARY KEY,"
				+ "nombre VARCHAR(60) NOT NULL,"
				+ "tipo_de_gama VARCHAR(40),"
				+ "marca VARCHAR(20),"
				+ "precio DOUBLE,"
				+ "numero_de_serie VARCHAR(10))";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:17770/simulacro", "root", "");
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Tabla \"clientes\" creada correctamente");
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
