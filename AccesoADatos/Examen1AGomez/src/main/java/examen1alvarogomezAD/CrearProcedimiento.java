package examen1alvarogomezAD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearProcedimiento {

  public static void main(String[] args) {
    Connection conn = null;
    // creamos una interfaz preparedStatement
    PreparedStatement presta = null;
    String dropProcedure = "DROP PROCEDURE IF EXISTS ObtenerDatos"; // Creamos las sentencias de dropear y crear
    String createProcedure = "CREATE PROCEDURE ObtenerDatos() " +
        "BEGIN " +
        "SELECT * FROM tvideojuegos;" +
        "END;";

    try {
      conn = DriverManager.getConnection(
          "jdbc:mysql://localhost:17770/dbgametop",
          "root",
          "");
      presta = conn.prepareStatement(dropProcedure);
      // ejecutamos el procedimiento
      presta.executeUpdate();
      // Creamos el procedimiento
      presta = conn.prepareStatement(createProcedure);
      // Lo ejecutamos
      presta.executeUpdate();

      System.out.println("Procedimiento creado");

      conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
