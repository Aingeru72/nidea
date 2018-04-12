package com.ipartek.formacion.nidea.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int SESSION_EXPIRATION = 60 * 60; // 60 minutos

	private String view = "";
	private Alert alert = new Alert();

	private static final String USER = "admin";
	private static final String PASS = "admin";

	private static int new_id = 0;
	ServletContext ctxServlet = null;
	HashMap<Integer, String> usuarios_activos;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");

			if (USER.equalsIgnoreCase(usuario) && PASS.equals(password)) {
				// Login como ADMIN

				// guardar usuario en sesión
				HttpSession session = request.getSession();
				session.setAttribute("usuario", usuario);

				/*
				 * Tiempo de expiración de la sesión, también se puede configurar en web.xml. Un
				 * valor negativo, indica que nunca expira. Configurandolo en web.xml, es global
				 * para todos los Controller
				 * 
				 * <session-config> <session-timeout>-1</session-timeout> <session-config>
				 */
				session.setMaxInactiveInterval(SESSION_EXPIRATION);

				// Cargar usuarios_activos
				ctxServlet = request.getServletContext();
				usuarios_activos = (HashMap<Integer, String>) ctxServlet.getAttribute("usuarios_activos");
				if (usuarios_activos != null) {
					// Guardar usuarios_activos en la request
					request.setAttribute("usuarios_activos", usuarios_activos);
				}

				view = "backoffice/index.jsp";
				alert = null /* new Alert("Ongi Etorri", Alert.TIPO_PRIMARY) */;
			} else if (usuario != null && password != null) {
				// Usuario normal
				ctxServlet = request.getServletContext();
				usuarios_activos = (HashMap<Integer, String>) ctxServlet.getAttribute("usuarios_activos");
				if (usuarios_activos == null) {
					// Inicializar el HashMap de usuarios
					usuarios_activos = new HashMap<Integer, String>();
				}
				new_id++;
				usuarios_activos.put(new_id, usuario);

				ctxServlet.setAttribute("usuarios_activos", usuarios_activos);

				view = "materiales.jsp";
				alert = new Alert("Bienvenido " + usuario, Alert.TIPO_PRIMARY);
			} else {
				view = "login.jsp";
				alert = new Alert("Credenciales incorrectas, prueba de nuevo", Alert.TIPO_DANGER);
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
