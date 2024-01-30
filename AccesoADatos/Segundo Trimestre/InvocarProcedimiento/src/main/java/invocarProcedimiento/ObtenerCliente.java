package invocarProcedimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObtenerCliente {

	public static void main(String[] args) {
		Connection conn=null;
		CallableStatement cstmt=null;
		PreparedStatement presta=null;
		String sql = "INSERT INTO clientes (id, nif, nombre, edad) " +
	             "VALUES (2, '22222', 'Cristina', 32)";
		
		String dropProcedure="DROP PROCEDURE IF EXISTS ObtenerClientes";
		String createProcedure ="CREATE PROCEDURE ObtenerClientes() "+
				"BEGIN " +
				"SELECT * FROM clientes WHERE id >=2" +
				"END;";
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:33306/empresa","root","");
			//Insertamos el cliente
			
			//presta=conn.prepareStatement(sql);
			//presta.executeUpdate();
			presta = conn.prepareStatement(dropProcedure);
			presta.executeUpdate();
			presta = conn.prepareStatement(createProcedure);
			presta.executeUpdate();
			System.out.println("Procedimiento creado");
			System.out.println("Cliente insertado correctamente");
	
		//Llamar al procedimiento almacenado
		cstmt=conn.prepareCall("call ObtenerClientes()");
		
		//Ejecutar el procedimiento
		cstmt.execute();
		
		//Obtener los resultados si el procedimiento devuelve algo:
		ResultSet rs=cstmt.getResultSet();
		while (rs.next()) {
			int id=rs.getInt("id");
			String nif=rs.getString("nif");
			String nombre=rs.getString("nombre");
			String edad=rs.getString("edad");
			System.out.println("id: "+id+" nif: "+nif+" nombre: "+nombre+" edad : "+edad);
		}
		System.out.println("Procedimiento invocado");
		conn.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
