package br.gov.ce.sefaz.treinamento.sessions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;
/**
 * @author yross - http://yross.wordpress.com
 */
@TransactionManagement(TransactionManagementType.BEAN)
@Stateless
public class CalculadoraStatelessBMT {
	
	private int resultado = 900000009;

	@Resource(mappedName = "java:comp/UserTransaction")
	private UserTransaction userTransaction;
	
    public CalculadoraStatelessBMT() {
    }
    
    public void setUserTransaction(UserTransaction userTransaction) {
		this.userTransaction = userTransaction;
	}

	@TransactionAttribute (TransactionAttributeType.NOT_SUPPORTED)
    public int somar(int a, int b) {
		
		try {
			userTransaction.begin();
		
			resultado = a + b;
			
			userTransaction.commit();
			
		} catch (Exception e) {

			try {
				userTransaction.setRollbackOnly();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
    	return resultado;
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
