<<<<<<<< HEAD:AccesoADatos/ModeloVistaControlador/src/main/java/modelovistacontrolador/Main.java
package modelovistacontrolador;
========
package modelovistacontroladorphoneland;
>>>>>>>> b5b0ff9d8ceaf5475dd92794131a5e3a5436b50f:AccesoADatos/Conectamysql/src/main/java/modelovistacontroladorphoneland/Main.java

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
<<<<<<<< HEAD:AccesoADatos/ModeloVistaControlador/src/main/java/modelovistacontrolador/Main.java
        String dbURL = "jdbc:mysql://localhost:33306/empresa";// URL de la base de datos
========
        String dbURL = "jdbc:mysql://localhost:33306/phoneland";// URL de la base de datos
>>>>>>>> b5b0ff9d8ceaf5475dd92794131a5e3a5436b50f:AccesoADatos/Conectamysql/src/main/java/modelovistacontroladorphoneland/Main.java
        String dbUser = "root"; // Usuario de la base de datos
        String dbPassword = ""; // Contraseña del usuario

        try {
            ClienteController controller = new ClienteController(dbURL, dbUser, dbPassword); // Crea una instancia del controlador
            controller.mostrarClientes(); // Llama al método del controlador para mostrar los clientes
            controller.cerrarConexion(); // Llama al método del controlador para cerrar la conexión a la base de datos
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja las excepciones de SQL imprimiendo el error
        }
    }
}

