package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BoiteVitesse database table.
 * 
 */
@Entity
@NamedQuery(name="BoiteVitesse.findAll", query="SELECT b FROM BoiteVitesse b")
public class BoiteVitesse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idBoiteV;

	private String boitev;

	//bi-directional many-to-one association to PrixTotal
	@OneToMany(mappedBy="boiteVitesse")
	private List<PrixTotal> prixTotals;

	public BoiteVitesse() {
	}

	public int getIdBoiteV() {
		return this.idBoiteV;
	}

	public void setIdBoiteV(int idBoiteV) {
		this.idBoiteV = idBoiteV;
	}

	public String getBoitev() {
		return this.boitev;
	}

	public void setBoitev(String boitev) {
		this.boitev = boitev;
	}

	public List<PrixTotal> getPrixTotals() {
		return this.prixTotals;
	}

	public void setPrixTotals(List<PrixTotal> prixTotals) {
		this.prixTotals = prixTotals;
	}

	public PrixTotal addPrixTotal(PrixTotal prixTotal) {
		getPrixTotals().add(prixTotal);
		prixTotal.setBoiteVitesse(this);

		return prixTotal;
	}

	public PrixTotal removePrixTotal(PrixTotal prixTotal) {
		getPrixTotals().remove(prixTotal);
		prixTotal.setBoiteVitesse(null);

		return prixTotal;
	}

}