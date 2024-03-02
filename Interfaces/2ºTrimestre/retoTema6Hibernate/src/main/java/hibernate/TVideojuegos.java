package hibernate;

import javafx.beans.property.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tvideojuegos")
public class TVideojuegos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idjuego") // Cambiar el nombre de la columna aquí
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

    // Constructor por defecto requerido por Hibernate
    public TVideojuegos() {
    }

    // Constructor para crear un objeto de tipo fabricante con un nombre específico
    public TVideojuegos(String nombre, int anio, String compañia, Double precio, String sinopsis, String plataforma) {
        this.nombre = nombre;
        this.anio = anio;
        this.compañia = compañia;
        this.precio = precio;
        this.sinopsis = sinopsis;
        this.plataforma = plataforma;
    }


    
    

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	// Propiedades para JavaFX
    public IntegerProperty idProperty() {
        return new SimpleIntegerProperty(id);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	// Propiedades para JavaFX
    public StringProperty nombreProperty() {
        return new SimpleStringProperty(nombre);
    }

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}
	// Propiedades para JavaFX
    public IntegerProperty anioProperty() {
        return new SimpleIntegerProperty(anio);
    }

	public String getCompañia() {
		return compañia;
	}

	public void setCompañia(String compañia) {
		this.compañia = compañia;
	}
	// Propiedades para JavaFX
    public StringProperty compañiaProperty() {
        return new SimpleStringProperty(compañia);
    }

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	// Propiedades para JavaFX
    public DoubleProperty precioProperty() {
        return new SimpleDoubleProperty(precio);
    }

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	// Propiedades para JavaFX
    public StringProperty sinopsisProperty() {
        return new SimpleStringProperty(sinopsis);
    }

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	// Propiedades para JavaFX
    public StringProperty plataformaProperty() {
        return new SimpleStringProperty(plataforma);
    }



}
