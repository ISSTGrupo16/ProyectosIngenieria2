package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.webLab.dao.GestorDAOImplementation;
import es.upm.dit.isst.webLab.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.webLab.dao.TrabajadorDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Gestor;
import es.upm.dit.isst.webLab.dao.model.Proyecto;
import es.upm.dit.isst.webLab.dao.model.Trabajador;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private final String USER_RRHH = "root";
	private final String PASS_RRHH = "root";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Proyecto proyecto = ProyectoDAOImplementation.getInstance().loginProyecto(email,password);
		Gestor gestor = GestorDAOImplementation.getInstance().loginGestor(email, password);
		Trabajador trabajador = TrabajadorDAOImplementation.getInstance().loginTrabajador(email, password);
		
		if(USER_RRHH.equals(email) && PASS_RRHH.equals(password)) {
			req.getSession().setAttribute("proyecto_list", ProyectoDAOImplementation.getInstance().readAllProyecto());
			req.getSession().setAttribute("gestor_list", GestorDAOImplementation.getInstance().readAllGestor());
			req.getSession().setAttribute("trabajador_list", TrabajadorDAOImplementation.getInstance().readAllTrabajador());
			
			resp.sendRedirect(req.getContextPath() + "/LoginRRHH.jsp");
		}
		
		else if(gestor != null) {
			//Redirigir a Vista Gestor

			req.getSession().setAttribute("gestor", gestor);
			resp.sendRedirect(req.getContextPath() + "/LoginGestor.jsp");

		}else if(trabajador != null) {
			//Redirigir vista Trabajador

			req.getSession().setAttribute("trabajador", trabajador);
			resp.sendRedirect(req.getContextPath() + "/LoginTrabajador.jsp");

		}else {
			//FormLogin
			resp.sendRedirect(req.getContextPath() + "/FormLogin.jsp");

		}
		
	}
}
