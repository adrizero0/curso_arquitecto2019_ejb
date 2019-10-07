package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoClientes;
import daos.DaoTemas;



@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	@EJB
	DaoClientes gestion;
	@EJB
	DaoTemas gtemas;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String user=request.getParameter("user");
		String pass=request.getParameter("pwd");
		boolean resultado=false;
		if(gestion.autenticar(request.getParameter("user"),request.getParameter("pwd"))){
			request.setAttribute("usuario", gestion.getCliente(user, pass));
			request.setAttribute("temas", gtemas.obtenerTemas());
            resultado=true;         

		}
		else{
			request.setAttribute("mensaje", "Usuario no registrado");			
		}       
        request.setAttribute("resultado",resultado);
	}
	

}
