package com.ipartek.formacion.nidea.ejemplos;

import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Mesa;
import com.ipartek.formacion.nidea.pojo.MesaException;

public class EjercicioOrdenable {

	public static void main(String[] args) {

		// Atributos
		ArrayList<Ordenable> lista = new ArrayList<Ordenable>();

		// Las clases Vehiculo y Mesa implementan la interfaz Ordenable
		// y por lo tanto, su método .getValor()

		Mesa mesaDefault = new Mesa();
		Mesa mesaRectangular = new Mesa();
		try {
			mesaRectangular.setNumeroPatas(4);
		} catch (MesaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		VehiculoElectrico vehiculo = new VehiculoElectrico();

		lista.add(new Mesa());

	}

}
