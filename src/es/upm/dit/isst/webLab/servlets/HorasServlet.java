package es.upm.dit.isst.webLab.servlets;

import java.io.Console;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.Math.toIntExact;

import es.upm.dit.isst.webLab.dao.ContratoDAOImplementation;
import es.upm.dit.isst.webLab.dao.HorasDAOImplementation;
import es.upm.dit.isst.webLab.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Proyecto;
import es.upm.dit.isst.webLab.dao.model.Trabajador;
import es.upm.dit.isst.webLab.dao.model.Contrato;
import es.upm.dit.isst.webLab.dao.model.Horas;

@WebServlet("/HorasServlet")
public class HorasServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String hora1 = req.getParameter("hora_inicio");
		String hora2 = req.getParameter("hora_fin");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		Date horaInicio = new Date();
		try {
			horaInicio = sdf.parse(hora1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date horaFin = new Date();
		try {
			horaFin = sdf.parse(hora2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long diff = horaFin.getTime() - horaInicio.getTime();
		long diffHoras = diff/(60*60*1000);
		int diffInt = toIntExact(diffHoras);
		
		Horas hora = new Horas();
		Trabajador trabajador = (Trabajador) req.getSession().getAttribute("trabajador");
		Proyecto proyecto = (Proyecto) req.getSession().getAttribute("proyecto_horas");
		proyecto.setNumeroHorasTrabajadas(proyecto.getNumeroHorasTrabajadas() + diffInt);
		ProyectoDAOImplementation.getInstance().updateProyecto(proyecto);
		Contrato contrato = ContratoDAOImplementation.getInstance().readContrato(trabajador, proyecto);
		
		hora.setContrato(contrato);
		hora.setHoraComienzo(horaInicio);
		hora.setHoraFinal(horaFin);
		hora.setHoras(diffInt);
		HorasDAOImplementation.getInstance().createHoras(hora);
		
		resp.sendRedirect(req.getContextPath() + "/LoginTrabajador.jsp");
	}
	
}