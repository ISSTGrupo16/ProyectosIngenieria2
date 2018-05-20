package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Proyecto;




@WebServlet("/FormNuevoTrabajadorServlet")
public class FormNuevoTrabajadorServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		Proyecto proy = ProyectoDAOImplementation.getInstance().readProyecto(title);
		proy.setNumeroTrabajadores(proy.getNumeroTrabajadores() + 1);
		ProyectoDAOImplementation.getInstance().updateProyecto(proy);
		int num = 1;
		req.getSession().setAttribute("trabajador_num", num);
		req.getSession().setAttribute("proyecto", proy);
		
		resp.sendRedirect(req.getContextPath()+"/FormNuevosTrabajadores.jsp");
		
	}	
}

