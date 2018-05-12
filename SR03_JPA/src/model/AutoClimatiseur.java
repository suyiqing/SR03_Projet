package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AutoClimatiseur database table.
 * 
 */
@Entity
@NamedQuery(name="AutoClimatiseur.findAll", query="SELECT a FROM AutoClimatiseur a")
public class AutoClimatiseur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAutoClimatiseur;

	private byte autoclimatiseur;

	private int prix;

	//bi-directional many-to-one association to Finition
	@ManyToOne
	@JoinColumn(name="finition")
	private Finition finitionBean;

	public AutoClimatiseur() {
	}

	public int getIdAutoClimatiseur() {
		return this.idAutoClimatiseur;
	}

	public void setIdAutoClimatiseur(int idAutoClimatiseur) {
		this.idAutoClimatiseur = idAutoClimatiseur;
	}

	public byte getAutoclimatiseur() {
		return this.autoclimatiseur;
	}

	public void setAutoclimatiseur(byte autoclimatiseur) {
		this.autoclimatiseur = autoclimatiseur;
	}

	public int getPrix() {
		return this.prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Finition getFinitionBean() {
		return this.finitionBean;
	}

	public void setFinitionBean(Finition finitionBean) {
		this.finitionBean = finitionBean;
	}

}