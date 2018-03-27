package com.ipartek.formacion.nidea.pojo;

public class Material {

	public static final String[] NOMBRES = { "madera", "acero", "aluminio", "plastico" };
	public static final int[] PRECIOS = { 4, 6, 5, 2 };
	public static final int[] IDS = { 1, 2, 3, 4 };

	// Atributos
	private String nombre;
	private float precio;
	private int id;

	// Constructor
	public Material() {
		super();
		this.id = IDS[0];
		this.nombre = NOMBRES[0];
		this.precio = PRECIOS[0];
	}

	public Material(String nombre, int precio, int id) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.id = id;
	}

	// Getters & Setters
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Material [nombre=" + nombre + ", precio=" + precio + ", id=" + id + "]";
	}

	// Otros métodos

}
