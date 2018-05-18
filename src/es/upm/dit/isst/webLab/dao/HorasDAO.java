package es.upm.dit.isst.webLab.dao;

import java.util.List;

import es.upm.dit.isst.webLab.dao.model.Horas;

public interface HorasDAO {

	public void createHoras (Horas horas);
	public Horas readHoras (String title);
	public void updateHoras(Horas horas);
	public void deleteHoras(Horas horas);
	
	public List<Horas> readAllHoras();

}
