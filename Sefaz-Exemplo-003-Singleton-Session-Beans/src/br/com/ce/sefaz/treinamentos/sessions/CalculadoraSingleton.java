package br.com.ce.sefaz.treinamentos.sessions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
/**
 * @author yross - http://yross.wordpress.com
 */
//@Startup
//@Singleton
public class CalculadoraSingleton {

	private int resultado = 900000009;

    public CalculadoraSingleton() {
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

	/*
	 * PostContruct executado logo após a criação do bean
	 */
	@PostConstruct
	public void postConstruct() {
		System.out.println(this.getClass().getSimpleName() + " foi construído");
	}
	
	/*
	 * PreDestroy executado antes da destruição do bean
	 */
	@PreDestroy
	public void preDestroy() {
		System.out.println(this.getClass().getSimpleName() + " será destruído");
	}
}
