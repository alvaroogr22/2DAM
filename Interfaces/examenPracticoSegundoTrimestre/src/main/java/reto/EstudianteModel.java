package reto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstudianteModel {

  private Connection conn;

  public EstudianteModel(String dbURL, String dbUser, String dbPassword)
    throws SQLException {
    conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
  }

  public List<Estudiante> getAllLibros() throws SQLException {
    List<Estudiante> estudiantes = new ArrayList<>();
    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM estudiantes");

    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
      int id = rs.getInt("id");
      String nombre = rs.getString("nombre");
      String correo = rs.getString("correo_electronico");
      String telefono = rs.getString("telefono");
      String curso = rs.getString("curso");
      String fecha = rs.getString("fecha_inscripcion");
      estudiantes.add(
        new Estudiante(id, nombre, correo, telefono, curso, fecha)
      );
    }
    stmt.close();
    rs.close();
    return estudiantes;
  }

  public void borrarRegistro(String nombreEstudiante) throws SQLException {
    String sql = "DELETE FROM estudiantes WHERE nombre=?";
    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
      preparedStatement.setString(1, nombreEstudiante);

      int filasAfectadas = preparedStatement.executeUpdate();
      if (filasAfectadas > 0) {
        System.out.println("Registro eliminado correctamente");
      } else {
        System.out.println(
          "No se encontró el registro con el título especificado"
        );
      }
    }
  }

  public void agregarEstudiante(Estudiante nuevoEstudiante)
    throws SQLException {
    String query =
      "INSERT INTO estudiantes (nombre, correo_electronico, telefono, curso, fecha_inscripcion) VALUES (?,?,?,?,?)";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
      stmt.setString(1, nuevoEstudiante.getNombre());
      stmt.setString(2, nuevoEstudiante.getCorreo_electronico());
      stmt.setString(3, nuevoEstudiante.getTelefono());
      stmt.setString(4, nuevoEstudiante.getCurso());
      stmt.setString(5, nuevoEstudiante.getFecha_inscripcion());

      stmt.executeUpdate();
    }
  }

  public void close() throws SQLException {
    conn.close();
  }
}
