package br.gov.ce.sefaz.treinamento.sessions;

import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;

/**
 * @author yross - http://yross.wordpress.com
 */
@Singleton
@Startup
public class CalculadoraStateless2 {

	@Resource
	private TimerService timerService;

	@PostConstruct
	public void createTimer() {
		
		// Dispara de 5 em 5 segundos
		ScheduleExpression expression = 
				new ScheduleExpression()
				.hour("*")
				.minute("*")
				.second("*/10");
		
		timerService.createCalendarTimer(expression, new TimerConfig("10s", false));
	}

	@Timeout
	public void timeout(Timer timer) {

		System.out.println(timer.getInfo() + " dispara de 10 em 10 segundos "  + new Date());
	}
	
	@PreDestroy
	public void destroy(){

		Collection<Timer> timers = timerService.getTimers();
		for (Timer timer : timers) {
			if (timer.getInfo().equals("10s")) {
				timer.cancel();
				break;
			}
		}
		
	}
}
