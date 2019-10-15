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
		String op=request.getParameter("op");
		String url="login.jsp";
		switch(op) {
			case "doLibros":
				request.getRequestDispatcher("LibrosAction").forward(request, response);
				return;
			case "doTemas":
				request.getRequestDispatcher("TemasAction").include(request, response);
                url="temas.jsp"; 
                break;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
