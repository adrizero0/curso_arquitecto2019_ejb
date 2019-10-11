package servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pedido;



@WebServlet("/ProductorPedidos")
public class ProductorPedidos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(type=ConnectionFactory.class,lookup = "java:/jms/factorytest")
	ConnectionFactory factory;
	@Resource(type=Queue.class,lookup = "java:/jms/colatest")
	Queue cola;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido=new Pedido("jam�n", 190, "serrano");
		try(Connection cn=factory.createConnection();Session ses=cn.createSession();){
			//CREAMOS PRODUCTOR DE MENSAJES
			MessageProducer productor=ses.createProducer(cola);
			//CREAMOS EL MENSAJE
			ObjectMessage obj=ses.createObjectMessage(pedido);
			//ENVIAMOS MENSAJE
			productor.send(obj);
			
		}catch(JMSException ex) {
			ex.printStackTrace();
		}		
	}	
}
