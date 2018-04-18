package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Usuario;
import com.ipartek.formacion.nidea.util.Utilidades;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class UsuarioDAO implements Persistible<Usuario> {

	private static UsuarioDAO INSTANCE = null;

	// Private constructor para que no se pueda hacer new UsuariolDAO() y crear más
	// de una instancia
	private UsuarioDAO() {
	}

	// creador synchronized para protegerse de posible problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
	}

	public static UsuarioDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	/**
	 * Recupera todos los usuarios de la BD
	 * 
	 * @return ArrayList<Usuario> si no existen registros new ArrayList<Usuario>()
	 */
	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT id,nombre,password FROM usuario LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			Usuario u = null;
			while (rs.next()) {
				u = mapper(rs);
				lista.add(u);
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
	 * @return lista con los Usuarios que cumplen la condición del filtro
	 */
	public ArrayList<Usuario> filterUsuarios(String searchText) {

		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		String sql = "SELECT id,nombre FROM usuario WHERE nombre LIKE ? LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			pst.setString(1, "%" + searchText + "%");

			Usuario u = null;
			while (rs.next()) {
				u = mapper(rs);
				lista.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lista;

	}

	@Override
	public Usuario getById(int id) {
		Usuario usuario = null;
		String sql = "SELECT `id`, `nombre`, `password` FROM `usuario` WHERE `id` = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, id);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					usuario = mapper(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

	@Override
	public boolean delete(int id) {
		boolean resul = false;
		String sqlDELETE = "DELETE FROM `usuario` WHERE  `id`= ?;";

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
	public boolean save(Usuario usuario) throws MySQLIntegrityConstraintViolationException, MysqlDataTruncation {

		boolean resul = false;
		String sql = "";

		// Sanear ("saniti") el nombre del usuario
		usuario.setNombre(Utilidades.limipiarEspacios(usuario.getNombre()));
		usuario.setPass(Utilidades.limipiarEspacios(usuario.getPass()));

		if (usuario.getId() == -1) {
			sql = "INSERT INTO `nidea_ejercicio`.`usuario` (`nombre`, `password`) VALUES (?, ?);";
		} else {
			sql = "UPDATE `nidea_ejercicio`.`usuario` SET `nombre`=?, `password`=? WHERE  `id`=?;";
		}

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {

			if (usuario.getId() == -1) {
				// Creamos un nuevo material
				pst.setString(1, usuario.getNombre());
				pst.setString(2, usuario.getPass());
			} else {
				// Modificamos un material existente
				pst.setString(1, usuario.getNombre());
				pst.setString(2, usuario.getPass());
				pst.setInt(3, usuario.getId());
			}

			int affetedRows = pst.executeUpdate();

			if (affetedRows == 1) {
				try (ResultSet rs = pst.getGeneratedKeys()) {
					while (rs.next()) {
						usuario.setId(rs.getInt(1));
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
	public Usuario mapper(ResultSet rs) throws SQLException {
		Usuario u = null;

		if (rs != null) {
			u = new Usuario();
			u.setNombre(rs.getString("nombre"));
			u.setId(rs.getInt("id"));
			u.setPass(rs.getString("password"));
			u.getRol().setId(rs.getInt("id_rol"));
		}

		return u;
	}

	/**
	 * Buscamos un usuario en la BD a partir del nombre y la constraseña
	 * 
	 * @param username
	 *            : nombre del usuario
	 * @param password
	 *            : contraseña del usuario
	 * @return : Usuario obtenido de la BD; Si no existe, devuelve null.
	 */
	public Usuario getUser(String username, String password) {
		Usuario usuario = null;

		String sql = "SELECT id, nombre, password, id_rol FROM usuario WHERE nombre = ? AND password = ?;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, username);
			pst.setString(2, password);
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					usuario = mapper(rs);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usuario;
	}

}
