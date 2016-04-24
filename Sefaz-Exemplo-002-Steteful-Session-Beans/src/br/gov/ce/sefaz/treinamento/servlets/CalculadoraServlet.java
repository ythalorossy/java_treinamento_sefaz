package br.gov.ce.sefaz.treinamento.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ce.sefaz.treinamentos.sessions.CalculadoraLocal;

/**
 * @author yross - http://yross.wordpress.com
 */
@WebServlet("/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Injeção usando a interface de negócio Local
	 */
	@EJB
	private CalculadoraLocal	 calculadoraStateful;
	
    public CalculadoraServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().println("Valor inicial do Resultado = " + calculadoraStateful.getResultado());
		
		response.getWriter().println("Somar: 10 + 10 = " + calculadoraStateful.somar(10, 10));

		response.getWriter().println("Resultado = " + calculadoraStateful.getResultado());
    	
		/*
		 * Acessar a URL http://localhost:8080/Sefaz-Exemplo-002-Steteful-Session-Beans/CalculadoraServlet
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
