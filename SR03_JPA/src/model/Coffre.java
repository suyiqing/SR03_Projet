package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Coffre database table.
 * 
 */
@Entity
@NamedQuery(name="Coffre.findAll", query="SELECT c FROM Coffre c")
public class Coffre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCoffre;

	private String coffre;

	//bi-directional many-to-one association to PrixTotal
	@OneToMany(mappedBy="coffreBean")
	private List<PrixTotal> prixTotals;

	public Coffre() {
	}

	public int getIdCoffre() {
		return this.idCoffre;
	}

	public void setIdCoffre(int idCoffre) {
		this.idCoffre = idCoffre;
	}

	public String getCoffre() {
		return this.coffre;
	}

	public void setCoffre(String coffre) {
		this.coffre = coffre;
	}

	public List<PrixTotal> getPrixTotals() {
		return this.prixTotals;
	}

	public void setPrixTotals(List<PrixTotal> prixTotals) {
		this.prixTotals = prixTotals;
	}

	public PrixTotal addPrixTotal(PrixTotal prixTotal) {
		getPrixTotals().add(prixTotal);
		prixTotal.setCoffreBean(this);

		return prixTotal;
	}

	public PrixTotal removePrixTotal(PrixTotal prixTotal) {
		getPrixTotals().remove(prixTotal);
		prixTotal.setCoffreBean(null);

		return prixTotal;
	}

}