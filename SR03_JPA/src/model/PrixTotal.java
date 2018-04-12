package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PrixTotal database table.
 * 
 */
@Entity
@NamedQuery(name="PrixTotal.findAll", query="SELECT p FROM PrixTotal p")
public class PrixTotal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPrix;

	private int finition;

	@Column(name="prix_total")
	private int prixTotal;

	//bi-directional many-to-one association to Voiture
	@ManyToOne
	@JoinColumn(name="voiture")
	private Voiture voitureBean;

	//bi-directional many-to-one association to Motorisation
	@ManyToOne
	@JoinColumn(name="motorisation")
	private Motorisation motorisationBean;

	//bi-directional many-to-one association to BoiteVitesse
	@ManyToOne
	@JoinColumn(name="boitevitesse")
	private BoiteVitesse boiteVitesse;

	//bi-directional many-to-one association to Jante
	@ManyToOne
	@JoinColumn(name="jante")
	private Jante janteBean;

	//bi-directional many-to-one association to Porte
	@ManyToOne
	@JoinColumn(name="portes")
	private Porte porte;

	//bi-directional many-to-one association to Coffre
	@ManyToOne
	@JoinColumn(name="coffre")
	private Coffre coffreBean;

	//bi-directional many-to-one association to AutresDescription
	@ManyToOne
	@JoinColumn(name="autresdescriptions")
	private AutresDescription autresDescription;

	public PrixTotal() {
	}

	public int getIdPrix() {
		return this.idPrix;
	}

	public void setIdPrix(int idPrix) {
		this.idPrix = idPrix;
	}

	public int getFinition() {
		return this.finition;
	}

	public void setFinition(int finition) {
		this.finition = finition;
	}

	public int getPrixTotal() {
		return this.prixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Voiture getVoitureBean() {
		return this.voitureBean;
	}

	public void setVoitureBean(Voiture voitureBean) {
		this.voitureBean = voitureBean;
	}

	public Motorisation getMotorisationBean() {
		return this.motorisationBean;
	}

	public void setMotorisationBean(Motorisation motorisationBean) {
		this.motorisationBean = motorisationBean;
	}

	public BoiteVitesse getBoiteVitesse() {
		return this.boiteVitesse;
	}

	public void setBoiteVitesse(BoiteVitesse boiteVitesse) {
		this.boiteVitesse = boiteVitesse;
	}

	public Jante getJanteBean() {
		return this.janteBean;
	}

	public void setJanteBean(Jante janteBean) {
		this.janteBean = janteBean;
	}

	public Porte getPorte() {
		return this.porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	public Coffre getCoffreBean() {
		return this.coffreBean;
	}

	public void setCoffreBean(Coffre coffreBean) {
		this.coffreBean = coffreBean;
	}

	public AutresDescription getAutresDescription() {
		return this.autresDescription;
	}

	public void setAutresDescription(AutresDescription autresDescription) {
		this.autresDescription = autresDescription;
	}

}