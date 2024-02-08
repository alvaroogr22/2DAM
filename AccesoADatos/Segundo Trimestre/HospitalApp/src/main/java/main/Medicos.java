package main;

import javax.persistence.*;

@Entity
@Table(name = "medicos")
public class Medicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "especialidad")
    private String especialidad;

    // Constructor por defecto requerido por Hibernate
    public Medicos() {
    }

    // Constructor para crear un objeto de tipo Medico con campos específicos
    public Medicos(String nombre, String apellidos, String especialidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.especialidad = especialidad;
    }

    // Getters y setters

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    // Método para imprimir la información del objeto Medico
    @Override
    public String toString() {
        return "Medico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
