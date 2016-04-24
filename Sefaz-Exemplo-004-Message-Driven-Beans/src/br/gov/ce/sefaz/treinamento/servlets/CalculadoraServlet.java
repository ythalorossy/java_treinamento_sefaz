package br.gov.ce.sefaz.treinamento.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yross - http://yross.wordpress.com
 */
@WebServlet("/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Resource(mappedName = "java:/jms/CalculadoraConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/jms/queue/Calculadora")
	private Queue destination;
	
    public CalculadoraServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection connection = null;
		Session session = null;
		MessageProducer producer = null;

		try {
		
			System.out.println("Criando mensagem");
			
			// javax.jms.Connection
			connection = connectionFactory.createConnection();

			// javax.jms.Session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			producer = session.createProducer(destination);
		
			TextMessage message = session.createTextMessage();
			message.setText("!!! MENSAGEM MENSAGEM MENSAGEM MENSAGEM MENSAGEM MENSAGEM MENSAGEM MENSAGEM !!!");
			
			producer.send(message);
			
			System.out.println("Mensagem enviada!");
			
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (producer != null) {
					producer.close();
				}
				if (session != null) {
					session.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (JMSException e2) {
				e2.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
