package com.ipartek.formacion.nidea.pojo;

public class Usuario {

	// Atributos
	private int id;
	private String nombre;

	// Constructor
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
	}

	public Usuario(int id, String nombre) {
		this();
		this.id = id;
		this.nombre = nombre;
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
		return "Usuario [id=" + id + ", nombre=" + nombre + "]";
	}

	// Otros métodos

}
