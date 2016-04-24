/**
 * 
 */
package br.gov.ce.sefaz.treinamento.sessions;

/**
 * @author Ythalo Rossy S. Lira (ythalorossy@gmail.com - http://yross.wordpress.com)
 */
public interface Calculadora {

	int multiplicar(int a, int b);

	int dividir(int a, int b);

	int subtrair(int a, int b);

	void setResultado(int resultado);

	int somar(int a, int b);

}
