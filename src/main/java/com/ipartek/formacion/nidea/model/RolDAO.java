package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Rol;
import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class RolDAO implements Persistible<Rol> {

	private static RolDAO INSTANCE = null;

	// Private constructor para que no se pueda hacer new RolDAO() y crear más
	// de una instancia
	private RolDAO() {
	}

	// creador synchronized para protegerse de posible problemas multi-hilo
	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RolDAO();
		}
	}

	public static RolDAO getInstance() {
		if (INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}

	@Override
	public ArrayList<Rol> getAll() {

		ArrayList<Rol> listaRoles = null;
		String sql = "SELECT id,nombre FROM rol LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();) {

			Rol r = null;
			listaRoles = new ArrayList<Rol>();
			while (rs.next()) {
				r = mapper(rs);
				listaRoles.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listaRoles;
	}

	@Override
	public Rol getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(Rol pojo) throws MySQLIntegrityConstraintViolationException, MysqlDataTruncation {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rol mapper(ResultSet rs) throws SQLException {

		Rol r = null;

		if (rs != null) {
			r = new Rol();
			r.setNombre(rs.getString("nombre"));
			r.setId(rs.getInt("id"));
		}

		return r;
	}

	public ArrayList<Rol> filterRoles(String searchText) {

		ArrayList<Rol> lista = null;
		String sql = "SELECT id, nombre FROM rol WHERE nombre LIKE ? ORDER BY id DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, "%" + searchText + "%");
			try {
				ResultSet rs = pst.executeQuery();
				Rol r = null;
				lista = new ArrayList<Rol>();
				while (rs.next()) {
					r = mapper(rs);
					lista.add(r);
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
