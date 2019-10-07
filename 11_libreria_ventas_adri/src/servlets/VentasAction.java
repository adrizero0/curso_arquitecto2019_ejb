package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoVentas;
import model.Cliente;
import model.Venta;

/**
 * Servlet implementation class VentasAction
 */
@WebServlet("/VentasAction")
public class VentasAction extends HttpServlet {
	@EJB
	DaoVentas dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		Cliente c=(Cliente)request.getAttribute("usuario");
		List<Venta> ventas= dao.recuperarVentas(c);
		request.setAttribute("ventas", ventas);
	}
}
