package es.upm.dit.isst.webLab.dao.model;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@Entity
public class Contrato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long contratoID;
	
	@ManyToOne
	private Proyecto proyecto;
	
	@ManyToOne
	private Trabajador trabajador;
	
	private int horasAsignadas;
	
	private int horasTrabajadas;

	@OneToMany(mappedBy = "contrato", fetch = FetchType.EAGER)
	private List<Horas> horas;
	
	public Contrato() {
		this.horas = new ArrayList<Horas>();
	}

	public long getContratoID() {
		return contratoID;
	}

	public void setContratoID(long contratoID) {
		this.contratoID = contratoID;
	}	

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
	public int getHorasAsignadas() {
		return horasAsignadas;
	}

	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}
	
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}

	public void setHorasTrabajadas(int horasTrabajadas) {
		this.horasTrabajadas = horasTrabajadas;
	}
	
	public List<Horas> getHoras() {
		return horas;
	}

	public void setHoras(List<Horas> horas) {
		this.horas = horas;
	}
	
	public void addHoras(Horas hora){
		horas.add(hora);
	}
}


