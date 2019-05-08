package sr03.utc.fr;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.AutoClimatiseur;
import model.BoiteVitesse;
import model.Couleur;
import model.Finition;
import model.Motorisation;
import model.Navigateur;
import model.SiegeCuir;
import model.Voiture;

@Stateless
public class Requete implements RequeteLocal {

	@PersistenceContext(name = "SR03_JPA")
	EntityManager em;

    public Requete() {

    }

    @SuppressWarnings("unchecked")
	public List<Voiture> getVoitures()
    {
    		Query q = em.createQuery("select v from Voiture v");
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Finition> getFinitions()
    {
    		Query q = em.createQuery("select f from Finition f");
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Motorisation> getMotorisations()
    {
    		Query q = em.createQuery("select m from Motorisation m");
    		
		return q.getResultList();
    }

    @SuppressWarnings("unchecked")
	public List<BoiteVitesse> getBoiteVitesses()
    {
    		Query q = em.createQuery("select bv from BoiteVitesse bv");
		
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Couleur> getCouleurs()
    {
    		Query q = em.createQuery("select c from Couleur c");
		
		return q.getResultList();
    }
    
    // afficher les choix selon un choix
    
    @SuppressWarnings("unchecked")
	public List<Motorisation> getMotorisationByVoiture(int vid)
    {
    		Query q = em.createQuery("select m "
       				+ "from Voiture v "
       				+ "join v.motorisations m "
       				+ "where v.idVoiture=:vid");
    		
    		q.setParameter("vid", vid);
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<BoiteVitesse> getBoiteVitesseByVoiture(int vid)
    {
    		Query q = em.createQuery("select bv "
       				+ "from Voiture v "
       				+ "join v.boiteVitesses bv "
       				+ "where v.idVoiture=:vid");
    		
    		q.setParameter("vid", vid);
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Couleur> getCouleurByVoiture(int vid)
    {
    		Query q = em.createQuery("select c "
       				+ "from Voiture v "
       				+ "join v.couleurs c "
       				+ "where v.idVoiture=:vid");
    		
    		q.setParameter("vid", vid);
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Finition> getFinitionByVoiture(int vid)
    {
    		Query q = em.createQuery("select f "
       				+ "from Voiture v "
       				+ "join v.finitions f "
       				+ "where v.idVoiture=:vid");
    		
    		q.setParameter("vid", vid);
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<BoiteVitesse> getBoiteVitesseByMotorisation(int mid)
    {
   		Query q = em.createQuery("select bv "
   				+ "from Voiture v "
   				+ "join v.boiteVitesses bv "
   				+ "join v.motorisations m "
   				+ "where m.idMotorisation=:mid");
   		
   		q.setParameter("mid", mid);
	
   		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<Motorisation> getMotorisationByBoiteVitesse(int bvid)
    {
   		Query q = em.createQuery("select m "
   				+ "from Voiture v "
   				+ "join v.boiteVitesses bv "
   				+ "join v.motorisations m "
   				+ "where bv.idBoiteVitesse=:bvid");
   		
   		q.setParameter("bvid", bvid);
	
   		return q.getResultList();
    }
    
    // afficher les modeles
    
    @SuppressWarnings("unchecked")
   	public List<Voiture> getVoitureByMotorisation(int mid)
    {
   		Query q = em.createQuery("select v "
   				+ "from Voiture v "
   				+ "join v.motorisations m "
   				+ "where m.idMotorisation=:mid");
   		
   		q.setParameter("mid", mid);
	
   		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<Voiture> getVoitureByBoiteVitesse(int bvid)
    {
   		Query q = em.createQuery("select v "
   				+ "from Voiture v "
   				+ "join v.boiteVitesses bv "
   				+ "where bv.idBoiteVitesse=:bvid");
   		
   		q.setParameter("bvid", bvid);
	
   		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<SiegeCuir> getScByFinition(int fid)
    {
   		Query q = em.createQuery("select sc "
   				+ "from Finition f "
   				+ "join f.siegeCuirs sc "
   				+ "where f.idFinition=:fid");
   		
   		q.setParameter("fid", fid);
	
   		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<AutoClimatiseur> getAcByFinition(int fid)
    {
   		Query q = em.createQuery("select ac "
   				+ "from Finition f "
   				+ "join f.autoClimatiseurs ac "
   				+ "where f.idFinition=:fid");
   		
   		q.setParameter("fid", fid);
	
   		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<Navigateur> getNaviByFinition(int fid)
    {
   		Query q = em.createQuery("select navi "
   				+ "from Finition f "
   				+ "join f.navigateurs navi "
   				+ "where f.idFinition=:fid");
   		
   		q.setParameter("fid", fid);
	
   		return q.getResultList();
    }
    
    // condition intervale
    @SuppressWarnings("unchecked")
   	public List<Voiture> getVoitureByPrixbase(int pmin, int pmax)
    {
   		Query q = em.createQuery("select v from Voiture v where v.prixBase between :pmin and :pmax");
   		q.setParameter("pmax", pmax);
   		q.setParameter("pmin", pmin);
	
   		return q.getResultList();
    }

    

}
