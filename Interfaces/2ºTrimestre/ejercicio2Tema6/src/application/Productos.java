package application;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Productos {
	
	 private IntegerProperty codigo = new SimpleIntegerProperty();
	 private StringProperty nombre = new SimpleStringProperty();
	 private DoubleProperty precio = new SimpleDoubleProperty();
	 private IntegerProperty codigoFabricante = new SimpleIntegerProperty();
	    
	public Productos(int codigo, String nombre, Double precio, int codigoFabricante) {
		this.codigo.set(codigo);
		this.nombre.set(nombre);
        this.precio.set(precio);
        this.codigoFabricante.set(codigoFabricante);
	}


    // Métodos getter para propiedades observables
	public final int getCodigo() {
		return this.codigoProperty().get();
	}

	public final IntegerProperty codigoProperty() {
		return this.codigo;
	}
	
	public final void setCodigo(final int codigo) {
		this.codigoProperty().set(codigo);
	}

	
	
    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    
    
    public double getPrecio() {
        return precio.get();
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }


    
	public final int getCodigoFabricante() {
		return this.codigoFabricanteProperty().get();
	}
	

	public final IntegerProperty codigoFabricanteProperty() {
		return this.codigoFabricante;
	}

	public final void setCodigoFabricante(final int codigoFabricante) {
		this.codigoFabricanteProperty().set(codigoFabricante);
	}
	

    
    // Otros métodos y constructores
}
