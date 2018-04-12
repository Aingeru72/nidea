package com.ipartek.formacion.nidea.ejemplos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.ipartek.formacion.nidea.herencia.CirculoColoreado;

public class EjercicioOrdenable {

	public static void main(String[] args) {

		// Atributos
		ArrayList<Ordenable> lista = new ArrayList<Ordenable>();

		// Las clases Vehiculo y Circulo implementan la interfaz Ordenable
		// y por lo tanto, su método .getValor()

		VehiculoElectrico e1 = new VehiculoElectrico();

		VehiculoElectrico e2 = new VehiculoElectrico();
		e2.setPuertas(0);

		CirculoColoreado e3 = new CirculoColoreado();
		e3.setRadio(1);

		CirculoColoreado e4 = new CirculoColoreado();
		e4.setRadio(9);

		// Rellenar lista
		lista.add(e1);
		lista.add(e2);
		lista.add(e3);
		lista.add(e4);

		// System.out.println("-----LISTA SIN ORDENAR-----");
		// imprimirLista(lista);
		//
		// ArrayList<Ordenable> listaOrdenada = (ArrayList<Ordenable>)
		// Utilidades.bubbleSort(lista);
		//
		// System.out.println("-----LISTA ORDENADA CON BUBBLESORT-----");
		// imprimirLista(listaOrdenada);

		System.out.println("-----LISTA SIN ORDENAR-----");
		Collections.sort(lista, new ComparatorOrdenables());

		System.out.println("-----LISTA ORDENADA CON COLEECTIONS.SORT-----");
		imprimirLista(lista);

	}

	private static void imprimirLista(ArrayList<Ordenable> lista) {

		Iterator<Ordenable> it = lista.iterator();
		while (it.hasNext()) {
			// System.out.println(it.next());
			System.out.println("Valor para ordenar: " + it.next().getValor());
		}

	}

}
