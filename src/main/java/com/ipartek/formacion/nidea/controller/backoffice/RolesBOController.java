package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.RolDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Rol;

/**
 * Servlet implementation class RolesBOController
 */
@WebServlet(description = "Controlador para el CRUD de Roles", urlPatterns = { "/backoffice/roles" })
public class RolesBOController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final int OP_MOSTRAR_FORM = 1;
	public static final int OP_BUSQUEDA = 2;
	public static final int OP_ELIMINAR = 3;
	public static final int OP_GUARDAR = 4;

	private static final String VIEW_INDEX = "roles/index.jsp";

	// Parámetros comunes
	private String search; // Termino para el filtro de búsqueda
	private int op = -1;
	private String view = "";
	private Alert alert = null;
	private RolDAO rolDAO = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		rolDAO = RolDAO.getInstance();
	}

	@Override
	public void destroy() {
		super.destroy();
		rolDAO = null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
		// request.getRequestDispatcher("roles/index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			ArrayList<Rol> roles = null;
			// alert = null;
			recogerParametros(request);

			switch (op) {
			case OP_MOSTRAR_FORM:
				// mostraFormulario(request);
				break;
			case OP_BUSQUEDA:
				buscar(request, roles);
				break;
			case OP_ELIMINAR:
				// eliminar(request, roles);
				break;
			case OP_GUARDAR:
				// guardar(request, roles);
				break;
			default:
				listar(request, roles);
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = VIEW_INDEX;
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * Recogemos todos los parámetros de la request
	 * 
	 * @param request
	 */
	private void recogerParametros(HttpServletRequest request) {
		if (request.getParameter("op") != null) {
			op = Integer.parseInt(request.getParameter("op"));
		}

		search = (request.getParameter("search") != null) ? request.getParameter("search") : "";
		// System.out.println("Filtro de busqueda: " + search);

		// if (request.getParameter("id") != null) {
		// id = Integer.parseInt(request.getParameter("id"));
		// }
		// if (request.getParameter("nombre") != null) {
		// nombre = request.getParameter("nombre").trim();
		// if (nombre == "") {
		// op = OP_MOSTRAR_FORM;
		// alert = new Alert("Debe insertar un nombre al nuevo material",
		// Alert.TIPO_WARNING);
		// }
		// }
		// if (request.getParameter("precio") != null) {
		// if ("".equals(request.getParameter("precio"))) {
		// op = OP_MOSTRAR_FORM;
		// alert = new Alert("Debe rellenar el campo de precio", Alert.TIPO_WARNING);
		// } else {
		// // precio = Float.parseFloat(request.getParameter("precio"));
		// if (precio < 0) {
		// op = OP_MOSTRAR_FORM;
		// alert = new Alert("El precio no puede tener un valor negativo",
		// Alert.TIPO_WARNING);
		// }
		// }
		// }
	}

	private void buscar(HttpServletRequest request, ArrayList<Rol> roles) {

		if (search != "") {
			roles = rolDAO.filterRoles(search);
		} else {
			// devolver la lista completa de roles 'getAll()'
			roles = rolDAO.getAll();
		}
		request.setAttribute("roles", roles);
		view = VIEW_INDEX;

	}

	private void listar(HttpServletRequest request, ArrayList<Rol> roles) {

		roles = rolDAO.getAll();
		request.setAttribute("roles", roles);
		view = VIEW_INDEX;

	}

}
