package com.ipartek.formacion.nidea.pojo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Bebida {

	private int id;

	@NotNull
	@NotBlank
	@Size(min = 3, max = 45)
	private String nombre;

	@DecimalMin("0.01")
	private double precio;

	// Constructor de Bebida
	public Bebida() {
		super();
		this.id = -1;
		this.nombre = "";
		this.precio = 0;
	}

	public Bebida(int id, String nombre, double precio) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double d) {
		this.precio = d;
	}

	@Override
	public String toString() {
		return "Bebida [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
