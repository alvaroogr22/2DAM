package mvcExamen;

public class Videojuego {
    private int idjuego;
    private String nombre;
    private int anio;
    private String compañia;
    private Float precio;
    private String sinopsis;
    private String plataforma;
    
	public Videojuego(int idjuego, String nombre, int anio, String compañia, Float precio, String sinopsis,
			String plataforma) {
		super();
		this.idjuego = idjuego;
		this.nombre = nombre;
		this.anio = anio;
		this.compañia = compañia;
		this.precio = precio;
		this.sinopsis = sinopsis;
		this.plataforma = plataforma;
	}

	public int getIdjuego() {
		return idjuego;
	}

	public void setIdjuego(int idjuego) {
		this.idjuego = idjuego;
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

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
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
   


   
}
