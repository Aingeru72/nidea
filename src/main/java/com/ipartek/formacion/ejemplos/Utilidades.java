package com.ipartek.formacion.ejemplos;

public class Utilidades {

	/**
	 * Método estático para usarlo sin crear una nueva instancia y poder usarlo
	 * desde otra clase. <br>
	 * 
	 * Limpiar los carácteres vacios de una cadena: Aplicamos un cadena.trim() y
	 * reemplazamos los espacios entre palabras por un único espacio: <br>
	 * " ¿ Hola que tal ? " --> "¿Hola que tal?"
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

}
