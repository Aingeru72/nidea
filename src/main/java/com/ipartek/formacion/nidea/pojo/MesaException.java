package com.ipartek.formacion.nidea.pojo;

public class MesaException extends Exception {

	private static final long serialVersionUID = 1L;

	public static final String MENSAJE_PATAS = "La mesa debe tener mínimo 1 pata";

	// Constructor
	public MesaException(String mensaje) {
		super(mensaje);
	}

}
