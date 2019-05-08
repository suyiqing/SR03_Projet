package fr.utc.dsi.pia.edt;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class MontantTemplate {
	
	private int prixbase;
	private int prixCouleur;
	private int prixMotorisation;
	private int prixBoitevitesse;
	private int prixFinition;
	private int prixOption1;
	private int prixOption2;
	
	@PostConstruct
	public void init()
	{
		this.setPrixbase(0);
		this.setPrixCouleur(0);
		this.setPrixMotorisation(0);
		this.setPrixBoitevitesse(0);
		this.setPrixFinition(0);
		this.setPrixOption1(0);
		this.setPrixOption2(0);
	}
	
	public int Somme() {
		return this.prixbase + this.prixMotorisation + this.prixBoitevitesse + this.prixCouleur + this.prixFinition + this.prixOption1 + this.prixOption2;
	}

	public int getPrixbase() {
		return prixbase;
	}

	public void setPrixbase(int prixbase) {
		this.prixbase = prixbase;
	}

	public int getPrixCouleur() {
		return prixCouleur;
	}

	public void setPrixCouleur(int prixCouleur) {
		this.prixCouleur = prixCouleur;
	}

	public int getPrixMotorisation() {
		return prixMotorisation;
	}

	public void setPrixMotorisation(int prixMotorisation) {
		this.prixMotorisation = prixMotorisation;
	}

	public int getPrixBoitevitesse() {
		return prixBoitevitesse;
	}

	public void setPrixBoitevitesse(int prixBoitevitesse) {
		this.prixBoitevitesse = prixBoitevitesse;
	}

	public int getPrixFinition() {
		return prixFinition;
	}

	public void setPrixFinition(int prixFinition) {
		this.prixFinition = prixFinition;
	}

	public int getPrixOption1() {
		return prixOption1;
	}

	public void setPrixOption1(int prixOption1) {
		this.prixOption1 = prixOption1;
	}

	public int getPrixOption2() {
		return prixOption2;
	}

	public void setPrixOption2(int prixOption2) {
		this.prixOption2 = prixOption2;
	}

}
