package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Finition database table.
 * 
 */
@Entity
@NamedQuery(name="Finition.findAll", query="SELECT f FROM Finition f")
public class Finition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idFinition;

	private String jante;

	@Column(name="nom_finition")
	private String nomFinition;

	@Column(name="prix_finition")
	private int prixFinition;

	//bi-directional many-to-one association to AutoClimatiseur
	@OneToMany(mappedBy="finitionBean")
	private List<AutoClimatiseur> autoClimatiseurs;

	//bi-directional many-to-one association to Voiture
	@ManyToOne
	@JoinColumn(name="voiture")
	private Voiture voitureBean;

	//bi-directional many-to-one association to Navigateur
	@OneToMany(mappedBy="finitionBean")
	private List<Navigateur> navigateurs;

	//bi-directional many-to-one association to SiegeCuir
	@OneToMany(mappedBy="finitionBean")
	private List<SiegeCuir> siegeCuirs;

	public Finition() {
	}

	public int getIdFinition() {
		return this.idFinition;
	}

	public void setIdFinition(int idFinition) {
		this.idFinition = idFinition;
	}

	public String getJante() {
		return this.jante;
	}

	public void setJante(String jante) {
		this.jante = jante;
	}

	public String getNomFinition() {
		return this.nomFinition;
	}

	public void setNomFinition(String nomFinition) {
		this.nomFinition = nomFinition;
	}

	public int getPrixFinition() {
		return this.prixFinition;
	}

	public void setPrixFinition(int prixFinition) {
		this.prixFinition = prixFinition;
	}

	public List<AutoClimatiseur> getAutoClimatiseurs() {
		return this.autoClimatiseurs;
	}

	public void setAutoClimatiseurs(List<AutoClimatiseur> autoClimatiseurs) {
		this.autoClimatiseurs = autoClimatiseurs;
	}

	public AutoClimatiseur addAutoClimatiseur(AutoClimatiseur autoClimatiseur) {
		getAutoClimatiseurs().add(autoClimatiseur);
		autoClimatiseur.setFinitionBean(this);

		return autoClimatiseur;
	}

	public AutoClimatiseur removeAutoClimatiseur(AutoClimatiseur autoClimatiseur) {
		getAutoClimatiseurs().remove(autoClimatiseur);
		autoClimatiseur.setFinitionBean(null);

		return autoClimatiseur;
	}

	public Voiture getVoitureBean() {
		return this.voitureBean;
	}

	public void setVoitureBean(Voiture voitureBean) {
		this.voitureBean = voitureBean;
	}

	public List<Navigateur> getNavigateurs() {
		return this.navigateurs;
	}

	public void setNavigateurs(List<Navigateur> navigateurs) {
		this.navigateurs = navigateurs;
	}

	public Navigateur addNavigateur(Navigateur navigateur) {
		getNavigateurs().add(navigateur);
		navigateur.setFinitionBean(this);

		return navigateur;
	}

	public Navigateur removeNavigateur(Navigateur navigateur) {
		getNavigateurs().remove(navigateur);
		navigateur.setFinitionBean(null);

		return navigateur;
	}

	public List<SiegeCuir> getSiegeCuirs() {
		return this.siegeCuirs;
	}

	public void setSiegeCuirs(List<SiegeCuir> siegeCuirs) {
		this.siegeCuirs = siegeCuirs;
	}

	public SiegeCuir addSiegeCuir(SiegeCuir siegeCuir) {
		getSiegeCuirs().add(siegeCuir);
		siegeCuir.setFinitionBean(this);

		return siegeCuir;
	}

	public SiegeCuir removeSiegeCuir(SiegeCuir siegeCuir) {
		getSiegeCuirs().remove(siegeCuir);
		siegeCuir.setFinitionBean(null);

		return siegeCuir;
	}

}