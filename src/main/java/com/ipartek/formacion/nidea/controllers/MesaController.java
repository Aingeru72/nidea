package com.ipartek.formacion.nidea.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class MesaController
 */
public class MesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Mesa mesa = new Mesa();

		// Recoger los parametros ( siempre llegan como String )
		String sNumPatas = request.getParameter("numPatas");
		if (sNumPatas != null) {
			int numPatas = Integer.parseInt(sNumPatas);
			mesa.setNumPatas(numPatas);
		}

		String sDimension = request.getParameter("dimension");
		if (sDimension != null) {
			int dimension = Integer.parseInt(sDimension);
			mesa.setDimension(dimension);
		}

		String sMaterial = request.getParameter("material");
		if (sMaterial != null) {
			int material = Integer.parseInt(sMaterial);
			mesa.setMaterial(material);
		}

		String sEsCustom = request.getParameter("isCustom");
		String sColorCustom = request.getParameter("color");
		// Si el checkbox está checked --> "on"
		// Si el checkbox NO está checked --> null
		if (sEsCustom != null) {
			mesa.setColor(sColorCustom);
			mesa.setCustomColor(true);
		} else {
			mesa.setCustomColor(false);
		}

		// Enviar atributos a la JSP (request interna)
		request.setAttribute("mesa", mesa);
		request.setAttribute("materiales", Mesa.MATERIALES_LISTA);
		request.setAttribute("materialesID", Mesa.MATERIALES_ID);

		// Ir a la JSP
		request.getRequestDispatcher("views/mesa.jsp").forward(request, response);
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
