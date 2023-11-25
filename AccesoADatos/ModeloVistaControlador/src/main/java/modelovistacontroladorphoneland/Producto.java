package modelovistacontroladorphoneland;

public class Producto {
    private int id_PRODUCTO;
    private int id_proveedor;
    private String NOMBRE;
    private String FABRICANTE;
    private String PRECIO;
    private Float PVP;
    private String Descripcion;
    private int Columna8;
	public Producto(int id_PRODUCTO, int id_proveedor, String nOMBRE, String fABRICANTE, String pRECIO, Float pVP,
			String descripcion, int columna8) {
		super();
		this.id_PRODUCTO = id_PRODUCTO;
		this.id_proveedor = id_proveedor;
		NOMBRE = nOMBRE;
		FABRICANTE = fABRICANTE;
		PRECIO = pRECIO;
		PVP = pVP;
		Descripcion = descripcion;
		Columna8 = columna8;
	}
	public int getId_PRODUCTO() {
		return id_PRODUCTO;
	}
	public void setId_PRODUCTO(int id_PRODUCTO) {
		this.id_PRODUCTO = id_PRODUCTO;
	}
	public int getId_proveedor() {
		return id_proveedor;
	}
	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public String getFABRICANTE() {
		return FABRICANTE;
	}
	public void setFABRICANTE(String fABRICANTE) {
		FABRICANTE = fABRICANTE;
	}
	public String getPRECIO() {
		return PRECIO;
	}
	public void setPRECIO(String pRECIO) {
		PRECIO = pRECIO;
	}
	public Float getPVP() {
		return PVP;
	}
	public void setPVP(Float pVP) {
		PVP = pVP;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public int getColumna8() {
		return Columna8;
	}
	public void setColumna8(int columna8) {
		Columna8 = columna8;
	}
    
    
	
   
}
