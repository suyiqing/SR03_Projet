package fr.utc.dsi.pia.edt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

@ManagedBean
@ViewScoped
public class GestVoiture {
	
	/*--------- montant ---------*/
	private MontantTemplate montant;

	/*-------- voiture ---------*/
	private List<VoitureTemplate> voitureTemplate;
	private HashSet<String> marque = new HashSet<String>();
	private HashSet<String> modele = new HashSet<String>();
	private String marquechosen="";
	private String modelechosen="";
	
	/*-------- motorisation ---------*/
	private List<MotorisationTemplate> motorisationTemplate = new ArrayList<MotorisationTemplate>();
	private List<MotorisationTemplate> motoByVoiture = new ArrayList<MotorisationTemplate>();
	private HashSet<String> motorisation = new HashSet<String>();
	private String motorisationchosen="";
	
	/*-----------boite vitesse----------*/
	private List<BoiteVitesseTemplate> boiteVitesseTemplate = new ArrayList<BoiteVitesseTemplate>();
	private List<BoiteVitesseTemplate> bvByVoiture = new ArrayList<BoiteVitesseTemplate>();
	private HashSet<String> boitevitesse = new HashSet<String>();
	private String boitevitessechosen="";
	
	/*-----------couleur----------*/
	private List<CouleurTemplate> couleurTemplate = new ArrayList<CouleurTemplate>();
	private List<CouleurTemplate> coulByVoiture = new ArrayList<CouleurTemplate>();
	private HashSet<String> couleur = new HashSet<String>();
	private String couleurchosen="";
	
	/*-----------Finition---------*/
	private List<FinitionTemplate> finitionTemplate = new ArrayList<FinitionTemplate>();
	private List<FinitionTemplate> finiByVoiture = new ArrayList<FinitionTemplate>();
	private HashSet<String> finition = new HashSet<String>();
	private String jante = new String();
	private String finitionchosen="";

	/*--------options---------*/
	private List<AutoClimatiseurTemplate> autoclimByFinition = new ArrayList<AutoClimatiseurTemplate>();
	private String typeClim = new String("Choose your finition");
	private List<NavigateurTemplate> navigateurByFinition = new ArrayList<NavigateurTemplate>();
	private String navigateur = new String("Choose your finition");
	private List<String> options = new ArrayList<String>();
	private int prix1 = 0;
	private int prix2 = 0;
	
	//test
	private String test = new String("test");
	
	@PostConstruct
	public void init()
	{
		//montant
		this.setMontant(new MontantTemplate());
		
		// voiture
		this.setVoitureTemplate(new ArrayList<VoitureTemplate>());
		
		Client client = ClientBuilder.newClient();
		
		this.setVoitureTemplate(client.target("http://localhost:8080/SR03_REST/voiture/voitures")
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<VoitureTemplate>>() {}));
		
