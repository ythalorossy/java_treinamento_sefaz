package br.gov.ce.sefaz.treinamento.sessions;

import java.util.Date;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
/**
 * @author yross - http://yross.wordpress.com
 */
@Singleton
@Startup
public class CalculadoraStateless3 {

	@Schedule(hour = "*", minute = "*", second = "15,30,45", persistent = false)
	public void timeout() {

		System.out.println("Dispara nos segundos 15, 30 e 45 " + new Date());
	}
}
