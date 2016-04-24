package br.gov.ce.sefaz.treinamento.sessions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
/**
 * @author yross - http://yross.wordpress.com
 */
@TransactionManagement(TransactionManagementType.CONTAINER)
@Stateless
public class CalculadoraStatelessCMT {
	
	private int resultado = 900000009;

	@Resource
	private SessionContext sessionContext;
	
    public CalculadoraStatelessCMT() {
    }
    
    @TransactionAttribute (TransactionAttributeType.NOT_SUPPORTED)
    public int somar(int a, int b) {
    	return resultado = a + b;
    }
    
    @TransactionAttribute (TransactionAttributeType.REQUIRES_NEW)
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
