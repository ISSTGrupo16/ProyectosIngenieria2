package es.upm.dit.isst.webLab.dao;

import java.util.List;

import es.upm.dit.isst.webLab.dao.model.Contrato;
import es.upm.dit.isst.webLab.dao.model.Proyecto;
import es.upm.dit.isst.webLab.dao.model.Trabajador;

public interface ContratoDAO {

	public void createContrato (Contrato contrato);
	public Contrato readContrato (String title);
	public void updateContrato(Contrato contrato);
	public void deleteContrato(Contrato contrato);
	public List<Contrato> readAllContrato();
	public List<Proyecto> readProyectos(Trabajador trabajador);
	public List<Trabajador> readTrabajador(Proyecto proyecto);

}
