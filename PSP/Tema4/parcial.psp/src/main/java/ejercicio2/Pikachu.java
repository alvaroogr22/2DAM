package ejercicio2;

import java.io.Serializable;

public class Pikachu implements Serializable {
	private String nombre;

	public Pikachu() {
		nombre = "Pika";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
