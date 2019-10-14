package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import daos.DaoTemas;
import model.Libro;
import model.Tema;


/**
 * Servlet implementation class TemasAction
 */
@WebServlet("/TemasAction")
public class TemasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	DaoTemas dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("temas", dao.obtenerTemas());
//		List<Tema> temas=dao.obtenerTemas();
//		PrintWriter out=response.getWriter();
//		response.setContentType("text/plain");
//		out.println(convertirJson(temas));
	}
	
//	private String convertirJson(List<Tema> temas) {
//		JSONArray array=new JSONArray();
//		for(Tema te:temas) {
//			JSONObject obj=new JSONObject();
//			obj.put("idTema", te.getIdTema());
//			obj.put("tema", te.getTema());
//			array.add(obj);			
//		}
//		return array.toJSONString();
//	}

}
