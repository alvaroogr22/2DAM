package mvcExamen;
import java.util.List;
import java.sql.Connection;

public class ClienteView {
    // Método para mostrar los clientes en la vista
    public void mostrarProductos(List<Videojuego> videojuegos) {
        for (Videojuego videojuego: videojuegos){
            System.out.println("ID: " + videojuego.getIdjuego()); // Imprime el ID del juego
            System.out.println("Nombre: " + videojuego.getNombre()); // Imprime el nombre del juego
            System.out.println("Año: " + videojuego.getAnio()); // Imprime el año de publicación del juego
            System.out.println("Compañía: " + videojuego.getCompañia()); // Imprime la compañía que poublicó el juego
            System.out.println("Precio: " + videojuego.getPrecio()); // Imprime el precio del juego
            System.out.println("Sinopsis: " + videojuego.getSinopsis()); // Imprime la sinopsis del juego
            System.out.println("Plataforma: " + videojuego.getPlataforma()); //Imprime la plataforma en la que se publicó el juego
            System.out.println();
        }
    }
}
