package simulacro;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class InvocarProcedimiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		CallableStatement stat=null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:33306/simulacro","root","");
			stat=conn.prepareCall("call CalculaIVA(?,?)");
			stat.setDouble(1, 100.0);
			stat.registerOutParameter(2, Types.DECIMAL);
			stat.execute();
			
			double precioConIva=stat.getDouble(2);//El parametro 2 es el que tiene que devolver
			System.out.println("Procedimiento invocado correctamente");
			System.out.println("El importe con iva es "+precioConIva);
			
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
