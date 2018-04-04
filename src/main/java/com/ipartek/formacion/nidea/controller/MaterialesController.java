package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class MaterialesController
 */
@WebServlet(description = "Lista de materiales pública que se muestra al usuario", urlPatterns = { "/materiales" })
public class MaterialesController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int SESSION_EXPIRATION = 60 * 1; // 1 minuto

	private String view = "";
	private Alert alert = new Alert();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// enviar como atributo la lista de materiales
			MaterialDAO dao = MaterialDAO.getInstance();
			request.setAttribute("materiales", dao.getAll());

			// guardar usuario en sesión
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(SESSION_EXPIRATION);

			view = "materiales.jsp";
			// alert = new Alert("Ongi Etorri", Alert.TIPO_PRIMARY);

		} catch (Exception e) {
			e.printStackTrace();
			view = "index.jsp";
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
