package sr03.utc.fr;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.BoiteVitesse;
import model.Couleur;
import model.Finition;
import model.Motorisation;
import model.Voiture;


/**
 * Session Bean implementation class Requete
 */
@Stateless
public class Requete implements RequeteLocal {
	@PersistenceContext(name = "SR03_JPA")
	EntityManager em;
    
	// liste les options
	
    @SuppressWarnings("unchecked")
	public List<Finition> getFinitions()
    {
    		Query q = em.createQuery("select f from Finition f");
    		
    		return q.getResultList();
    }
	
    @SuppressWarnings("unchecked")
	public List<Motorisation> getMotorisations()
    {
    		Query q = em.createQuery("select DISTINCT(m.motorisation) from Motorisation m");
		
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<BoiteVitesse> getBoiteVitesses()
    {
    		Query q = em.createQuery("select DISTINCT(bv.boitevitesse) from BoiteVitesse bv");
		
		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Couleur> getCouleurs()
    {
    		Query q = em.createQuery("select DISTINCT(c.couleur) from Couleur c");
		
		return q.getResultList();
    }
    
    // afficher les choix selon un choix
    
    @SuppressWarnings("unchecked")
	public List<Motorisation> getMotorisationByVoiture(int vid)
    {
    		Query q = em.createQuery("select m "
       				+ "from Voiture v "
       				+ "join Motorisation m "
       				+ "where v.idVoiture=:vid ");
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<BoiteVitesse> getBoiteVitesseByVoiture(int vid)
    {
    		Query q = em.createQuery("select bv "
       				+ "from Voiture v "
       				+ "join BoiteVitesse bv "
       				+ "where v.idVoiture=:vid ");
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
	public List<Finition> getFinitionByVoiture(int vid)
    {
    		Query q = em.createQuery("select f "
       				+ "from Voiture v "
       				+ "join Finition f "
       				+ "where v.idVoiture=:vid ");
    		
    		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<BoiteVitesse> getBoiteVitesseByMotorisation(int mid)
    {
   		Query q = em.createQuery("select bv "
   				+ "from Voiture v "
   				+ "join BoiteVitesse bv "
   				+ "join Motorisation m "
   				+ "where m.idMotorisation=:mid ");
   		
   		q.setParameter("mid", mid);
	
   		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<Motorisation> getMotorisationByBoiteVitesse(int bvid)
    {
   		Query q = em.createQuery("select m "
   				+ "from Voiture v "
   				+ "join BoiteVitesse bv "
   				+ "join Motorisation m "
   				+ "where bv.idBoiteVitesse=:bvid ");
   		
   		q.setParameter("bvid", bvid);
	
   		return q.getResultList();
    }
    
    // afficher les modeles
    
    @SuppressWarnings("unchecked")
   	public List<Voiture> getVoitureByMotorisation(int mid)
    {
   		Query q = em.createQuery("select v "
   				+ "from Voiture v "
   				+ "join Motorisation m "
   				+ "where m.idMotorisation=:mid ");
   		
   		q.setParameter("mid", mid);
	
   		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<Voiture> getVoitureByBoiteVitesse(int bvid)
    {
   		Query q = em.createQuery("select v "
   				+ "from Voiture v "
   				+ "join BoiteVitesse bv "
   				+ "where bv.idBoiteVitesse=:bvid ");
   		
   		q.setParameter("bvid", bvid);
	
   		return q.getResultList();
    }
    
    // condition intervale
    
    @SuppressWarnings("unchecked")
   	public List<Voiture> getVoitureByPrixbase(int pmin, int pmax)
    {
   		Query q = em.createQuery("select v "
   				+ "from Voiture v "
   				+ "where v.prix_base "
   				+ "between pmin and pmax ");
   		q.setParameter("pmax", pmax);
   		q.setParameter("pmin", pmin);
	
   		return q.getResultList();
    }

}
