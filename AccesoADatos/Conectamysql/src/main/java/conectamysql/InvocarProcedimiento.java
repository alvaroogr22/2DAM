package conectamysql;

import java.sql.*;

public class InvocarProcedimiento {
public static void main(String[] args) {
        Connection conn = null;
        CallableStatement cstmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:17770/empresa", "root", "");
            // Llamar al procedimiento almacenado
            cstmt = conn.prepareCall("call ObtenerClientes()");

            // Ejecutar el procedimiento
            cstmt.execute();

            // Obtener los resultados si el procedimiento devuelve algo
            ResultSet rs = cstmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nif = rs.getString("nif");
                String nombre = rs.getString("nombre");
                String edad = rs.getString("edad");
                System.out.println("id: " + id + ", nif: " + nif + ", "
                		+ "nombre: " + nombre + ", edad: " + edad);
            }

            System.out.println("Procedimiento invocado");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
