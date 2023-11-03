package conectamysql;

import java.sql.*;

public class CrearProcedimiento {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement presta = null; // Cambio de nombre de la variable
        String dropProcedure = "DROP PROCEDURE IF EXISTS ObtenerClientes";
        String createProcedure = "CREATE PROCEDURE ObtenerClientes() " +
                "BEGIN " +
                "SELECT * FROM clientes;" +
                "END;";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:17770/empresa", "root", "");

            // Primero, eliminamos el procedimiento si existe
            presta = conn.prepareStatement(dropProcedure);
            presta.executeUpdate();

            // Luego, creamos el procedimiento
            presta = conn.prepareStatement(createProcedure);
            presta.executeUpdate();

            System.out.println("Procedimiento creado");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}