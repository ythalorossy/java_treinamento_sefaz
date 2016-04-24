package br.gov.ce.sefaz.treinamento.jms.consumidores;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
/**
 * @author yross - http://yross.wordpress.com
 */
@MessageDriven(activationConfig={
		@ActivationConfigProperty(propertyName="destination", propertyValue="java:/jms/queue/Calculadora"),
		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jsm.Queue")
})
public class CalculadoraMessageDriven implements MessageListener {

    public CalculadoraMessageDriven() {}
	
    public void onMessage(Message message) {
    	
    	if (message instanceof TextMessage) {
			
    		try {
	
    			System.out.println(((TextMessage) message).getText());
			
    		} catch (JMSException e) {
			
    			e.printStackTrace();
			}
		}
    }
}
