package com.wordpress.yross.cdi.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wordpress.yross.cdi.beans.Calcular;
import com.wordpress.yross.cdi.qualifiers.Cientifica;

@WebServlet("/CientificaServlet")
public class CientificaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	@Cientifica
	private Calcular calcular;
	
	public CientificaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int resultado = calcular.soma(10, 10);
		
		response.getWriter().println("Calculadora Cientifica: " + resultado);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
