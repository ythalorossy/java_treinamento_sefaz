/**
 * 
 */
package com.wordpress.yross.cdi.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.wordpress.yross.cdi.qualifiers.Randomico;
import com.wordpress.yross.cdi.qualifiers.Simples;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
@Named("calculadoraSimples")
@Simples
@RequestScoped
public class CalculadoraSimples implements Calcular {

	public int soma(int a, int b) {
		return a + b;
	}
	
	
	/*
	 * Adicionando capacidade para usar o 
	 * exemplo da anotação @Named
	 */
	
	private int a, b;
	private int resultado;
	
	@Inject
	@Randomico
	private int numeroRadomico;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	
	
	public int getNumeroRadomico() {
		return numeroRadomico;
	}

	public void setNumeroRadomico(int numeroRadomico) {
		this.numeroRadomico = numeroRadomico;
	}

	public String calcular() {
		this.resultado = this.a + this.b;
		return "calculadora";
	}
}
