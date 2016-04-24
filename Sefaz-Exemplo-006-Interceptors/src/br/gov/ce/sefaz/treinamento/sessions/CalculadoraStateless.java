package br.gov.ce.sefaz.treinamento.sessions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.gov.ce.sefaz.treinamento.interceptors.CalculadoraInterceptor1;

@Stateless
@Interceptors({CalculadoraInterceptor1.class})
public class CalculadoraStateless {
	
    public CalculadoraStateless() {
    }

	public int somar(int a, int b) {
    	return a + b;
    }

	public int subtrair(int a, int b) {
    	return a - b;
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
