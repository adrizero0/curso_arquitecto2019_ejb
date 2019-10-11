package service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

import model.Venta;


@Stateless
public class ProductorVentasImpl implements ProductorVentas {
	@Resource(type=ConnectionFactory.class,lookup = "java:/jms/factoryventas")
	ConnectionFactory factory;
	@Resource(type=Queue.class,lookup = "java:/jms/libreriacola")
	Queue cola;
	
	@Override
	public void enviarVenta(Venta venta) {
		try(Connection cn=factory.createConnection();Session ses=cn.createSession();){
			//CREAMOS PRODUCTOR DE MENSAJES
			MessageProducer productor=ses.createProducer(cola);
			//CREAMOS EL MENSAJE
			ObjectMessage obj=ses.createObjectMessage(venta);
			//ENVIAMOS MENSAJE
			productor.send(obj);			
		}catch(JMSException ex) {
			ex.printStackTrace();
		}		
	}
}
