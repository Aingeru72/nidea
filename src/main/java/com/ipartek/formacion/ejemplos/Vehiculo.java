package com.ipartek.formacion.ejemplos;

public abstract class Vehiculo {

	// Atributos
	private int puertas;
	private String color;

	// Constructor
	public Vehiculo() {
		super();
		this.puertas = 3;
		this.color = "blanco";
		System.out.println("Constructor Vehiculo()");
	}

	// Getters & Setters
	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehiculo [puertas = " + puertas + ", color = " + color + "]";
	}

	// Otros métodos
	public void arrancar() {
		System.out.println("Girar llave en el contacto");
	}

	public abstract void encenderLuces();

	static void getMatricula() {
		// Método dummy para probar el ámbito 'protected'
	}

}
