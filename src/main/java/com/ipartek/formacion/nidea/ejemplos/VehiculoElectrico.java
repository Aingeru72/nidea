package com.ipartek.formacion.nidea.ejemplos;

public class VehiculoElectrico extends Vehiculo implements Ordenable {

	// Atributos
	private float potencia; // en KW

	// Constructor
	public VehiculoElectrico() {
		super();
		potencia = 0;
		System.out.println("Constructor VehiculoElectrico()");
	}

	public VehiculoElectrico(float potencia) {
		this(); // Cambiar .super() => .this()
		this.potencia = potencia;
	}

	// Getters & Setters
	public float getPotencia() {
		return potencia;
	}

	public void setPotencia(float potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return super.toString() + " VehiculoElectrico [potencia = " + potencia + " kw]";
	}

	@Override
	public void arrancar() {
		// super.arrancar();
		System.out.println("Pulsar botón del contacto");
	}

	@Override
	public void encenderLuces() {
		System.out.println("Luces ON");
	}

	@Override
	public int getValor() {
		return this.getPuertas();
	}

}
