package simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		String sql="CREATE TABLE productos (id INT PRIMARY KEY,"
				+"nombre varchar(20) NOT NULL,"
				+"descripcion varchar(50) NOT NULL,"
				+"fabricante varchar(20),"
				+"precio float NOT NULL,"
				+"numero_serie varchar(20) NOT NULL)";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/simulacro","root","");
			stat=conn.createStatement();
			stat.execute(sql);
			System.out.println("Creada la tabla PRODUCTOS");
			
			conn.close();
			stat.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}