		for (VoitureTemplate voiture : this.voitureTemplate) { 		      
	       this.marque.add(voiture.getMarque());
		}
		
	}
	
	/* --------- change Marque ---------- */
	public void ChangeMarque(AjaxBehaviorEvent event) {
		
		if(this.modele != null) {this.modele.clear();}
		if(this.motorisation != null) {this.motorisation.clear();}
		if(this.boitevitesse != null) {this.boitevitesse.clear();}
		if(this.couleur != null) {this.couleur.clear();}
		if(this.finition != null) {this.finition.clear();}
		if(this.options != null) {this.options.clear();}
		if(this.autoclimByFinition != null) {this.autoclimByFinition.clear();}
		if(this.navigateurByFinition != null) {this.navigateurByFinition.clear();}
		this.motorisationchosen = "";
		this.boitevitessechosen = "";
		this.couleurchosen = "";
		this.finitionchosen = "";
		this.jante = "";
		this.typeClim = "Choose your finition";
		this.navigateur = "Choose your finition";
		
		if(this.marquechosen != null)
		{
			if(this.modelechosen != null) {
				this.modelechosen = "";
				this.montant.init();
			}
			for(VoitureTemplate voiture : this.voitureTemplate) {
				if(this.marquechosen.equals(voiture.getMarque())) {
					this.modele.add(voiture.getModele());
				}
			}
		}
		else {
			this.montant.init();
			this.setModelechosen("");
		}
	}
	
	
	/* --------- Fonctions aident Change Modele ---------- */
	public void ChangeMotorisationByModele(String vid) {
		
		Client client = ClientBuilder.newClient();
		this.setMotoByVoiture(client.target("http://localhost:8080/SR03_REST/voiture/getMotorisationByVoiture")
				.queryParam("vid", vid)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<MotorisationTemplate>>() {}));

		for(MotorisationTemplate mbv : this.motoByVoiture) {
			this.motorisation.add(mbv.getMotorisation());
		}
	}
	
	public void ChangeBoiteVitesseByModele(String vid) {
		
		Client client = ClientBuilder.newClient();
		//change boite vitesse
		this.setBvByVoiture(client.target("http://localhost:8080/SR03_REST/voiture/getBoiteVitesseByVoiture")
				.queryParam("vid", vid)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<BoiteVitesseTemplate>>() {}));
		for(BoiteVitesseTemplate bv : this.bvByVoiture) {
			this.boitevitesse.add(bv.getBoitevitesse());
		}
		
	}
	
	public void ChangeCouleurByModele(String vid) {
		
		Client client = ClientBuilder.newClient();
		//change couleur
		this.setCoulByVoiture(client.target("http://localhost:8080/SR03_REST/voiture/getCouleurByVoiture")
				.queryParam("vid", vid)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<CouleurTemplate>>() {}));
		for(CouleurTemplate c : this.coulByVoiture) {
			this.couleur.add(c.getCouleur());
		}
		
	}
	
	public void ChangeFinitionByModele(String vid) {
		
		Client client = ClientBuilder.newClient();
		//change finition
		this.setFiniByVoiture(client.target("http://localhost:8080/SR03_REST/voiture/getFinitionByVoiture")
				.queryParam("vid", vid)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<FinitionTemplate>>() {}));
		for(FinitionTemplate fini : this.finiByVoiture) {
			this.finition.add(fini.getNomFinition());
		}
		
	}
	/* --------- End Fonctions aident Change Modele ---------- */
	
	/* --------- Change Modele ---------- */
	public void ChangeModele(AjaxBehaviorEvent event) {
		
		String vid = new String();

		if(this.motorisation != null) {this.motorisation.clear();}
		if(this.boitevitesse != null) {this.boitevitesse.clear();}
		if(this.couleur != null) {this.couleur.clear();}
		if(this.finition != null) {this.finition.clear();}
		if(this.options != null) {this.options.clear();}
		this.motorisationchosen = "";
		this.boitevitessechosen = "";
		this.couleurchosen = "";
		this.finitionchosen = "";
		this.jante = "";
		this.typeClim = "Choose your finition";
		this.navigateur = "Choose your finition";
		
		if(this.modelechosen != null){
			
			//get the vid
			for(VoitureTemplate voiture : this.voitureTemplate) {
				if(this.marquechosen.equals(voiture.getMarque()) && this.modelechosen.equals(voiture.getModele())) {
					vid = voiture.getIdVoiture();
					this.montant.setPrixbase(Integer.valueOf(voiture.getPrixBase()));
				}
			}
			
			// change motorisation
			this.ChangeMotorisationByModele(vid);
			
			//change boite vitesse
			this.ChangeBoiteVitesseByModele(vid);
			
			//change couleur
			this.ChangeCouleurByModele(vid);
			
			//change finition
			this.ChangeFinitionByModele(vid);
			
		}
		else {
			this.montant.init();
		}
	}
	
	
	/* --------- Change Motorisation ---------- */
	public void ChangeMotorisation(AjaxBehaviorEvent event) {
		if(this.motorisationchosen != null) {
			for(MotorisationTemplate mbv : this.motoByVoiture) {
				if(this.motorisationchosen.equals(mbv.getMotorisation())) {
					this.montant.setPrixMotorisation(Integer.valueOf(mbv.getPrixMotorisation()));
				}
			}	
		}
		else {
			this.montant.setPrixMotorisation(0);
		}
	}
	
	public void ChangeBoiteVitesse(AjaxBehaviorEvent event) {
		if(this.boitevitessechosen != null) {
			for(BoiteVitesseTemplate bvbv : this.bvByVoiture) {
				if(this.boitevitessechosen.equals(bvbv.getBoitevitesse())) {
					this.montant.setPrixBoitevitesse(Integer.valueOf(bvbv.getPrixBoitevitesse()));
				}
			}
		}
		else {
			this.montant.setPrixBoitevitesse(0);
		}
	}
	
	/* --------- Change Couleur ---------- */
	public void ChangeCouleur(AjaxBehaviorEvent event) {
		
		if(this.couleurchosen != null) {
			for(CouleurTemplate cbv : this.coulByVoiture) {
				if(this.couleurchosen.equals(cbv.getCouleur())) {
					this.montant.setPrixCouleur(Integer.valueOf(cbv.getPrixCouleur()));
				}
			}
		}
		else {
			this.montant.setPrixCouleur(0);
		}
	}
	
	/* --------- Fonctions aident Change Finition ---------- */
	public void OptionAutoClim(String fid) {
		
		Client client = ClientBuilder.newClient();
		//get info auto climatiseur
		this.setAutoclimByFinition(client.target("http://localhost:8080/SR03_REST/voiture/getAcByFinition")
				.queryParam("fid", fid)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<AutoClimatiseurTemplate>>() {}));
		
		if(!this.autoclimByFinition.isEmpty())
		{
			if(this.autoclimByFinition.get(0).getAutoclimatiseur().equals("1"))
			{
				setTypeClim("Auto air-conditionner");
			}
			else
			{
				setTypeClim("Air-conditionner");	
			}
			this.setPrix1(Integer.valueOf(this.autoclimByFinition.get(0).getPrix()));
		}
		else {
			setTypeClim("No option for air-conditionner");
			this.setPrix1(0);
		}
		
	}
	
	public void OptionNavigateur(String fid) {
		
		Client client = ClientBuilder.newClient();
		//get info auto navigateur
		this.setNavigateurByFinition(client.target("http://localhost:8080/SR03_REST/voiture/getNaviByFinition")
				.queryParam("fid", fid)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<NavigateurTemplate>>() {}));
		
		if(!this.navigateurByFinition.isEmpty())
		{
			this.setNavigateur(this.navigateurByFinition.get(0).getNavigateur());
			this.setPrix2(Integer.valueOf(this.navigateurByFinition.get(0).getPrix()));
		}
		else {
			this.setNavigateur("No option for navigateur");
			this.setPrix2(0);
		}
		
	}
	/* --------- End Fonctions aident Change Finition ---------- */
	
	/* --------- Change Finition ---------- */
	public void ChangeFinition(AjaxBehaviorEvent event) {
		
		String fid = new String();

		if(this.options != null) {this.options.clear();}
		if(this.autoclimByFinition != null) {this.autoclimByFinition.clear();}
		if(this.navigateurByFinition != null) {this.navigateurByFinition.clear();}
		
		if(this.finitionchosen != null) {
			for(FinitionTemplate fbv : this.finiByVoiture) {
				if(this.finitionchosen.equals(fbv.getNomFinition())) {
					fid = fbv.getIdFinition();
					this.setJante(fbv.getJante());
					this.montant.setPrixFinition(Integer.valueOf(fbv.getPrixFinition()));
				}
			}

			// option AutoClimatiseur
			OptionAutoClim(fid);

			//option Navigateur
			OptionNavigateur(fid);
			
		}
		else {
			this.montant.setPrixFinition(0);
			this.jante = "";
			this.typeClim = "Choose your finition";
			this.navigateur = "Choose your finition";
			this.prix1 = 0;
			this.prix2 = 0;
		}
	}
	
	/* --------- Change Prix Options ---------- */
	public void ChangeOptionsPrice(AjaxBehaviorEvent event) {
		
		this.montant.setPrixOption1(0);
		this.montant.setPrixOption2(0);
		
		if(this.options.contains("Auto air-conditionner")) {
			this.montant.setPrixOption1(this.prix1);
		}
		else if(this.options.contains("Air-conditionner")) {
			this.montant.setPrixOption1(this.prix1);
		}
		
		if(this.options.contains(this.navigateur)){
			this.montant.setPrixOption2(this.prix2);
		}

	}
	
	/*---------------- setter & getter -----------------*/
	
	public List<VoitureTemplate> getVoitureTemplate() {
		return voitureTemplate;
	}

	public void setVoitureTemplate(List<VoitureTemplate> voitureTemplate) {
		this.voitureTemplate = voitureTemplate;
	}

	public HashSet<String> getMarque() {
		return this.marque;
	}

	public void setMarque(HashSet<String> marque) {
		this.marque = marque;
	}

	public HashSet<String> getModele() {
		return this.modele;
	}

	public void setModele(HashSet<String> modele) {
		this.modele = modele;
	}
	
	public String getMarquechosen() {
		return marquechosen;
	}

	public void setMarquechosen(String marquechosen) {
		this.marquechosen = marquechosen;
	}

	public String getModelechosen() {
		return modelechosen;
	}

	public void setModelechosen(String modelechosen) {
		this.modelechosen = modelechosen;
	}

	public List<MotorisationTemplate> getMotorisationTemplate() {
		return motorisationTemplate;
	}

	public void setMotorisationTemplate(List<MotorisationTemplate> motorisationTemplate) {
		this.motorisationTemplate = motorisationTemplate;
	}

	public List<MotorisationTemplate> getMotoByVoiture() {
		return motoByVoiture;
	}

	public void setMotoByVoiture(List<MotorisationTemplate> motoByVoiture) {
		this.motoByVoiture = motoByVoiture;
	}

	public HashSet<String> getMotorisation() {
		return motorisation;
	}

	public void setMotorisation(HashSet<String> motorisation) {
		this.motorisation = motorisation;
	}

	public String getMotorisationchosen() {
		return motorisationchosen;
	}

	public void setMotorisationchosen(String motorisationchosen) {
		this.motorisationchosen = motorisationchosen;
	}



	public List<BoiteVitesseTemplate> getBoiteVitesseTemplate() {
		return boiteVitesseTemplate;
	}



	public void setBoiteVitesseTemplate(List<BoiteVitesseTemplate> boiteVitesseTemplate) {
		this.boiteVitesseTemplate = boiteVitesseTemplate;
	}



	public HashSet<String> getBoitevitesse() {
		return boitevitesse;
	}



	public void setBoitevitesse(HashSet<String> boitevitesse) {
		this.boitevitesse = boitevitesse;
	}



	public String getBoitevitessechosen() {
		return boitevitessechosen;
	}



	public void setBoitevitessechosen(String boitevitessechosen) {
		this.boitevitessechosen = boitevitessechosen;
	}



	public List<BoiteVitesseTemplate> getBvByVoiture() {
		return bvByVoiture;
	}



	public void setBvByVoiture(List<BoiteVitesseTemplate> bvByVoiture) {
		this.bvByVoiture = bvByVoiture;
	}



	public List<CouleurTemplate> getCouleurTemplate() {
		return couleurTemplate;
	}



	public void setCouleurTemplate(List<CouleurTemplate> couleurTemplate) {
		this.couleurTemplate = couleurTemplate;
	}



	public List<CouleurTemplate> getCoulByVoiture() {
		return coulByVoiture;
	}



	public void setCoulByVoiture(List<CouleurTemplate> coulByVoiture) {
		this.coulByVoiture = coulByVoiture;
	}



	public HashSet<String> getCouleur() {
		return couleur;
	}



	public void setCouleur(HashSet<String> couleur) {
		this.couleur = couleur;
	}



	public String getCouleurchosen() {
		return couleurchosen;
	}

	public void setCouleurchosen(String couleurchosen) {
		this.couleurchosen = couleurchosen;
	}

	public List<FinitionTemplate> getFinitionTemplate() {
		return finitionTemplate;
	}

	public void setFinitionTemplate(List<FinitionTemplate> finitionTemplate) {
		this.finitionTemplate = finitionTemplate;
	}

	public List<FinitionTemplate> getFiniByVoiture() {
		return finiByVoiture;
	}

	public void setFiniByVoiture(List<FinitionTemplate> finiByVoiture) {
		this.finiByVoiture = finiByVoiture;
	}

	public HashSet<String> getFinition() {
		return finition;
	}

	public void setFinition(HashSet<String> finition) {
		this.finition = finition;
	}

	public String getFinitionchosen() {
		return finitionchosen;
	}

	public void setFinitionchosen(String finitionchosen) {
		this.finitionchosen = finitionchosen;
	}

	public String getTypeClim() {
		return typeClim;
	}

	public void setTypeClim(String typeClim) {
		this.typeClim = typeClim;
	}

	public List<AutoClimatiseurTemplate> getAutoclimByFinition() {
		return autoclimByFinition;
	}

	public void setAutoclimByFinition(List<AutoClimatiseurTemplate> autoclimByFinition) {
		this.autoclimByFinition = autoclimByFinition;
	}

	public List<NavigateurTemplate> getNavigateurByFinition() {
		return navigateurByFinition;
	}

	public void setNavigateurByFinition(List<NavigateurTemplate> navigateurByFinition) {
		this.navigateurByFinition = navigateurByFinition;
	}

	public int getPrix1() {
		return prix1;
	}

	public void setPrix1(int prix1) {
		this.prix1 = prix1;
	}

	public int getPrix2() {
		return prix2;
	}

	public void setPrix2(int prix2) {
		this.prix2 = prix2;
	}

	public String getNavigateur() {
		return navigateur;
	}

	public void setNavigateur(String navigateur) {
		this.navigateur = navigateur;
	}
	
	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public MontantTemplate getMontant() {
		return montant;
	}

	public void setMontant(MontantTemplate montant) {
		this.montant = montant;
	}

	public String getJante() {
		return jante;
	}

	public void setJante(String jante) {
		this.jante = jante;
	}
}
