package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private String carburant;

	//bi-directional many-to-one association to PrixTotal
	@OneToMany(mappedBy="motorisationBean")
	private List<PrixTotal> prixTotals;

	public Motorisation() {
	}

	public int getIdMotorisation() {
		return this.idMotorisation;
	}

	public void setIdMotorisation(int idMotorisation) {
		this.idMotorisation = idMotorisation;
	}

	public String getCarburant() {
		return this.carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public List<PrixTotal> getPrixTotals() {
		return this.prixTotals;
	}

	public void setPrixTotals(List<PrixTotal> prixTotals) {
		this.prixTotals = prixTotals;
	}

	public PrixTotal addPrixTotal(PrixTotal prixTotal) {
		getPrixTotals().add(prixTotal);
		prixTotal.setMotorisationBean(this);

		return prixTotal;
	}

	public PrixTotal removePrixTotal(PrixTotal prixTotal) {
		getPrixTotals().remove(prixTotal);
		prixTotal.setMotorisationBean(null);

		return prixTotal;
	}

}