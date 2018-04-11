package com.ipartek.formacion.herencia;

public class Circulo extends ObjetoGrafico {

	// Atributos
	private int radio;

	public Circulo() {
		super();
		this.radio = 0;
	}

	// Getters & Setters
	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return super.toString() + " Circulo [radio=" + radio + "]";
	}

	// Otros métodos
	@Override
	public void mover(int x, int y) {
		System.out.println("Mover un circulo");
	}

	@Override
	public void imprimir() {
		this.toString();
	}

	@Override
	void dibujar() {
		// TODO Auto-generated method stub

	}

}
