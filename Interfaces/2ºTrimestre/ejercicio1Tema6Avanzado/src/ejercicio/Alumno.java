package ejercicio;

import javafx.beans.property.*;

public class Alumno {

	private StringProperty nombre = new SimpleStringProperty();
	private StringProperty apellido1 = new SimpleStringProperty();
	private StringProperty apellido2 = new SimpleStringProperty();
	private StringProperty fecha_nacimiento = new SimpleStringProperty();
	private StringProperty es_repetidor = new SimpleStringProperty();
	private StringProperty telefono = new SimpleStringProperty();

	public Alumno(int id, String nombre, String apellido1, String apellido2, String fecha_nacimiento,
			String es_repetidor, String telefono) {
		this.nombre.set(nombre);
		this.apellido1.set(apellido1);
		this.apellido2.set(apellido2);
		this.fecha_nacimiento.set(fecha_nacimiento);
		this.es_repetidor.set(es_repetidor);
		this.telefono.set(telefono);
	}

	public final StringProperty nombreProperty() {
		return this.nombre;
	}
	

	public final String getNombre() {
		return this.nombreProperty().get();
	}
	

	public final void setNombre(final String nombre) {
		this.nombreProperty().set(nombre);
	}
	

	public final StringProperty apellido1Property() {
		return this.apellido1;
	}
	

	public final String getApellido1() {
		return this.apellido1Property().get();
	}
	

	public final void setApellido1(final String apellido1) {
		this.apellido1Property().set(apellido1);
	}
	

	public final StringProperty apellido2Property() {
		return this.apellido2;
	}
	

	public final String getApellido2() {
		return this.apellido2Property().get();
	}
	

	public final void setApellido2(final String apellido2) {
		this.apellido2Property().set(apellido2);
	}
	

	public final StringProperty fecha_nacimientoProperty() {
		return this.fecha_nacimiento;
	}
	

	public final String getFecha_nacimiento() {
		return this.fecha_nacimientoProperty().get();
	}
	

	public final void setFecha_nacimiento(final String fecha_nacimiento) {
		this.fecha_nacimientoProperty().set(fecha_nacimiento);
	}
	

	public final StringProperty es_repetidorProperty() {
		return this.es_repetidor;
	}
	

	public final String getEs_repetidor() {
		return this.es_repetidorProperty().get();
	}
	

	public final void setEs_repetidor(final String es_repetidor) {
		this.es_repetidorProperty().set(es_repetidor);
	}
	

	public final StringProperty telefonoProperty() {
		return this.telefono;
	}
	

	public final String getTelefono() {
		return this.telefonoProperty().get();
	}
	

	public final void setTelefono(final String telefono) {
		this.telefonoProperty().set(telefono);
	}


}