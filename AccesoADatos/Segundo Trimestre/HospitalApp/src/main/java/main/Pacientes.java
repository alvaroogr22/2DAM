package main;

import javax.persistence.*;

@Entity
@Table(name = "pacientes")
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "edad")
    private int edad;

    @Column(name = "historial")
    private String historial;

    // Constructor por defecto requerido por Hibernate
    public Pacientes() {
    }

    // Constructor para crear un objeto de tipo Paciente con campos específicos
    public Pacientes(String nombre, String apellidos, String ciudad, String direccion, String telefono, int edad, String historial) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.historial = historial;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    // Método para imprimir la información del objeto Paciente
    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                ", historial='" + historial + '\'' +
                '}';
    }
}
