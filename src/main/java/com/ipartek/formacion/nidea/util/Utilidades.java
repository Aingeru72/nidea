package com.ipartek.formacion.nidea.util;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.nidea.ejemplos.Ordenable;

public class Utilidades {

	/**
	 * Método estático para usarlo sin crear una nueva instancia y poder usarlo
	 * desde otra clase. <br>
	 * 
	 * Limpiar los carácteres vacios de una cadena: Aplicamos un cadena.trim() y
	 * reemplazamos los espacios entre palabras por un único espacio: <br>
	 * " ¿ Hola que tal ? " --> "¿ Hola que tal ?"
	 * 
	 * @param cadena
	 * @return cadena sin espacios en blanco; SI cadena == NULL return "";
	 */
	public static String limipiarEspacios(String cadena) {
		String resultado = "";

		if (cadena != null) {
			resultado = cadena.replaceAll("\\s+", " ");
			resultado = resultado.trim();
		}

		return resultado;
	}

	/**
	 * Ordenar una coleccion con el algorítmo BubbleSort, de menos a mayor usando el
	 * método getValor de la interfaz Ordenable
	 * 
	 * @see: com.ipartek.formacion.nidea.ejemplos.Ordenable
	 * @param coleccion
	 *            List<Ordenable> con los elementos a ordenar
	 * @return ArrayList<Ordenable> ordenada de menos a mayor. <br>
	 *         En caso de NULL devuelve una ArrayList<Ordenable> vacia
	 */
	public static List<Ordenable> bubbleSort(List<Ordenable> coleccion) {
		List<Ordenable> resul = new ArrayList<Ordenable>();

		if (coleccion != null) {
			int n = coleccion.size();
			Ordenable temp = null;
			for (int i = 0; i < n; i++) {
				for (int j = 1; j < (n - i); j++) {
					if (coleccion.get(j - 1).getValor() > coleccion.get(j).getValor()) {
						// swap elements
						temp = coleccion.get(j - 1);
						coleccion.set(j - 1, coleccion.get(j));
						coleccion.set(j, temp);
					}
				}
			}
			resul = coleccion;
		}

		return resul;
	}

}
