package examen1alvarogomezAD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDeDatos {

  public static void main(String[] args) {
    Connection conn = null; // creamos el objeto conexión
    Statement stmt = null; // Un Statement es una interfaz en Java
    String sql = "CREATE DATABASE dbgametop"; //Creamos la base de datos
    try {
      conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:17770/",
          "root",
          "");
      stmt = conn.createStatement();

      stmt.execute(sql);
      System.out.println("La base de datos se ha creado");
      conn.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace(); // imprime informacion sobre la excepcion
    }
  }
}
