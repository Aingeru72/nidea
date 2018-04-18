package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ipartek.formacion.nidea.model.UsuarioDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final int SESSION_EXPIRATION = 60 * 60; // 60 minutos

	private UsuarioDAO userDao = UsuarioDAO.getInstance();
	private String view = "";
	private Alert alert = new Alert();
	ServletContext ctxServlet = null;
	// HashMap<Integer, String> usuarios_activos;

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

		Usuario usuario = new Usuario();

		try {

			String username = request.getParameter("usuario");
			String password = request.getParameter("password");

			usuario = userDao.getUser(username, password);
			request.getSession().setAttribute("uLogeado", usuario);
			ctxServlet = request.getServletContext();

			if (usuario != null) {
				if (usuario.getRol().getId() == 1) {
					// Login administrador
					loginAdmin(request, ctxServlet, usuario.getNombre());
				} else if (usuario.getRol().getId() == 2) {
					// Login usuario normal
					loginUser(request, ctxServlet, usuario.getNombre());
				}
			} else {
				view = "login.jsp";
				alert = new Alert("El usuario no existe o alguno de los datos es incorrecto", Alert.TIPO_WARNING);
			}

			// guardar usuario en sesión
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			session.setMaxInactiveInterval(SESSION_EXPIRATION);
			/*
			 * Tiempo de expiración de la sesión, también se puede configurar en web.xml. Un
			 * valor negativo, indica que nunca expira. Configurandolo en web.xml, es global
			 * para todos los Controller
			 * 
			 * <session-config> <session-timeout>-1</session-timeout> <session-config>
			 */

		} catch (Exception e) {
			e.printStackTrace();
			view = "login.jsp";
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

	private void loginAdmin(HttpServletRequest request, ServletContext ctxServlet, String usuario) {

		// Cargar usuarios_activos
		// usuarios_activos = (HashMap<Integer, String>)
		// ctxServlet.getAttribute("usuarios_activos");
		// if (usuarios_activos != null) {
		// // Guardar usuarios_activos en la request
		// request.setAttribute("usuarios_activos", usuarios_activos);
		// }

		view = "backoffice/index.jsp";
		alert = null /* new Alert("Ongi Etorri", Alert.TIPO_PRIMARY) */;

	}

	private void loginUser(HttpServletRequest request, ServletContext ctxServlet, String usuario) {

		// usuarios_activos = (HashMap<Integer, String>)
		// ctxServlet.getAttribute("usuarios_activos");
		// if (usuarios_activos == null) {
		// // Inicializar el HashMap de usuarios
		// usuarios_activos = new HashMap<Integer, String>();
		// }
		// new_id++;
		// usuarios_activos.put(new_id, usuario);
		// ctxServlet.setAttribute("usuarios_activos", usuarios_activos);

		view = "materiales.jsp";
		alert = new Alert("Bienvenido " + usuario, Alert.TIPO_PRIMARY);

	}

}
