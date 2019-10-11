package servlets;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoLibros;
import model.Cliente;
import model.Libro;
import model.Venta;
import service.ProductorVentas;

/**
 * Servlet implementation class ComprarAction
 */
@WebServlet("/ComprarAction")
public class ComprarAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ProductorVentas productor;
	@EJB
	DaoLibros daoLibros;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date fecha=new Date();
		Cliente cliente=(Cliente)request.getSession().getAttribute("cliente");
		int isbn=Integer.parseInt(request.getParameter("isbn"));
		Libro libro= daoLibros.recuperarLibrosIsbn(isbn);
		productor.enviarVenta(new Venta(0,fecha,libro,cliente));
		//PARA VOLVER A CAPTURAR LOS TEMAS Y MOSTRARLOS EN LA LISTA
		request.getRequestDispatcher("TemasAction").include(request, response);
	}
}
