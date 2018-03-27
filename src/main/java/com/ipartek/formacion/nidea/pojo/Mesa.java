// 1. Definici�n del paquete
package com.ipartek.formacion.nidea.pojo;

// 2. Import de librer�as

// 3. Definici�n de la Clase
public class Mesa {

	// Constantes
	final static int PRECIO_PATA = 1;
	final static int PRECIO_M2 = 5;
	final static String PRECIO_COLOR_NAME_CUSTOM = "custom";
	public static final int PRECIO_COLOR_CUSTOM = 23;

	// 4. Definici�n de atributos
	private int numPatas;
	private int dimension; // m2
	private String color;
	private boolean customColor; // color customizado
	private Material material;

	/*
	 * 5. Definici�n de M�todos 5.1 Constructor(es) 5.2 Getters & Setters 5.3 Otros
	 * m�todos
	 */

	// 5.1 Constructores
	public Mesa() {
		super();
		this.numPatas = 4;
		this.dimension = 1;
		this.color = "blanco";
		this.material = new Material();
	}

	/**
	 * Crear nueva instancia del tipo Mesa
	 * 
	 * @param numPatas
	 *            entero con el n�mero de patas, SI es negativo se inicializa a 0
	 * @author Aingeru Sanchez
	 * @throws MesaException
	 */
	public Mesa(int numPatas, int dimension, String color, Material material) throws MesaException {
		super();
		// this.numPatas = numPatas;
		this.setNumPatas(numPatas);
		this.setDimension(dimension);
		this.setColor(color);
		this.setMaterial(material);
	}

	// 5.2 Getters & Setters
	public int getNumPatas() {
		return numPatas;
	}

	/**
	 * Asignar el número de patas de la mesa; IF numPatas < 0 => 1 else numPatas
	 * 
	 * @param numPatas:
	 *            entero que muestra el n�mero de patas
	 * @throws MesaException:
	 *             lanza la excepción si numPatas <= 0
	 */
	public void setNumPatas(int numPatas) throws MesaException {
		// this.numPatas = (numPatas <= 0) ? 1 : numPatas;
		if (numPatas <= 0) {
			throw new MesaException(MesaException.MENSAJE_PATAS);
		}
		this.numPatas = numPatas;
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public boolean isCustomColor() {
		return customColor;
	}

	public void setCustomColor(boolean customColor) {
		this.customColor = customColor;
	}

	@Override
	public String toString() {
		return "Mesa [numPatas=" + numPatas + ", dimension=" + dimension + ", color=" + color + ", materrial="
				+ material + "]";
	}

	// 5.3 Otros m�todos

	/**
	 * Calculamos el precio de la mesa en funcion de los materiales usados
	 * 
	 * @param mesa:
	 *            Objeto con atributos de materiales asignados
	 * @return: entero con el precio de la mesa
	 */
	public int getPrecio() {
		int precio = 0;

		// Calculamos el precio por pata
		precio += this.getNumPatas() * PRECIO_PATA;
		// Calculamos el precio por m2
		precio += this.getDimension() * PRECIO_M2;
		// Calculamos precio por color
		if (this.isCustomColor()) {
			precio += PRECIO_COLOR_CUSTOM;
		}
		// Calculamos precio por material
		// switch (this.getMaterial()) {
		// case 1: // Pl�stico
		// precio += PRECIO_MATERIAL_PLASTICO;
		// break;
		// case 2: // Madera
		// precio += PRECIO_MATERIAL_MADERA;
		// break;
		// case 3: // Aluminio
		// precio += PRECIO_MATERIAL_ALUMINIO;
		// break;
		// case 4: // Acero
		// precio += PRECIO_MATERIAL_ACERO;
		// break;
		// default: // Optional
		// break;
		// }
		// CHANGES: ahora el Material es un POJO
		precio += this.getMaterial().getPrecio();

		return precio;
	}
}
