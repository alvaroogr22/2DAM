package conectarmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InvocarProcedimientoIva {

  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    String sql = "SELECT * FROM productos";
    try {
      conn =
        DriverManager.getConnection(
          "jdbc:mysql://localhost:17770/simulacro",
          "root",
          ""
        );
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
