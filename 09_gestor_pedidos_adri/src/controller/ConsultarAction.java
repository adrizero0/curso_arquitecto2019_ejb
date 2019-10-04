package controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoPedidos;
import model.Pedido;

/**
 * Servlet implementation class ConsultarAction
 */
@WebServlet("/ConsultarAction")
public class ConsultarAction extends HttpServlet {
	@EJB
	DaoPedidos dao;	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pedido> pedidos=dao.recuperarPedidos();
				if(pedidos.size()>0) {
					request.setAttribute("resultado",1);
					request.setAttribute("pedidos",pedidos);
				}else {
					request.setAttribute("resultado",0);
				}
	}

}
