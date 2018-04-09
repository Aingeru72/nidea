package com.ipartek.formacion.nidea.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public interface Persistible<P> {

	/**
	 * Lista de una tabla de la BD ordenada por ID descendente y límitado a 500
	 * registros
	 * 
	 * @return Colección
	 */
	public ArrayList<P> getAll();

	/**
	 * Obtenemos el detalle de un registro
	 * 
	 * @param id
	 * @return SI EXISTE: Registros con id OTHERWISE null
	 */
	public P getById(int id);

	/**
	 * Guardamos un registro de la BD <br>
	 * IF Pojo.id == -1 : Creamos <br>
	 * IF Pojo.id != -1 : Modificamos
	 * 
	 * @param pojo
	 *            Objeto a guardar o modificar
	 * @return TRUE si lo ha guardado/modificado correctamente ELSE FALSE
	 * @throws MySQLIntegrityConstraintViolationException
	 * @throws MysqlDataTruncation
	 */
	public boolean save(P pojo) throws MySQLIntegrityConstraintViolationException, MysqlDataTruncation;

	/**
	 * Eliminamos un registro por su ID
	 * 
	 * @param id
	 *            identificado del registro a eliminar
	 * @return TRUE si lo ha eliminado correctamente ELSE FALSE
	 */
	public boolean delete(int id);

	/**
	 * Nos mapea de un resultado de la BD a un Pojo
	 * 
	 * @param rs
	 *            : ResultSet con 1 registro de la consulta
	 * @return : SI EXISTE --> Pojo con el resultado del ResultSet OTHERWISE -->
	 *         null
	 * @throws SQLException
	 */
	public P mapper(ResultSet rs) throws SQLException;

}
