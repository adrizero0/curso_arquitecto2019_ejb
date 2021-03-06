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

import daos.DaoContactos;
import model.Contacto;


@WebServlet("/ContactosAction")
public class ContactosAction extends HttpServlet {
	@EJB
	DaoContactos dao;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Contacto> contactos=dao.recuperarContactos();
		PrintWriter out=response.getWriter();
		response.setContentType("text/plain");
		out.println(convertirJson(contactos));
	}
	
	private String convertirJson(List<Contacto> contactos) {
		JSONArray array=new JSONArray();
		for(Contacto con:contactos) {
			JSONObject obj=new JSONObject();
			obj.put("idContacto", con.getIdContacto());
			obj.put("nombre", con.getNombre());
			obj.put("edad", con.getEdad());
			obj.put("email", con.getEmail());
			array.add(obj);
		}
		return array.toJSONString();
	}
}
