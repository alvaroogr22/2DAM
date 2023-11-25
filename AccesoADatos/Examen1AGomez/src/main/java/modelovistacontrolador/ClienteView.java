package modelovistacontrolador;

import java.util.List;

public class ClienteView {
    // Método para mostrar los clientes en la vista
    public void mostrarClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Año: " + cliente.getAnio());
            System.out.println("Compañía: " + cliente.getCompañia());
            System.out.println("Precio: " + cliente.getPrecio());
            System.out.println("Sinopsis: " + cliente.getSinopsis());
            System.out.println();

        }
    }
}
