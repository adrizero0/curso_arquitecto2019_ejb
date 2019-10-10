package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.Future;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ebjs.Calculo;

/**
 * Servlet implementation class TestCalculos
 */
@WebServlet("/TestCalculos")
public class TestCalculos extends HttpServlet {
	@EJB
	Calculo calculo;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try{
			Future<Integer> future=calculo.sumaNumeros(60);
			out.println("<html><body>");
			while(!future.isDone()) {
				System.out.println("Esperando respuesta");
			}
			int res=future.get();
			out.println("<h1>La suma es "+res+"</h1>");
			out.println("</body></html>");			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
