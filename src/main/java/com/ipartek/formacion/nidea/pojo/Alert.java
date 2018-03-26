package com.ipartek.formacion.nidea.pojo;

public class Alert {

	// Atributos
	private String mensaje;
	private String tipo;

	// Tipos de alerta
	public static final String TIPO_SUCCES = "success"; // verde
	public static final String TIPO_INFO = "info"; // azul
	public static final String TIPO_WARNING = "warning"; // amarillo
	public static final String TIPO_DANGER = "danger"; // rojo

	// Constructores
	public Alert() {
		super();

		this.mensaje = "Ups! Ha ocurrido un error inesperado :S";
		this.tipo = TIPO_DANGER;
	}

	/**
	 * Consutructor de Alertas con mensaje definido
	 * 
	 * @param mensaje:
	 *            String con el mensaje de alerta
	 */
	public Alert(String mensaje) {
		this();
		this.mensaje = mensaje;
	}

	/**
	 * Consutructor de Alertas con mensaje y tipo definidos
	 * 
	 * @param mensaje:
	 *            String con el mensaje de alerta
	 * @param tipo:
	 *            tipo de alerta
	 */
	public Alert(String mensaje, String tipo) {
		this();
		this.mensaje = mensaje;
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Alert [mensaje=" + mensaje + ", tipo=" + tipo + "]";
	}

}
