/**
 * 
 */
package br.com.ce.sefaz.treinamentos.sessions;

import javax.ejb.Remote;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com - http://yross.wordpress.com)
 */
@Remote
public interface CalculadoraRemote {

	int somar(int a, int b);
	int subtrair(int a, int b);
	int dividir(int a, int b);
	int multiplicar(int a, int b);
	int getResultado();
}