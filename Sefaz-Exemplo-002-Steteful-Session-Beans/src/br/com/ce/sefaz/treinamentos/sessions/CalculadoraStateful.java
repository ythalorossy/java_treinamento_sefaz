package br.com.ce.sefaz.treinamentos.sessions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
/**
 * @author yross - http://yross.wordpress.com
 */
@Stateful(mappedName = "HcalculadoraStateful")
public class CalculadoraStateful implements CalculadoraLocal, CalculadoraRemote {

	private int resultado = 900000009;

    public CalculadoraStateful() {
    }
    
	public int somar(int a, int b) {
    	
    	return resultado = a + b;
    }

	public int subtrair(int a, int b) {
    	return resultado = a - b;
    }

	public int dividir(int a, int b) {
    	
    	if (a < 0) {
    		return 0;
    	}
    	
    	return resultado = a / b;
    }
    
	public int multiplicar(int a, int b) {
    	return resultado = a * b;
    }

	public int getResultado() {
		return resultado;
	}

	@Remove
    public void remove() {
    	System.out.println(this.getClass().getSimpleName() + " ser� removido");
    }
    
	/*
	 * PostContruct executado logo ap�s a cria��o do bean
	 */
	@PostConstruct
	public void postConstruct() {
		System.out.println(this.getClass().getSimpleName() + " foi constru�do");
	}

	@PrePassivate
	public void prePassivate() {
		System.out.println(this.getClass().getSimpleName() + " ser� passivado");
	}

	@PostActivate
	public void postActivate() {
		System.out.println(this.getClass().getSimpleName() + " foi ativado");
	}
	
	/*
	 * PreDestroy executado antes da destrui��o do bean
	 */
	@PreDestroy
	public void preDestroy() {
		System.out.println(this.getClass().getSimpleName() + " ser� destru�do");
	}
}
