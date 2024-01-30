package modelovistacontroladorsimulacro;

public class Producto {
    private int id;
    private String nombre;
    private String descripcion;
    private String fabricante;
    private Float precio;
    private String numero_serie;
    
    
	public Producto(int id, String nombre, String descripcion, String fabricante, Float precio, String numero_serie) {

		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fabricante = fabricante;
		this.precio = precio;
		this.numero_serie = numero_serie;
	}


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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}


	public String getNumero_serie() {
		return numero_serie;
	}


	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}



   
}
