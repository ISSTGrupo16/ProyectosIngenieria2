package es.upm.dit.isst.webLab.dao.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Horas implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long horasID;
	
	@ManyToOne
	private Contrato contrato;
	private Date horaComienzo;
	private Date horaFinal;
	private int horas;
	
	public Horas() {
	}

	public long getHorasID() {
		return horasID;
	}

	public void setHorasID(long horasID) {
		this.horasID = horasID;
	}	

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Date getHoraComienzo() {
		return horaComienzo;
	}

	public void setHoraComienzo(Date horaComienzo) {
		this.horaComienzo = horaComienzo;
	}
	
	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}
}


