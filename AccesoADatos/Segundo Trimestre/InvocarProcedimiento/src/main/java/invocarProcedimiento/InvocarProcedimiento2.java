package invocarProcedimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class InvocarProcedimiento2 {

	public static void main(String[] args) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phoneland","root","Gv3rr3r0160294!");
	
		//Llamar al procedimiento almacenado
		cstmt=conn.prepareCall("call CalcularEdad(?,?)");
		cstmt.setInt(1, 1994); //1 es el primer valor del argumento del procedimiento
		cstmt.registerOutParameter(2, Types.INTEGER);
		
		//Ejecutar el procedimiento
		cstmt.execute();
		
		//Obtener los resultados si el procedimiento devuelve algo:
		int edad=cstmt.getInt(2); //El parametro 2 es el que me tiene que devolver
		System.out.println("Procedimiento invocado. \n\tLa edad es: "+edad);
		conn.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
