package es.upm.dit.isst.webLab.dao;


import java.util.List;

import es.upm.dit.isst.webLab.dao.model.Proyecto;

public interface ProyectoDAO {

	public void createProyecto (Proyecto proyecto);
	public Proyecto readProyecto (String title);
	public void updateProyecto(Proyecto proyecto);
	public void deleteProyecto(Proyecto proyecto);
	
	public List<Proyecto> readAllProyecto();

}
