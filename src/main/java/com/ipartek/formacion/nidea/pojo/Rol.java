package com.ipartek.formacion.nidea.pojo;

public class Rol {

	// Atributos
	private int id;
	private String nombre;

	// Constructor
	public Rol() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	// Getters & Setters
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

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + "]";
	}

}
