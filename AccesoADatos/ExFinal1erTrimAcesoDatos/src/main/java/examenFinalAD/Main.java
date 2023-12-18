package examenFinalAD;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/instituto";// URL de la base de datos
        String dbUser = "root"; // Usuario de la base de datos
        String dbPassword = "admin"; // Contraseña del usuario

        try {
            AlumnoController controller = new AlumnoController(dbURL, dbUser, dbPassword);
            controller.mostrarAlumnos();
            controller.cerrarConexion();
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja las excepciones de SQL imprimiendo el error
        }
    }
}