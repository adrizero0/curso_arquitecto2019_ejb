package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import model.Contacto;

/**
 * Servlet implementation class Alta
 */
@WebServlet(urlPatterns= {"/AltaAction"})
public class AltaAction extends HttpServlet {
	@EJB
	DaoContactos dao;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Contacto contacto=new Contacto(0,
				request.getParameter("nombre"),
				request.getParameter("email"),
				Integer.parseInt(request.getParameter("edad")));
		dao.altaContacto(contacto);
		
	}

}
