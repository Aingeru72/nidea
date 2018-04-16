package com.ipartek.formacion.nidea.pojo;

public class Usuario {

	// Atributos
	private int id;
	private String nombre;
	private String pass;
	private int rol;

	// Constructor
	public Usuario() {
		super();
		this.id = -1;
		this.nombre = "";
		this.pass = "";
		this.rol = 0;
	}

	// public Usuario(String nombre, String pass) {
	// this();
	// this.nombre = nombre;
	// this.pass = pass;
	// }

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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", pass=" + pass + ", rol=" + rol + "]";
	}

}
