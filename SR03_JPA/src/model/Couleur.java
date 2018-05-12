package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Couleur database table.
 * 
 */
@Entity
@NamedQuery(name="Couleur.findAll", query="SELECT c FROM Couleur c")
public class Couleur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCouleur;

	private String couleur;

	@Column(name="prix_couleur")
	private int prixCouleur;

	//bi-directional many-to-one association to Voiture
	@ManyToOne
	@JoinColumn(name="voiture")
	private Voiture voitureBean;

	public Couleur() {
	}

	public int getIdCouleur() {
		return this.idCouleur;
	}

	public void setIdCouleur(int idCouleur) {
		this.idCouleur = idCouleur;
	}

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public int getPrixCouleur() {
		return this.prixCouleur;
	}

	public void setPrixCouleur(int prixCouleur) {
		this.prixCouleur = prixCouleur;
	}

	public Voiture getVoitureBean() {
		return this.voitureBean;
	}

	public void setVoitureBean(Voiture voitureBean) {
		this.voitureBean = voitureBean;
	}

}