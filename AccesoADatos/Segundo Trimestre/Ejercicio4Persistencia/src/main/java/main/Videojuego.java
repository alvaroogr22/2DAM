package main;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "tvideojuegos")

public class Videojuego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idjuego")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "anio")
	private int anio;
	
	@Column(name = "compañia")
	private String compañia;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "sinopsis")
	private String sinopsis;
	
	@Column(name = "plataforma")
	private String plataforma;
	
	
	
	//Constructor por defecto requerido por Hibernate
	
	public Videojuego() {
		
	}
	
	//Constructor para crear un objeto de tipo Clientes con un nombre y ciudad específicos

	public Videojuego(String nombre, int anio, String compañia, Double precio, String sinopsis,
			String plataforma) {

		this.nombre = nombre;
		this.anio = anio;
		this.compañia = compañia;
		this.precio = precio;
		this.sinopsis = sinopsis;
		this.plataforma = plataforma;
	}
	public Videojuego(int anio, String compañia,String nombre, String plataforma, Double precio, String sinopsis) {

		this.nombre = nombre;
		this.anio = anio;
		this.compañia = compañia;
		this.precio = precio;
		this.sinopsis = sinopsis;
		this.plataforma = plataforma;
	}
	

	//Getter y setter


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

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	//Método para imprimir la información del objeto Fabricante
		@Override
		public String toString() {
			return "Videojuego{" +
					"id=" + id +
					", Nombre='" + nombre + '\'' +
					", Año='" + anio + '\'' +
					", Compañía='" + compañia + '\'' +
					", Precio='" + precio + '\'' +
					", Sinopsis='" + sinopsis + '\'' +
					", Plataforma='" + plataforma + '\'' +
					'}';
		}
}
