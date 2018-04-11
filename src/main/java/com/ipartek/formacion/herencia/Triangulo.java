package com.ipartek.formacion.herencia;

public class Triangulo extends ObjetoGrafico {

	// Atributos
	private String tipo; // Equilatero, Isosceles, Escaleno

	public Triangulo() {
		super();
		this.setTipo("equilatero");
	}

	// Getters & Setters
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return super.toString() + " Triangulo [tipo=" + tipo + "]";
	}

	@Override
	public void mover(int x, int y) {
		System.out.println("Mover un triangulo");
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
