package es.upm.dit.isst.webLab.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import es.upm.dit.isst.webLab.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Proyecto;

@WebServlet("/HorasProyectoServlet")
public class HorasProyectoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String proy = req.getParameter("proyecto");
		Proyecto proyecto = ProyectoDAOImplementation.getInstance().readProyecto(proy);
		req.getSession().setAttribute("proyecto_horas", proyecto);
		resp.sendRedirect(req.getContextPath() + "/FormHoras.jsp");
	}
}
