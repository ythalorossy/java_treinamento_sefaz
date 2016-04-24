/**
 * 
 */
package com.wordpress.yross.cdi.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import com.wordpress.yross.cdi.qualifiers.Cientifica;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */
@Cientifica
@ApplicationScoped
public class CalculadoraCientifica implements Calcular, Serializable {


	@PostConstruct
	public void init() {
		System.out.println("Calculadora Cientifica criada!!!");
	}
	
	public int soma(int a, int b) {

		return (a + a) + (b + b);
	}

	private static final long serialVersionUID = 1734857426598493216L;
}
