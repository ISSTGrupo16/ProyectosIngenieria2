package es.upm.dit.isst.webLab.dao.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.io.Serializable;

@Entity
public class Trabajador implements Serializable {

	@Id
	private String email;
	private String password;
	private String name;
	private String especialidad;
	
	@OneToMany(mappedBy = "trabajador", fetch = FetchType.EAGER)
    List<Contrato> contratos;
	
	public Trabajador() {
		this.contratos = new ArrayList<Contrato>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Contrato> getPContratos() {
		return this.contratos;
	}

	public void setPContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
	
	public void addContrato(Contrato contrato){
		contratos.add(contrato);
	}
	
	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}	

}


