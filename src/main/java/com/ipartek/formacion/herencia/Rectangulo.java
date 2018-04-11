package com.ipartek.formacion.herencia;

public class Rectangulo extends ObjetoGrafico {

	// Atributos
	private int altura;
	private int anchura;

	// Constructor
	public Rectangulo() {
		super();
		this.altura = 0;
		this.anchura = 0;
	}

	// Getters & Setters
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAnchura() {
		return anchura;
	}

	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}

	@Override
	public String toString() {
		return super.toString() + " Rectangulo [altura=" + altura + ", anchura=" + anchura + "]";
	}

	@Override
	public void mover(int x, int y) {
		System.out.println("Mover un rectangulo");
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
