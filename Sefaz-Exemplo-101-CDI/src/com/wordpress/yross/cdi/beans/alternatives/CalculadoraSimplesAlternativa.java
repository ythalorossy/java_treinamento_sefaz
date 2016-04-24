/**
 * 
 */
package com.wordpress.yross.cdi.beans.alternatives;

import javax.enterprise.inject.Alternative;

import com.wordpress.yross.cdi.beans.Calcular;
import com.wordpress.yross.cdi.qualifiers.Simples;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com -
 *         http://yross.wordpress.com)
 */

@Alternative
@Simples
public class CalculadoraSimplesAlternativa implements Calcular {

	public int soma(int a, int b) {

		int resultado = a + b;

		resultado *= 10;

		return resultado;
	}

}
