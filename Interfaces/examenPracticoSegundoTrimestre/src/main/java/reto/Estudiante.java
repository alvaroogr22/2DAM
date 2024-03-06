package reto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Estudiante {

  private int id;
  private String nombre = new String();
  private String correo_electronico = new String();
  private String telefono = new String();
  private String curso = new String();
  private String fecha_inscripcion = new String();

  public Estudiante(
    int id,
    String nombre,
    String correo_electronico,
    String telefono,
    String curso,
    String fecha_inscripcion
  ) {
    this.id = id;
    this.nombre = nombre;
    this.correo_electronico = correo_electronico;
    this.telefono = telefono;
    this.curso = curso;
    this.fecha_inscripcion = fecha_inscripcion;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCorreo_electronico() {
    return correo_electronico;
  }

  public void setCorreo_electronico(String correo_electronico) {
    this.correo_electronico = correo_electronico;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getFecha_inscripcion() {
    return fecha_inscripcion;
  }

  public void setFecha_inscripcion(String fecha_inscripcion) {
    this.fecha_inscripcion = fecha_inscripcion;
  }
}
