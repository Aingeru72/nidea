package com.ipartek.formacion.nidea.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ipartek.formacion.nidea.util.Utilidades;

public class UtilidadesTest {

	@Test
	public void testLimipiarEspacios() {
		String cadenaConEspacios = "   ¿ Hola    que    tal ?   ";
		assertEquals("¿ Hola que tal ?", Utilidades.limipiarEspacios(cadenaConEspacios));
		assertEquals("", Utilidades.limipiarEspacios(null));
	}

}
