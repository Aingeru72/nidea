package com.ipartek.formacion.nidea.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Material;
import com.ipartek.formacion.nidea.pojo.Mesa;
import com.ipartek.formacion.nidea.pojo.MesaException;

/**
 * Servlet implementation class MesaController
 */
public class MesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MaterialDAO dao = new MaterialDAO();

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
			try {
				mesa.setNumPatas(numPatas);
			} catch (MesaException me) {
				me.printStackTrace();
				try {
					mesa.setNumPatas(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.setAttribute("alert", new Alert(me.getMessage(), Alert.TIPO_WARNING));
			}
		}

		String sDimension = request.getParameter("dimension");
		if (sDimension != null) {
			int dimension = Integer.parseInt(sDimension);
			mesa.setDimension(dimension);
		}

		String sMaterialID = request.getParameter("material");
		if (sMaterialID != null) {
			int materialID = Integer.parseInt(sMaterialID);
			Material material = getMaterialById(materialID);
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
		request.setAttribute("materiales", dao.getAll());

		// Ir a la JSP
		request.getRequestDispatcher("views/mesa.jsp").forward(request, response);
	}

	private Material getMaterialById(int materialId) {
		ArrayList<Material> tablaMateriales = dao.getAll();
		boolean encontrado = false;
		int i = 0;

		while (!tablaMateriales.isEmpty() && !encontrado) {
			if (tablaMateriales.get(i).getId() == materialId) {
				encontrado = true;
			}
			i++;

		}

		return tablaMateriales.get(i - 1);
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
