package modelovistacontroladorsimulacro;
import java.util.List;
import java.sql.Connection;

public class ClienteView {
    // Método para mostrar los clientes en la vista
    public void mostrarProductos(List<Producto> productos) {
        for (Producto productos1: productos){
            System.out.println("ID: " + productos1.getId()); // Imprime el ID del cliente
            System.out.println("Nombre: " + productos1.getNombre()); // Imprime el NIF del cliente
            System.out.println("Descripción: " + productos1.getDescripcion()); // Imprime el nombre del cliente
            System.out.println("Fabricante: " + productos1.getFabricante()); // Imprime la edad del cliente
            System.out.println("Precio: " + productos1.getPrecio()); // Imprime la edad del cliente
            System.out.println("Número de serie: " + productos1.getNumero_serie()); // Imprime la edad del cliente
            System.out.println(); // Imprime una línea en blanco para separar los clientes
        }
    }
}
