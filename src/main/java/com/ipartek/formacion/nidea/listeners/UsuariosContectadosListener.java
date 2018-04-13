package com.ipartek.formacion.nidea.listeners;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.ipartek.formacion.nidea.pojo.Usuario;

/**
 * Application Lifecycle Listener implementation class
 * UsuariosContectadosListener
 *
 */
@WebListener
public class UsuariosContectadosListener implements HttpSessionListener, HttpSessionAttributeListener {

	HashMap<Integer, Usuario> usuarios_activos;

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("Sesion creada");
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Sesion cerrada");
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("Atributo creada");

		ServletContext ctxServlet;
		Usuario user = (Usuario) event.getSession().getAttribute("uLogeado");
		System.out.println(user.toString());

		if ("uLogeado".equals(event.getName())) {
			ctxServlet = event.getSession().getServletContext();
			if (ctxServlet.getAttribute("usuarios_activos") == null) {
				usuarios_activos = new HashMap<Integer, Usuario>();
			} else {
				usuarios_activos = (HashMap<Integer, Usuario>) ctxServlet.getAttribute("usuarios_activos");
			}
			usuarios_activos.put(user.getId(), user);
			ctxServlet.setAttribute("usuarios_activos", usuarios_activos);
		}

	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("Atributo eliminado");
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("Atributo reemplazado");
	}

}
