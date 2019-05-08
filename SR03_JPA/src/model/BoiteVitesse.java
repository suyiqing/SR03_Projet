package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the BoiteVitesse database table.
 * 
 */
@Entity
@NamedQuery(name="BoiteVitesse.findAll", query="SELECT b FROM BoiteVitesse b")
public class BoiteVitesse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idBoiteVitesse;

	private String boitevitesse;

	@Column(name="prix_boitevitesse")
	private int prixBoitevitesse;

	//bi-directional many-to-one association to Voiture
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="voiture")
	private Voiture voitureBean;

	public BoiteVitesse() {
	}

	public int getIdBoiteVitesse() {
		return this.idBoiteVitesse;
	}

	public void setIdBoiteVitesse(int idBoiteVitesse) {
		this.idBoiteVitesse = idBoiteVitesse;
	}

	public String getBoitevitesse() {
		return this.boitevitesse;
	}

	public void setBoitevitesse(String boitevitesse) {
		this.boitevitesse = boitevitesse;
	}

	public int getPrixBoitevitesse() {
		return this.prixBoitevitesse;
	}

	public void setPrixBoitevitesse(int prixBoitevitesse) {
		this.prixBoitevitesse = prixBoitevitesse;
	}

	public Voiture getVoitureBean() {
		return this.voitureBean;
	}

	public void setVoitureBean(Voiture voitureBean) {
		this.voitureBean = voitureBean;
	}

}