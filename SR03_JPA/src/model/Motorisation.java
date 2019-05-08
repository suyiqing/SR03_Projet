package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Motorisation database table.
 * 
 */
@Entity
@NamedQuery(name="Motorisation.findAll", query="SELECT m FROM Motorisation m")
public class Motorisation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idMotorisation;

	private String motorisation;

	@Column(name="prix_motorisation")
	private int prixMotorisation;

	//bi-directional many-to-one association to Voiture
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="voiture")
	private Voiture voitureBean;

	public Motorisation() {
	}

	public int getIdMotorisation() {
		return this.idMotorisation;
	}

	public void setIdMotorisation(int idMotorisation) {
		this.idMotorisation = idMotorisation;
	}

	public String getMotorisation() {
		return this.motorisation;
	}

	public void setMotorisation(String motorisation) {
		this.motorisation = motorisation;
	}

	public int getPrixMotorisation() {
		return this.prixMotorisation;
	}

	public void setPrixMotorisation(int prixMotorisation) {
		this.prixMotorisation = prixMotorisation;
	}

	public Voiture getVoitureBean() {
		return this.voitureBean;
	}

	public void setVoitureBean(Voiture voitureBean) {
		this.voitureBean = voitureBean;
	}

}