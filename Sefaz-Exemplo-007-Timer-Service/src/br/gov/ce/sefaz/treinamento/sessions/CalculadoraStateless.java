package br.gov.ce.sefaz.treinamento.sessions;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
/**
 * @author yross - http://yross.wordpress.com
 */
@Singleton
@Startup
public class CalculadoraStateless {

	@Resource
	private TimerService timerService;

	@PostConstruct
	public void createTimer() {
		
		// Aguarda 5 segundos e dispara
		timerService.createTimer(5000, "5s");
	}

	@Timeout
	public void timeout(Timer timer) {

		System.out.println(timer.getInfo() + " disparou depois de 5 segundos");
	}
	
	@PreDestroy
	public void destroy(){

		Collection<Timer> timers = timerService.getTimers();
		for (Timer timer : timers) {
			if (timer.getInfo().equals("5s")) {
				timer.cancel();
				break;
			}
		}
	}
}
