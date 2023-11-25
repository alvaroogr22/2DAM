package examen1alvarogomezAD;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InvocarProcedimiento {

  public static void main(String[] args) {
    Connection conn = null;
    // definimos un objeto callableStatement sirve para
    // preparar la ejecución del procedimiento
    CallableStatement cstmt = null;

    try {
      conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:17770/dbgametop",
          "root",
          "");

      // Llamar al procedimiento almacenado
      cstmt = conn.prepareCall("call ObtenerDatos()");
      cstmt.execute();
      ResultSet rs = cstmt.getResultSet();

      //Mostramos lo realizado
      while (rs.next()) {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        int anio = rs.getInt("anio");
        String compañia = rs.getString("compañía");
        Float precio = rs.getFloat("precio");
        String sinopsis = rs.getString("sinopsis");
        System.out.println(
            "id: " +
                id +
                ", Nombre: " +
                nombre +
                ", anio: " +
                anio +
                ", compañia: " +
                compañia +
                ", Precio: " +
                precio +
                ", sinopsis: " +
                sinopsis +
                ", plataforma: " +
                sinopsis);
      }

      System.out.println("Procedimiento invocado");

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
