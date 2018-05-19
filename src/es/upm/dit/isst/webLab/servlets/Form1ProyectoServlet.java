package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;
import java.util.Date;

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
		int trab = 0;
		Gestor gestorl = (Gestor) req.getSession().getAttribute("gestor");
		Date dia = new Date();
		Proyecto proyecto = new Proyecto();
	
		proyecto.setTitle(title);
		proyecto.setAdvisor(gestorl);
		proyecto.setNumeroTrabajadores(numeroTrabajadores);
		proyecto.setNumeroHoras(trab);
		proyecto.setNumeroHorasTrabajadas(trab);
		proyecto.setName(gestorl.getName());
		proyecto.setDate(dia);
		proyecto.setStatus(1);
		
		ProyectoDAOImplementation.getInstance().createProyecto(proyecto);
		
		req.getSession().setAttribute("trabajador_num", numeroTrabajadores);
		req.getSession().setAttribute("proyecto", proyecto);
		
		resp.sendRedirect(req.getContextPath()+"/FormNuevosTrabajadores.jsp");

		
	}
	
}