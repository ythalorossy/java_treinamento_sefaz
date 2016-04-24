package br.gov.ce.sefaz.treinamento.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gov.ce.sefaz.treinamento.sessions.CalculadoraStatelessBMT;
import br.gov.ce.sefaz.treinamento.sessions.CalculadoraStatelessCMT;

/**
 * @author yross - http://yross.wordpress.com
 */
@WebServlet("/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/*
	 * O EJB CalculadoraSSB � injetado na vari�vel de inst�ncia
	 */
	@EJB
	private CalculadoraStatelessBMT calculadoraStateless;
	
    public CalculadoraServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("Somar: 10 + 10 = " + calculadoraStateless.somar(10, 10));
		
		response.getWriter().println("Subtrair: 10 - 10 = " + calculadoraStateless.subtrair(10, 10));
		
		response.getWriter().println("Multiplicar: 10 x 10 = " + calculadoraStateless.multiplicar(10, 10));
		
		response.getWriter().println("Dividir: 10 / 10 = " + calculadoraStateless.dividir(10, 10));
		
		response.getWriter().println("Resultado = " + calculadoraStateless.getResultado());
		
		// Acessar a URL http://localhost:8080/Sefaz-Exemplo-005/CalculadoraServlet
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
