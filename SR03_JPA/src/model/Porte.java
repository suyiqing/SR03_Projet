package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Portes database table.
 * 
 */
@Entity
@Table(name="Portes")
@NamedQuery(name="Porte.findAll", query="SELECT p FROM Porte p")
public class Porte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPortes;

	@Column(name="nb_porte")
	private String nbPorte;

	//bi-directional many-to-one association to PrixTotal
	@OneToMany(mappedBy="porte")
	private List<PrixTotal> prixTotals;

	public Porte() {
	}

	public int getIdPortes() {
		return this.idPortes;
	}

	public void setIdPortes(int idPortes) {
		this.idPortes = idPortes;
	}

	public String getNbPorte() {
		return this.nbPorte;
	}

	public void setNbPorte(String nbPorte) {
		this.nbPorte = nbPorte;
	}

	public List<PrixTotal> getPrixTotals() {
		return this.prixTotals;
	}

	public void setPrixTotals(List<PrixTotal> prixTotals) {
		this.prixTotals = prixTotals;
	}

	public PrixTotal addPrixTotal(PrixTotal prixTotal) {
		getPrixTotals().add(prixTotal);
		prixTotal.setPorte(this);

		return prixTotal;
	}

	public PrixTotal removePrixTotal(PrixTotal prixTotal) {
		getPrixTotals().remove(prixTotal);
		prixTotal.setPorte(null);

		return prixTotal;
	}

}