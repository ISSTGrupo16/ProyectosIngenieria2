package es.upm.dit.isst.webLab.servlets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;

import es.upm.dit.isst.webLab.dao.ProyectoDAOImplementation;
import es.upm.dit.isst.webLab.dao.model.Contrato;
import es.upm.dit.isst.webLab.dao.model.Proyecto;

@WebServlet("/DescargarInformeServlet")
public class DescargarInformeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	Proyecto proyecto = ProyectoDAOImplementation.getInstance().readProyecto(req.getParameter("title"));
	ServletOutputStream sout = resp.getOutputStream();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
	Document document = new Document(pdf);
	Paragraph p = new Paragraph("Informe del proyecto:")
			.setFontSize(25);
	document.add(p);
	List list = new List();
	ListItem item = new ListItem("Nombre del Proyecto: " + proyecto.getTitle());
	list.add(item);
	item = new ListItem("Gestor: "+ proyecto.getAdvisor().getName());
	list.add(item);
	item = new ListItem("Horas previstas asignadas al proyecto: "+ proyecto.getNumeroHorasTotales());
	list.add(item);
	item = new ListItem("Horas realizadas finalmente: "+ proyecto.getNumeroHorasTrabajadas());
	list.add(item);
	for(Contrato c : proyecto.getContratos()) {
		item = new ListItem(c.getTrabajador().getName()+": \n"
				+c.getHorasAsignadas()+" horas asignadas\n"
				+c.getHorasTrabajadas()+" horas trabajadas");
		list.add(item);
	}
	
	int exito = proyecto.getNumeroHorasTotales() - proyecto.getNumeroHorasTrabajadas();
	if(exito<0) {
		item = new ListItem("Calificación deficiente: el equipo ha necesitado más horas de las previstas.");
		list.add(item);
	}else if(exito == 0){
		item = new ListItem("Calificación excelente: el equipo ha necesitado exactamente las horas previstas.");
		list.add(item);
	}else if(exito>0) {
		item = new ListItem("Calificación buena: el equipo ha necesitado menos horas de las previstas.");
		list.add(item);
	}
	
	
	document.add(list);
	document.close();
	pdf.close();
	resp.setContentType("application/pdf");
	resp.setContentLength(baos.size());
	baos.writeTo(sout);
	}
}
