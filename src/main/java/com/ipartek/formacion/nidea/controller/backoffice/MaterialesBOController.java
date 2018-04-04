package com.ipartek.formacion.nidea.controller.backoffice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;

/**
 * Servlet implementation class MaterialesController
 */
@WebServlet(description = "Controller para mostrar los materiales en backoffice", urlPatterns = {
		"/backoffice/materiales" })
public class MaterialesBOController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int SESSION_EXPIRATION = 60 * 30; // 30 minutos

	private String view = "";
	private Alert alert = new Alert();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(SESSION_EXPIRATION);

			String search = request.getParameter("search");
			System.out.println("Filtro de busqueda: " + search);
			// Obtener instancia del DAO de materiales
			MaterialDAO dao = MaterialDAO.getInstance();
			ArrayList<Material> materiales;
			if (search != null) {
				materiales = dao.filterMateriales(search);
			} else {
				// devolver la lista completa de materiales 'getAll()'
				materiales = dao.getAll();
			}
			request.setAttribute("materiales", materiales);
			view = "materiales/index.jsp";
			alert = new Alert("Lista de Materiales para Admin", Alert.TIPO_PRIMARY);

		} catch (Exception e) {
			e.printStackTrace();
			view = "login";
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
