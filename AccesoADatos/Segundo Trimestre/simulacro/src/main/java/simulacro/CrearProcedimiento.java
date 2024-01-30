package simulacro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearProcedimiento {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement stat=null;
		String drop="DROP PROCEDURE IF EXISTS CalculaIVA";
		String create=
				  "CREATE PROCEDURE CalculaIVA (in precio decimal(10,2), out total decimal(10,2))"
				+ "BEGIN"
				+ "	DECLARE iva DECIMAL (10,2);"
				+ "	SET iva=0.21;"
				+ "	SET total=precio+(precio*iva);"
				+ "END;";
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33306/simulacro","root","");
			if (conn!=null) {
				System.out.println("Conexión con la base de datos establecida correctamente");
			}
			stat=conn.prepareStatement(drop);
			stat.executeUpdate();
			System.out.println("Procedimiento eliminado correctamente");
	
			stat=conn.prepareStatement(create);
			stat.executeUpdate();
			System.out.println("Procedimiento creado correctamente");
			
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
