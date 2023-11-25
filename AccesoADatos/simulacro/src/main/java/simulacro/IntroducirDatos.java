package simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class IntroducirDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement stat=null;
		String sql="INSERT INTO productos (id, nombre, descripcion, fabricante, precio, numero_serie) VALUES "
				+ "(1,'Portatil','Portatil gama alta','HP',1500,'111'),"
				+ "(2,'Portatil','Portatil gama baja','Apple',1000,'222'),"
				+ "(3,'Monitor','Monitor gama alta','LG',800,'333'),"
				+ "(4,'Monitor','Monitor gama baja','HP',200,'444')";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/simulacro","root","");
			stat=conn.createStatement();
			stat.execute(sql);
			System.out.println("Datos insertados correctamente en la tabla PRODUCTOS");
			
			stat.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}
