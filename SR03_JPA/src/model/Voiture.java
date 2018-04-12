package model;

import java.io.Serializable;
import javax.persistence.*;
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

	private String couleur;

	private String marque;

	private String modele;

	//bi-directional many-to-one association to PrixTotal
	@OneToMany(mappedBy="voitureBean")
	private List<PrixTotal> prixTotals;

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

	public String getCouleur() {
		return this.couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
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

	public List<PrixTotal> getPrixTotals() {
		return this.prixTotals;
	}

	public void setPrixTotals(List<PrixTotal> prixTotals) {
		this.prixTotals = prixTotals;
	}

	public PrixTotal addPrixTotal(PrixTotal prixTotal) {
		getPrixTotals().add(prixTotal);
		prixTotal.setVoitureBean(this);

		return prixTotal;
	}

	public PrixTotal removePrixTotal(PrixTotal prixTotal) {
		getPrixTotals().remove(prixTotal);
		prixTotal.setVoitureBean(null);

		return prixTotal;
	}

}