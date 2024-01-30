package mvcExamen;
import java.util.List;
import java.sql.Connection;

public class AlumnoView {
    // Método para mostrar los alumnos en la vista
    public void mostrarProductos(List<Alumno> alumnos) {
        for (Alumno alumnos1: alumnos){
            System.out.println("ID: " + alumnos1.getId());
            System.out.println("Nombre: " + alumnos1.getNombre()); 
            System.out.println("Primer apellido: " + alumnos1.getApellido1());
            System.out.println("Segundo apellido: " + alumnos1.getApellido2());
            System.out.println("Fecha de nacimiento: " + alumnos1.getFecha_nacimiento()); // Imprime la edad del cliente
            System.out.println("¿Es repetidor?: " + alumnos1.getEs_repetidor()); // Imprime la edad del cliente
            System.out.println("Número de teléfono: "+alumnos1.getTelefono());
            System.out.println();
        }
    }
}
