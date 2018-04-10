package com.ipartek.formacion.ejemplos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilidadesTest {

	@Test
	public void testLimipiarEspacios() {
		String cadenaConEspacios = "   ¿ Hola    que    tal ?   ";
		assertEquals("¿ Hola que tal ?", Utilidades.limipiarEspacios(cadenaConEspacios));
		assertEquals("", Utilidades.limipiarEspacios(null));
	}

}
