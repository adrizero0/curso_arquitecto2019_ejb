package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlFinal="index.html";
		String op=request.getParameter("op");
		switch(op) {
			case "doConsultar":
				urlFinal=obtenerUrl(request,response);
				break;
			case "doEliminar":
				request.getRequestDispatcher("EliminarAction").include(request,response);
				urlFinal=obtenerUrl(request,response);
				break;
			case "doAlta":
				request.getRequestDispatcher("AltaAction").include(request,response);
				urlFinal="index.html";
				break;
			case "doEditar":
				request.getRequestDispatcher("EditarAction").include(request,response);
				urlFinal="editar.jsp";
				break;
			case "doModificar":
				request.getRequestDispatcher("ModificarAction").include(request,response);
				urlFinal=obtenerUrl(request,response);
				break;
			case "toNuevo":
				urlFinal="nuevo.html";
				break;
			case "toVolver":
				urlFinal="index.html";
				break;			
		}
		//transferimos la petición a la vista
		request.getRequestDispatcher(urlFinal).forward(request,response);
	}
	private String obtenerUrl(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("ConsultarAction").include(request,response);
		return ((Integer)request.getAttribute("resultado"))==1?"consultar.jsp":"sinpedidos.jsp";	
	}
}
