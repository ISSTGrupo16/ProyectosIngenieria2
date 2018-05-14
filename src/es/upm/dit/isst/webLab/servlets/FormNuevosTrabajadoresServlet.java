package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.webLab.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Gestor;
import es.upm.dit.isst.webLab.dao.model.Proyecto;
import es.upm.dit.isst.webLab.dao.model.Trabajador;

import java.util.List;
import java.util.Set;

@WebServlet("/FormNuevosTrabajadoresServlet")
public class FormNuevosTrabajadoresServlet extends HttpServlet {
	
	private Set<Trabajador> trabajadores;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Proyecto proyecto = (Proyecto)req.getSession().getAttribute("proyecto");
		int tab_num = (int)req.getSession().getAttribute("trabajador_num");
		
		for (int i =1; i<=tab_num ; i++) {		
			String email = (String) req.getParameter(String.valueOf(i));
			Trabajador trabajador = TrabajadorDAOImplementation.getInstance().readTrabajador(email);
			trabajador.addProyecto(proyecto);
			TrabajadorDAOImplementation.getInstance().updateTrabajador(trabajador);
		}
			
		resp.sendRedirect(req.getContextPath()+"/LoginGestor.jsp");
		
	}

}
