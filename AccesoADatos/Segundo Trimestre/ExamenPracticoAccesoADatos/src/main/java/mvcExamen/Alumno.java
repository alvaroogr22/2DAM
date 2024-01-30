package mvcExamen;

import java.sql.Date;

public class Alumno {
	
	public enum es_repetidor{
    	SI, NO
    }
	
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fecha_nacimiento;
    private String es_repetidor;
    private String telefono;
    
    
	public Alumno(int id, String nombre, String apellido1, String apellido2, Date fecha_nacimiento, String es_repetidor, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fecha_nacimiento = fecha_nacimiento;
		this.es_repetidor = es_repetidor;
		this.telefono = telefono;
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


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}


	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}


	public String getEs_repetidor() {
		return es_repetidor;
	}


	public void setEs_repetidor(String es_repetidor) {
		this.es_repetidor = es_repetidor;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
    
    

   
}
