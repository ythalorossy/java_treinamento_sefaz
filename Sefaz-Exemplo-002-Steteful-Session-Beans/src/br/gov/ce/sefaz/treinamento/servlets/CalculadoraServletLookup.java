package br.gov.ce.sefaz.treinamento.servlets;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ce.sefaz.treinamentos.sessions.CalculadoraLocal;
/**
 * @author yross - http://yross.wordpress.com
 */
@WebServlet("/CalculadoraServletLookup")
public class CalculadoraServletLookup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalculadoraServletLookup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			/* JNDI do BEAN
			java:global/Sefaz-Exemplo-002/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.CalculadoraLocal
			java:app/Sefaz-Exemplo-002/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.CalculadoraLocal
			java:module/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.CalculadoraLocal
			java:global/Sefaz-Exemplo-002/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.CalculadoraRemote
			java:app/Sefaz-Exemplo-002/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.CalculadoraRemote
			java:module/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.CalculadoraRemote
			java:jboss/exported/Sefaz-Exemplo-002/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.CalculadoraRemote
			 */

//			Lookup Local usando a interface de negócio global
//			CalculadoraLocal calculadora = InitialContext.doLookup("java:global/Sefaz-Exemplo-002/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.Calculadora");
			
//			Lookup Local usando o módulo
			CalculadoraLocal calculadora = InitialContext.doLookup("java:module/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.CalculadoraLocal");

//			Lookup Global na mesma instância do servidor usando apenas o JNDI do bean 
			Object object = InitialContext.doLookup("java:global/Sefaz-Exemplo-001/CalculadoraStateless");
			
			if (object != null) {
				System.out.println("java:global/Sefaz-Exemplo-001/CalculadoraStateless LOOKUPED " + object.toString());
			}
			
			
			response.getWriter().println(calculadora.getResultado());
			
			calculadora.somar(10, 10);
			
			response.getWriter().println(calculadora.getResultado());
			
			/*
			 * Acessar a URL http://localhost:8080/Sefaz-Exemplo-002/CalculadoraServletLookup
			 */
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
