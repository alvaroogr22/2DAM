package modelovistacontrolador;

public class Cliente {
    private int id;
    private String nombre;
    private int anio;
    private String compañia;
    private Float precio;
    private String sinopsis;

    // Creamos contructor y getters
    public Cliente(int id, String nombre, int anio, String compañia, Float precio, String sinopsis) {
        this.id = id;
        this.nombre = nombre;
        this.anio = anio;
        this.compañia = compañia;
        this.precio = precio;
        this.sinopsis = sinopsis;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public String getCompañia() {
        return compañia;
    }

    public Float getPrecio() {
        return precio;
    }

    public String getSinopsis() {
        return sinopsis;
    }

}
