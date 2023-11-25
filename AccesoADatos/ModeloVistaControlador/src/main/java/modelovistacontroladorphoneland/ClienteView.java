package modelovistacontroladorphoneland;
import java.util.List;
import java.sql.Connection;

public class ClienteView {
    // Método para mostrar los clientes en la vista
    public void mostrarProductos(List<Producto> productos) {
        for (Producto productos1: productos){
            System.out.println("ID: " + productos1.getId_PRODUCTO()); // Imprime el ID del cliente
            System.out.println("ID Proveedor: " + productos1.getId_proveedor()); // Imprime el NIF del cliente
            System.out.println("Nombre: " + productos1.getNOMBRE()); // Imprime el nombre del cliente
            System.out.println("Fabricante: " + productos1.getFABRICANTE()); // Imprime la edad del cliente
            System.out.println("Precio: " + productos1.getPRECIO()); // Imprime la edad del cliente
            System.out.println("PVP: " + productos1.getPVP()); // Imprime la edad del cliente
            System.out.println("Descripción: " + productos1.getDescripcion()); // Imprime la edad del cliente
            System.out.println("Columna 8: " + productos1.getColumna8()); // Imprime la edad del cliente
            System.out.println(); // Imprime una línea en blanco para separar los clientes
        }
    }
}
