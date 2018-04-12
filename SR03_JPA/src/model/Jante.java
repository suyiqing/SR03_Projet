package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Jante database table.
 * 
 */
@Entity
@NamedQuery(name="Jante.findAll", query="SELECT j FROM Jante j")
public class Jante implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idJante;

	@Column(name="type_jante")
	private String typeJante;

	//bi-directional many-to-one association to PrixTotal
	@OneToMany(mappedBy="janteBean")
	private List<PrixTotal> prixTotals;

	public Jante() {
	}

	public int getIdJante() {
		return this.idJante;
	}

	public void setIdJante(int idJante) {
		this.idJante = idJante;
	}

	public String getTypeJante() {
		return this.typeJante;
	}

	public void setTypeJante(String typeJante) {
		this.typeJante = typeJante;
	}

	public List<PrixTotal> getPrixTotals() {
		return this.prixTotals;
	}

	public void setPrixTotals(List<PrixTotal> prixTotals) {
		this.prixTotals = prixTotals;
	}

	public PrixTotal addPrixTotal(PrixTotal prixTotal) {
		getPrixTotals().add(prixTotal);
		prixTotal.setJanteBean(this);

		return prixTotal;
	}

	public PrixTotal removePrixTotal(PrixTotal prixTotal) {
		getPrixTotals().remove(prixTotal);
		prixTotal.setJanteBean(null);

		return prixTotal;
	}

}