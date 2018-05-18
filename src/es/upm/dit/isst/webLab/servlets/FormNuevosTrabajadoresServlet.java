package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.webLab.dao.ContratoDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Proyecto;
import es.upm.dit.isst.webLab.dao.model.Trabajador;
import es.upm.dit.isst.webLab.dao.model.Contrato;

@WebServlet("/FormNuevosTrabajadoresServlet")
public class FormNuevosTrabajadoresServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Proyecto proyecto = (Proyecto)req.getSession().getAttribute("proyecto");
		int tab_num = (int)req.getSession().getAttribute("trabajador_num");
		
		for (int i =1; i<=tab_num ; i++) {		
			String email = (String) req.getParameter(String.valueOf(i));
			Trabajador trabajador = TrabajadorDAOImplementation.getInstance().readTrabajador(email);
			Contrato contrato = new Contrato();
			contrato.setTrabajador(trabajador);
			contrato.setProyecto(proyecto);
			contrato.setHorasAsignadas(20);
			contrato.setHorasTrabajadas(0);
			trabajador.addContrato(contrato);
			TrabajadorDAOImplementation.getInstance().updateTrabajador(trabajador);
			ContratoDAOImplementation.getInstance().createContrato(contrato);
		}
			
		resp.sendRedirect(req.getContextPath()+"/LoginGestor.jsp");
		
	}

}