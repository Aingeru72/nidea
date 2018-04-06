package com.ipartek.formacion.nidea.pojo;

public class Bebida {

	private int id;
	private String nombre;
	private float precio;
	private float graduacion;

	// Constructor de Bebida
	public Bebida(int id, String nombre, float precio, float graduacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.graduacion = graduacion;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getGraduacion() {
		return graduacion;
	}

	public void setGraduacion(float graduacion) {
		this.graduacion = graduacion;
	}

	@Override
	public String toString() {
		return "Bebida [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", graduacion=" + graduacion + "]";
	}

}
