package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the Voiture database table.
 * 
 */
@Entity
@NamedQuery(name="Voiture.findAll", query="SELECT v FROM Voiture v")
public class Voiture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idVoiture;

	private int annee;

	private String coffre;

	private String marque;

	private String modele;

	private String portes;

	@Column(name="prix_base")
	private int prixBase;

	//bi-directional many-to-one association to BoiteVitesse
	@JsonIgnore
	@OneToMany(mappedBy="voitureBean")
	private List<BoiteVitesse> boiteVitesses;

	//bi-directional many-to-one association to Couleur
	@JsonIgnore
	@OneToMany(mappedBy="voitureBean")
	private List<Couleur> couleurs;

	//bi-directional many-to-one association to Finition
	@JsonIgnore
	@OneToMany(mappedBy="voitureBean")
	private List<Finition> finitions;

	//bi-directional many-to-one association to Motorisation
	@JsonIgnore
	@OneToMany(mappedBy="voitureBean")
	private List<Motorisation> motorisations;

	public Voiture() {
	}

	public int getIdVoiture() {
		return this.idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public int getAnnee() {
		return this.annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getCoffre() {
		return this.coffre;
	}

	public void setCoffre(String coffre) {
		this.coffre = coffre;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return this.modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getPortes() {
		return this.portes;
	}

	public void setPortes(String portes) {
		this.portes = portes;
	}

	public int getPrixBase() {
		return this.prixBase;
	}

	public void setPrixBase(int prixBase) {
		this.prixBase = prixBase;
	}

	public List<BoiteVitesse> getBoiteVitesses() {
		return this.boiteVitesses;
	}

	public void setBoiteVitesses(List<BoiteVitesse> boiteVitesses) {
		this.boiteVitesses = boiteVitesses;
	}

	public BoiteVitesse addBoiteVitess(BoiteVitesse boiteVitess) {
		getBoiteVitesses().add(boiteVitess);
		boiteVitess.setVoitureBean(this);

		return boiteVitess;
	}

	public BoiteVitesse removeBoiteVitess(BoiteVitesse boiteVitess) {
		getBoiteVitesses().remove(boiteVitess);
		boiteVitess.setVoitureBean(null);

		return boiteVitess;
	}

	public List<Couleur> getCouleurs() {
		return this.couleurs;
	}

	public void setCouleurs(List<Couleur> couleurs) {
		this.couleurs = couleurs;
	}

	public Couleur addCouleur(Couleur couleur) {
		getCouleurs().add(couleur);
		couleur.setVoitureBean(this);

		return couleur;
	}

	public Couleur removeCouleur(Couleur couleur) {
		getCouleurs().remove(couleur);
		couleur.setVoitureBean(null);

		return couleur;
	}

	public List<Finition> getFinitions() {
		return this.finitions;
	}

	public void setFinitions(List<Finition> finitions) {
		this.finitions = finitions;
	}

	public Finition addFinition(Finition finition) {
		getFinitions().add(finition);
		finition.setVoitureBean(this);

		return finition;
	}

	public Finition removeFinition(Finition finition) {
		getFinitions().remove(finition);
		finition.setVoitureBean(null);

		return finition;
	}

	public List<Motorisation> getMotorisations() {
		return this.motorisations;
	}

	public void setMotorisations(List<Motorisation> motorisations) {
		this.motorisations = motorisations;
	}

	public Motorisation addMotorisation(Motorisation motorisation) {
		getMotorisations().add(motorisation);
		motorisation.setVoitureBean(this);

		return motorisation;
	}

	public Motorisation removeMotorisation(Motorisation motorisation) {
		getMotorisations().remove(motorisation);
		motorisation.setVoitureBean(null);

		return motorisation;
	}

}