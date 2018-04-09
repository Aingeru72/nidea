package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Material;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class MaterialDAO implements Persistible<Material> {

	private static MaterialDAO INSTANCE = null;

	// Private constructor para que no se pueda hacer new MaterialDAO() y crear más
	// de una instancia
	private MaterialDAO() {
	}

	// creador synchronized para protegerse de posible problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new MaterialDAO();
		}
	}

	public static MaterialDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	/**
	 * Recupera todos los materiales de la BBDD ordenados por id descendente
	 * 
	 * @return ArrayList<Material> si no existen registros new ArrayList<Material>()
	 */
	public ArrayList<Material> getAll() {

		ArrayList<Material> lista = new ArrayList<Material>();
		String sql = "SELECT id,nombre,precio FROM material ORDER BY id DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			// Class.forName("com.mysql.jdbc.Driver");
			// final String URL =
			// "jdbc:mysql://192.168.0.42/spoty?user=alumno&password=alumno";
			// con = DriverManager.getConnection(URL);

			Material m = null;
			while (rs.next()) {
				m = mapper(rs);
				lista.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;
	}

	/**
	 * Devuelve una lista filtrada por el termino de búsqueda "searchText"
	 * 
	 * @param searchText
	 *            String que condiciona el filtro
	 * @return lista con los Materiales que cumplen la condición del filtro
	 */
	public ArrayList<Material> filterMateriales(String searchText) {

		ArrayList<Material> lista = new ArrayList<Material>();
		String sql = "SELECT id,nombre,precio FROM material WHERE nombre LIKE '%" + searchText
				+ "%' ORDER BY id DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			// Class.forName("com.mysql.jdbc.Driver");
			// final String URL =
			// "jdbc:mysql://192.168.0.42/spoty?user=alumno&password=alumno";
			// con = DriverManager.getConnection(URL);

			Material m = null;
			while (rs.next()) {
				m = mapper(rs);
				lista.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	@Override
	public Material getById(int id) {
		Material material = null;
		String sql = "SELECT `id`, `nombre`, `precio` FROM `material` WHERE `id` = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					material = mapper(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return material;
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		String sqlDELETE = "DELETE FROM `material` WHERE  `id`= ?;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sqlDELETE);) {

			pst.setInt(1, id);

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;
	}

	@Override
	public boolean save(Material material) throws MySQLIntegrityConstraintViolationException, MysqlDataTruncation {

		boolean resul = false;
		String sql = "";

		if (material.getId() == -1) {
			sql = "INSERT INTO `nidea`.`material` (`nombre`, `precio`) VALUES (?, ?);";
		} else {
			sql = "UPDATE `nidea`.`material` SET `nombre`=?, `precio`=? WHERE  `id`=?;";
		}

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			if (material.getId() == -1) {
				// Creamos un nuevo material
				pst.setString(1, material.getNombre());
				pst.setFloat(2, material.getPrecio());
			} else {
				// Modificamos un material existente
				pst.setString(1, material.getNombre());
				pst.setFloat(2, material.getPrecio());
				pst.setFloat(3, material.getId());
			}

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				try (ResultSet rs = pst.getGeneratedKeys()) {
					while (rs.next()) {
						material.setId(rs.getInt(1));
						resul = true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (MySQLIntegrityConstraintViolationException mysql_exc) {
			// mysql_exc.printStackTrace();
			System.out.println("MySQLIntegrityConstraintViolationException por columna repetida");
			throw mysql_exc;
		} catch (MysqlDataTruncation mysql_data_trunc) {
			// mysql_data_trunc.printStackTrace();
			System.out.println("MysqlDataTruncation tamaño sobrepasado en columna");
			throw mysql_data_trunc;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;
	}

	@Override
	public Material mapper(ResultSet rs) throws SQLException {
		Material m = null;

		if (rs != null) {
			m = new Material();
			m.setNombre(rs.getString("nombre"));
			m.setId(rs.getInt("id"));
			m.setPrecio(rs.getFloat("precio"));
		}

		return m;
	}

}
