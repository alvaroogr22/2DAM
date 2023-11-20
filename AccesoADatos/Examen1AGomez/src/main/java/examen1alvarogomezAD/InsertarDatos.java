package examen1alvarogomezAD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDatos {

  public static void main(String[] args){
    Connection conn = null;
    Statement stmt = null;
    // Creamos un String que hace una inyección para insertar datos en la tabla tvideojuegos
    String sql =
      "INSERT INTO tvideojuegos (id, nombre, anio, compañía, precio, sinopsis, plataforma)" +
      "VALUES (1, 'The Legend of Zelda: Breath of the Wild', 2017, 'Nintendo', 59.99, 'Aventura épica', 'Nintendo Switch')," +
      "(2, 'Red Dead Redeption 2', 2018, 'Rockstar Games', 49.99, 'Aventura del viejo oeste', 'PlayStation 4')," +
      "(3, 'Minecraft', 2011, 'Mojang', 29.99, 'Mundo Abierto', 'Multiplataforma')";
    try {
      conn =
        DriverManager.getConnection(
          "jdbc:mysql://localhost:17770/dbgametop",
          "root",
          ""
        );
      stmt = conn.createStatement();
      stmt.executeUpdate(sql);
      System.out.println("Datos insertados en la tabla");
      conn.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
