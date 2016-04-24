/**
 * 
 */
package br.gov.ce.sefaz.treinamento.interceptors;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * @author yross - http://yross.wordpress.com
 */
@Interceptor
public class CalculadoraInterceptor1 {

    @AroundInvoke()	
    public Object arroundInvoke(InvocationContext ctx) throws Exception {
    	
    	System.out.println(ctx.getMethod().getName() + " invocado!!!!");
    	
    	return ctx.proceed();
    }
    
    @PostConstruct
    public void postContruct(){
    	System.out.println("Contruido");
    }
    

    @PreDestroy
    public void preDestroy(){
    	System.out.println("Será destruído");
    }

}
