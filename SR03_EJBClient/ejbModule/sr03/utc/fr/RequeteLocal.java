package sr03.utc.fr;

import java.util.List;

import javax.ejb.Local;

import model.AutoClimatiseur;
import model.BoiteVitesse;
import model.Couleur;
import model.Finition;
import model.Motorisation;
import model.Navigateur;
import model.SiegeCuir;
import model.Voiture;

@Local
public interface RequeteLocal {
	
	public List<Voiture> getVoitures();
	public List<Finition> getFinitions();
	public List<Motorisation> getMotorisations();
	public List<BoiteVitesse> getBoiteVitesses();
	public List<Couleur> getCouleurs();
	public List<Motorisation> getMotorisationByVoiture(int vid);
	public List<BoiteVitesse> getBoiteVitesseByVoiture(int vid);
	public List<Couleur> getCouleurByVoiture(int vid);
	public List<Finition> getFinitionByVoiture(int vid);
	public List<BoiteVitesse> getBoiteVitesseByMotorisation(int mid);
	public List<Motorisation> getMotorisationByBoiteVitesse(int bvid);
	public List<Voiture> getVoitureByMotorisation(int mid);
	public List<Voiture> getVoitureByBoiteVitesse(int bvid);
   	public List<SiegeCuir> getScByFinition(int fid);
   	public List<AutoClimatiseur> getAcByFinition(int fid);
   	public List<Navigateur> getNaviByFinition(int fid);
	public List<Voiture> getVoitureByPrixbase(int pmin, int pmax);
}
