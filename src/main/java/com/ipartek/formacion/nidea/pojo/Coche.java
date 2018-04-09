package com.ipartek.formacion.nidea.pojo;

public class Coche implements AutoCloseable {

	// Constructor
	public Coche() {
		super();
		System.out.println("Coche creado");
	}

	public void conducir() {
		System.out.println("Arrancar motor!");
	}

	@Override
	public void close() throws Exception {

		System.out.println("Aparcao! <-- método close()");

	}

	public static void main(String[] args) {

		// Si implementamos un objeto que implementa la interfaz 'AutoClosable'
		// como parámetro del TRY, cuando llega al FINALLY
		// se ejecuta de forma automática el método close()

		try (Coche c = new Coche()) {
			System.out.println("Comenzando ejecución");
		} catch (Exception e) {
			System.out.println("Ha surgido un problema");
			e.printStackTrace();
		} // La sentencia finally no hace falta para cerrar el recurso, se ejecuta solo
		/*
		 * finally { System.out.
		 * println("Fin de la ejecución, el método close() se ejecuta automáticamente");
		 * }
		 */

	}

}
