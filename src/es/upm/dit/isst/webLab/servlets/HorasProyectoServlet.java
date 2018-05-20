package es.upm.dit.isst.webLab.servlets;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date hoy = Calendar.getInstance().getTime();    
		String hoystr = df.format(hoy) + "T08:00";
		String hoystr2 = df.format(hoy) + "T16:00";
		req.getSession().setAttribute("hoy_dia", hoystr);
		req.getSession().setAttribute("hoy_dia2", hoystr2);
		
		resp.sendRedirect(req.getContextPath() + "/FormHoras.jsp");
	}
}
