package es.upm.dit.isst.webLab.servlets;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormLogoutServlet")
public class FormLogoutServlet extends HttpServlet{
	
	@Override
	protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().setAttribute("gestor", null);
		req.getSession().setAttribute("trabajador", null);
		req.getSession().setAttribute("rrhh", null);
		req.getSession().setAttribute("proyecto_list", null);
		req.getSession().setAttribute("gestor_list", null);
		req.getSession().setAttribute("trabajadores_list", null);
		
		resp.sendRedirect(req.getContextPath()+"/FormLogin.jsp");	
	}

}
