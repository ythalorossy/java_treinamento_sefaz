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
	 * PostContruct executado logo ap�s a cria��o do bean
	 */
	@PostConstruct
	public void postConstruct() {
		System.out.println(this.getClass().getSimpleName() + " foi constru�do");
	}

	/*
	 * PreDestroy executado antes da destrui��o do bean
	 */
	@PreDestroy
	public void preDestroy() {
		System.out.println(this.getClass().getSimpleName() + " ser� destru�do");
	}
}
