package br.gov.ce.sefaz.treinamento.sessions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

/**
 * @author yross - http://yross.wordpress.com
 */
@Stateless(mappedName = "calculadoraStateless")
public class CalculadoraStateless implements Calculadora{
	
	private int resultado = 900000009;

    public CalculadoraStateless() {
    }
    
    @Override
	public int somar(int a, int b) {
    	return resultado = a + b;
    }
    
    /**
	 * @param resultado the resultado to set
	 */
	@Override
	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	@Override
	public int subtrair(int a, int b) {
    	return resultado = a - b;
    }

    @Override
	public int dividir(int a, int b) {
    	
    	if (a < 0) {
    		return 0;
    	}
    	
    	return resultado = a / b;
    }
    
    @Override
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
