package com.ipartek.formacion.nidea.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class BackofficeFilter
 */
@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE,
		DispatcherType.ERROR }, description = "FIltro para entrar en backoffice post-login", urlPatterns = {
				"/backoffice/*" })
public class BackofficeFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("BackofficeFilter.destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		if (session.getAttribute("usuario") != null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			informacionPeticion(req);
			// En caso de no haber iniciado sesión previamente --> Redirección a login
			res.sendRedirect(req.getContextPath() + "/login");
		}

	}

	/**
	 * Mostramos por pantalla información del usuario que ha hecho la petición
	 * 
	 * @param req
	 *            : HttpServletRequest
	 */
	private void informacionPeticion(HttpServletRequest req) {

		System.out.println("****************** ACCESO NO PERMITIDO ****************************");
		System.out.println("IP: " + req.getLocalAddr());
		System.out.println("PORT: " + req.getRemotePort());
		System.out.println("URI: " + req.getRequestURI());
		System.out.println("URL: " + req.getRequestURL());
		System.out.println("Idioma: " + req.getLocale());
		System.out.println("*********************** Encabezados *******************************");
		System.out.println("Navegador: " + req.getHeader("user-agent"));
		System.out.println("Host: " + req.getHeader("host"));
		System.out.println("*******************************************************************");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("BackofficeFilter.init()");
	}

}
