package examen1alvarogomezAD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {

  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    //Extraemos los datos
    String sql = "SELECT * FROM tvideojuegos";
    try {
      conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:17770/dbgametop",
          "root",
          "");
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      //Mostramos los datos con el bucle
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

      conn.close();
      stmt.close();
      rs.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
