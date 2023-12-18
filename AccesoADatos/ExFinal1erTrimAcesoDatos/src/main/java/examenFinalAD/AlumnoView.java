package examenFinalAD;
import java.util.List;
import java.sql.Connection;

public class AlumnoView {
    // Método que imprime la información
    public void mostrarAlumnos(List<Alumno> Alumnos) {
        for (Alumno Alumno : Alumnos) {
            System.out.println("id: " + Alumno.getId());
            System.out.println("nombre: " + Alumno.getNombre());
            System.out.println("apellido1: " + Alumno.getApellido1());
            System.out.println("apellido2: " + Alumno.getApellido2());
            System.out.println("fecha_nacimiento: " + Alumno.getFecha_nacimiento());
            System.out.println("es_repetidor: " + Alumno.getEs_repetidor());
            System.out.println("telefono: " + Alumno.getTelefono());

            System.out.println();
        }
    }
}
