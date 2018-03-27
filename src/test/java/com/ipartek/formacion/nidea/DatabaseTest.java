package com.ipartek.formacion.nidea;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void testDriver() {
		try {
			// Cargar Drivers especificos de la BBDD que usamos
			Class.forName("com.mysql.jdbc.Driver");
			assertTrue(true);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			fail("No existe Driver para MySQL, ¿Cargar .JAR?");
		}
	}

	@Test
	public void TestConnection() {
		final String URL = "jdbc:mysql://192.168.0.42:3306/spoty?user=alumno&password=alumno";
		try {
			// Importar java.sql.Connection para que no sea dependiente de la BBDD
			Connection con = DriverManager.getConnection(URL);
			assertTrue(true);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("No se pudo establecer la conexión con: " + URL);
		}

	}

}
