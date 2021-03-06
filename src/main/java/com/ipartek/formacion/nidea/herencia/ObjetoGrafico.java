package com.ipartek.formacion.nidea.herencia;

public abstract class ObjetoGrafico implements Imprimible {

	// Atributos
	private int x;
	private int y;

	// Constrctor
	public ObjetoGrafico() {
		super();
		this.x = 0;
		this.y = 0;
	}

	// Getters & Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "ObjetoGrafico [x=" + x + ", y=" + y + "]";
	}

	// Otros métodos
	public void mover(int x, int y) {
		this.x = x;
		this.y = y;
	}

	abstract void dibujar();

}
