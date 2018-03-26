package com.ipartek.formacion.nidea.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraController
 */
public class CalculadoraController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;

	// CONSTANTES
	public static final int OP_SUMAR = 0;
	public static final int OP_RESTAR = 1;
	public static final int OP_MULTIPLICAR = 2;
	public static final int OP_DIVIDIR = 3;

	float num1 = 0;
	float num2 = 0;
	int operacion = OP_SUMAR;
	float resultado = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Nos llaman a traves de un enlace --> Petición GET
		request.getRequestDispatcher("views/calculadora.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Nos llaman a traves de un FORM con method POST

		try {
			// Recogemos los parámetros
			getParamters(request);
			calcular(request);
			// Enviar atributos a la vista (.JSP)
			request.setAttribute("resultado", resultado);
			dispatch = request.getRequestDispatcher("views/resultado.jsp");
		} catch (NumberFormatException nfe) {
			nfe.printStackTrace();
			request.setAttribute("msg", "El número introducido no es correcto");
			dispatch = request.getRequestDispatcher("views/calculadora.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Ha ocurrido un error");
			dispatch = request.getRequestDispatcher("views/calculadora.jsp");
		} finally {
			dispatch.forward(request, response);
		}

	}

	/**
	 * Recoge los parametros de la vista
	 * 
	 * @param request:
	 *            petición con los parametros del formulario
	 */
	private void getParamters(HttpServletRequest request) {
		String sNum1 = request.getParameter("num1");
		String sNum2 = request.getParameter("num2");
		String sOperacion = request.getParameter("operacion");

		// Comprobar que el 1. número no está vacio
		if (sNum1 != "") {
			num1 = Float.parseFloat(sNum1);
		} else {
			num1 = 0;
		}
		// Comprobar que el 2. número no está vacio
		if (sNum2 != "") {
			num2 = Float.parseFloat(sNum2);
		} else {
			num2 = 0;
		}

		operacion = Integer.parseInt(sOperacion);
	}

	/**
	 * Calcula la operación con los parámetros definidos en la vista
	 * 
	 * @param request
	 */
	private void calcular(ServletRequest request) {

		switch (operacion) {
		case 1:
			resultado = num1 + num2;
			break;
		case 2:
			resultado = num1 - num2;
			break;
		case 3:
			resultado = num1 * num2;
			break;
		case 4:
			try {
				resultado = num1 / num2;
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("msg", "No se puede dividir por '0'");
				dispatch = request.getRequestDispatcher("views/calculadora.jsp");
			}
			break;
		default:
			// TODO: En caso de que no haya escogido ninguna de las opciones
		}

	}

}
