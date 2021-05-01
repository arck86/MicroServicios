package com.arck.model;

public class Persona {

	private String nombre;
	private String apellidos;
	private String telefono;
	private int year;
	
	public Persona() {
	}

	public Persona(String nombre, String apellidos, String telefono, int year) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.year = year;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
