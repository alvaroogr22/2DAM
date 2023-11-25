package examen1alvarogomezAD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {

  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    // Mediante una sentencia creamos la tabla
    String sql = "CREATE TABLE tvideojuegos (id INT PRIMARY KEY," +
        "nombre VARCHAR(50) NOT NULL," +
        "anio int," +
        "compañía VARCHAR(50)," +
        "precio DECIMAL," +
        "sinopsis VARCHAR(150)," +
        "plataforma VARCHAR(50))";
    try {
      conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:17770/dbgametop",
          "root",
          "");
      stmt = conn.createStatement();
      stmt.execute(sql);
      System.out.println("La tabla se ha creado");
      conn.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
