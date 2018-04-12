package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AutresDescriptions database table.
 * 
 */
@Entity
@Table(name="AutresDescriptions")
@NamedQuery(name="AutresDescription.findAll", query="SELECT a FROM AutresDescription a")
public class AutresDescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idDesc;

	private String description;

	//bi-directional many-to-one association to PrixTotal
	@OneToMany(mappedBy="autresDescription")
	private List<PrixTotal> prixTotals;

	public AutresDescription() {
	}

	public int getIdDesc() {
		return this.idDesc;
	}

	public void setIdDesc(int idDesc) {
		this.idDesc = idDesc;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PrixTotal> getPrixTotals() {
		return this.prixTotals;
	}

	public void setPrixTotals(List<PrixTotal> prixTotals) {
		this.prixTotals = prixTotals;
	}

	public PrixTotal addPrixTotal(PrixTotal prixTotal) {
		getPrixTotals().add(prixTotal);
		prixTotal.setAutresDescription(this);

		return prixTotal;
	}

	public PrixTotal removePrixTotal(PrixTotal prixTotal) {
		getPrixTotals().remove(prixTotal);
		prixTotal.setAutresDescription(null);

		return prixTotal;
	}

}