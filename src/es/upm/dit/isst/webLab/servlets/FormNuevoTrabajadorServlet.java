package es.upm.dit.isst.webLab.servlets;

import java.io.Console;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Trabajador;

@WebServlet("/FormNuevotrabajadorServlet")
public class FormNuevoTrabajadorServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String especialidad = req.getParameter("especialidad");
		
		Trabajador trabajador = new Trabajador();
		trabajador.setName(name);
		trabajador.setEmail(email);
		trabajador.setPassword(password);
		trabajador.setEspecialidad(especialidad);
		
		TrabajadorDAOImplementation.getInstance().createTrabajador(trabajador);

		resp.sendRedirect(req.getContextPath() + "/LoginRRHH.jsp");

	}
}