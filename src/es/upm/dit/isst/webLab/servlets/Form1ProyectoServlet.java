package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.GestorDAOImplementation;
import es.upm.dit.isst.webLab.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Gestor;
import es.upm.dit.isst.webLab.dao.model.Proyecto;




@WebServlet("/Form1ProyectoServlet")
public class Form1ProyectoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String title = req.getParameter("title");
		int numeroTrabajadores = Integer.parseInt(req.getParameter("numeroTrabajadores"));
		String numeroHorasTotales = req.getParameter("numeroHorasTotales");
		Gestor gestorl = (Gestor) req.getSession().getAttribute("gestor");
		
		Proyecto proyecto = new Proyecto();
	
		proyecto.setTitle(title);
		proyecto.setAdvisor(gestorl);
		proyecto.setNumeroTrabajadores(numeroTrabajadores);
		proyecto.setNumeroHoras(numeroHorasTotales);
		proyecto.setName(gestorl.getName());
		proyecto.setStatus(1);
		
		ProyectoDAOImplementation.getInstance().createProyecto(proyecto);
		
		req.getSession().setAttribute("trabajador_num", numeroTrabajadores);
		req.getSession().setAttribute("proyecto", proyecto);

		
		resp.sendRedirect(req.getContextPath()+"/FormNuevosTrabajadores.jsp");

		
	}
	
}