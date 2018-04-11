package com.ipartek.formacion.nidea.ejemplos;

public class EjercicioVehiculos {

	public static void main(String[] args) {

		/**
		 * No se pueden crear objetos de una clase abstracta
		 *
		 * Vehiculo v1 = new Vehiculo(); 
		 * System.out.println(v1.toString());
		 * v1.arrancar();
		 */

		System.out.println("------------------------------------");

		VehiculoElectrico tesla = new VehiculoElectrico();
		System.out.println(tesla.toString());
		tesla.arrancar();

	}

}
