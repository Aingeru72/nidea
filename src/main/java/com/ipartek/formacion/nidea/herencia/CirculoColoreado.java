package com.ipartek.formacion.nidea.herencia;

public final class CirculoColoreado extends Circulo {

	// Al ser una clase FINAL no puede tener subclases

	// Atributos
	private String color;

	public CirculoColoreado() {
		super();
		this.setColor("blanco");
	}

	// Getters & Setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return super.toString() + " CirculoColoreado [color=" + color + "]";
	}

	// Otros métodos
	@Override
	public void mover(int x, int y) {
		System.out.println("Mover un circulo coloreado");
	}

}
