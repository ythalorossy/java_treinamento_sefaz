package com.wordpress.yross.cdi.servlets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wordpress.yross.cdi.beans.Calcular;
import com.wordpress.yross.cdi.qualifiers.Simples;

@WebServlet("/SimplesServlet")
public class SimplesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	@Simples
	private Calcular calcular;
	
	public SimplesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int resultado = calcular.soma(10, 10);
		
		response.getWriter().println("Calculadora Simples: " + resultado);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
