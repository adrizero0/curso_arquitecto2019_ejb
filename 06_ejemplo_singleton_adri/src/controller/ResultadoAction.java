package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbs.ContadorEjb;

@WebServlet("/ResultadoAction")
public class ResultadoAction extends HttpServlet {
	@EJB
	ContadorEjb contador;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("valor", contador.getValor());
	}
}
