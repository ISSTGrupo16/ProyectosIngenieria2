package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.webLab.dao.ContratoDAOImplementation;
import es.upm.dit.isst.webLab.dao.GestorDAOImplementation;
import es.upm.dit.isst.webLab.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Proyecto;
import es.upm.dit.isst.webLab.dao.model.Trabajador;
import es.upm.dit.isst.webLab.dao.model.Contrato;
import es.upm.dit.isst.webLab.dao.model.Gestor;

@WebServlet("/FormNuevosTrabajadoresServlet")
public class FormNuevosTrabajadoresServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Proyecto proyecto = (Proyecto)req.getSession().getAttribute("proyecto");
		int tab_num = (int)req.getSession().getAttribute("trabajador_num");
		//esta linea sobra
		int horasTotales = proyecto.getNumeroHorasTotales();
		
		//saneamiento campos
		for (int i =1; i<=tab_num ; i++) {
			if(null == req.getParameter(String.valueOf(i)) || null == req.getParameter("l" + String.valueOf(i))){
				resp.sendRedirect(req.getContextPath()+"/FormNuevosTrabajadores.jsp");
				return;
			}
		}
		
		for (int i =1; i<=tab_num ; i++) {		
			String email = (String) req.getParameter(String.valueOf(i));
			int horas = Integer.parseInt(req.getParameter("l" + String.valueOf(i)));
			horasTotales += horas;
			Trabajador trabajador = TrabajadorDAOImplementation.getInstance().readTrabajador(email);
			Contrato contrato = new Contrato();
			contrato.setTrabajador(trabajador);
			contrato.setProyecto(proyecto);
			contrato.setHorasAsignadas(horas);
			contrato.setHorasTrabajadas(0);
			trabajador.addContrato(contrato);
			TrabajadorDAOImplementation.getInstance().updateTrabajador(trabajador);
			ContratoDAOImplementation.getInstance().createContrato(contrato);
		}
		
		proyecto.setNumeroHoras(horasTotales);
		ProyectoDAOImplementation.getInstance().updateProyecto(proyecto);

		//actualizo gestor para q salga en la vista
		Gestor gestorl = (Gestor) req.getSession().getAttribute("gestor");
		gestorl = GestorDAOImplementation.getInstance().loginGestor(gestorl.getEmail(), gestorl.getPassword());
		req.getSession().setAttribute("gestor", gestorl);
		  
		resp.sendRedirect(req.getContextPath()+"/LoginGestor.jsp");
		
	}

}
