package es.upm.dit.isst.webLab.dao;

import java.util.List;


import es.upm.dit.isst.webLab.dao.model.Gestor;

public interface GestorDAO {

	public void createGestor (Gestor gestor);
	public Gestor readGestor (String email);
	public void updateGestor (Gestor gestor);
	public void deleteGestor (Gestor gestor);
	
	public List<Gestor> readAllGestor();
	public Gestor loginGestor(String email, String password);

}
