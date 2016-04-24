/**
 * 
 */
package br.com.ce.sefaz.treinamentos.sessions;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com - http://yross.wordpress.com)
 */
public class ClientLookup {

	public static void main(String[] args) throws NamingException {
		
		CalculadoraLocal calculadora = InitialContext.doLookup("java:module/CalculadoraStateful!br.com.ce.sefaz.treinamentos.sessions.Calculadora");
		
		calculadora.somar(10, 10);
		
		System.out.println(calculadora.getResultado());
		
	}
	
}
