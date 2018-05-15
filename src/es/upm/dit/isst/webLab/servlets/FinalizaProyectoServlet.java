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

@WebServlet("/FinalizaProyectoServlet")
public class FinalizaProyectoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String proyectoTitle = req.getParameter("proyecto_title");
		Proyecto proyecto = ProyectoDAOImplementation.getInstance().readProyecto(proyectoTitle);
		proyecto.setStatus(2);
		ProyectoDAOImplementation.getInstance().updateProyecto(proyecto);

		// actualizo gestor para q salga en la vista
		Gestor gestorl = (Gestor) req.getSession().getAttribute("gestor");
		gestorl = GestorDAOImplementation.getInstance().loginGestor(gestorl.getEmail(), gestorl.getPassword());
		req.getSession().setAttribute("gestor", gestorl);

		resp.sendRedirect(req.getContextPath() + "/LoginGestor.jsp");

	}

}
