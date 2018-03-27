package com.ipartek.formacion.nidea.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String USER = "admin";
	private static final String PASS = "admin";

	private String view = "";
	private Alert alert;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");

			if (USER.equalsIgnoreCase(user) && PASS.equals(pass)) {
				view = "views/backoffice/index.jsp";
				alert = new Alert("Ongi Etorri!", Alert.TIPO_INFO);
			} else {
				view = "views/login.jsp";
				alert = new Alert("Usuario o contraseña incorrectas", Alert.TIPO_DANGER);
			}
		} catch (Exception e) {
			e.printStackTrace();
			view = "login.jsp";
			alert = new Alert();
		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

}
