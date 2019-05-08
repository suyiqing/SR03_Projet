package fr.utc.dsi.pia.edt;

public class VoitureTemplate {
	private String idVoiture;
	private String annee;
	private String coffre;
	private String marque;
	private String modele;
	private String portes;
	private String prixBase;
	
	public String getCoffre() {
		return coffre;
	}
	public void setCoffre(String coffre) {
		this.coffre = coffre;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getPortes() {
		return portes;
	}
	public void setPortes(String portes) {
		this.portes = portes;
	}
	public String getIdVoiture() {
		return idVoiture;
	}
	public void setIdVoiture(String idVoiture) {
		this.idVoiture = idVoiture;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getPrixBase() {
		return prixBase;
	}
	public void setPrixBase(String prixBase) {
		this.prixBase = prixBase;
	}

}
