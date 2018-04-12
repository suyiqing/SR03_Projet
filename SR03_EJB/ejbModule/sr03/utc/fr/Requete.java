package sr03.utc.fr;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
   	public List<Voiture> getVoitureByMotorisation(int mid)
    {
   		Query q = em.createQuery("select v "
   				+ "from Voiture v "
   				+ "join PrixTotal p "
   				+ "join Motorisation m "
   				+ "where p.motorisation=:mid"
   				+ "and p.voiture=:voiture.idVoiture");
   		
   		q.setParameter("mid", mid);
	
   		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<Voiture> getBoiteVitesseByMotorisation(int mid)
    {
   		Query q = em.createQuery("select b "
   				+ "from BoiteVitesse b "
   				+ "join PrixTotal p "
   				+ "join Motorisation m "
   				+ "where p.motorisation=:mid "
   				+ "and p.boitevitesse=:BoiteVitesse.idBoiteV ");
   		
   		q.setParameter("mid", mid);
	
   		return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
   	public List<Voiture> getVoitureByPrixTotal(int pmin, int pmax)
    {
   		Query q = em.createQuery("select v "
   				+ "from Voiture v "
   				+ "join PrixTotal p "
   				+ "where p.voiture=:Voiture.idVoiture "
   				+ "and p.prix_total "
   				+ "between pmin and pmax ");
   		q.setParameter("pmax", pmax);
   		q.setParameter("pmin", pmin);
	
   		return q.getResultList();
    }

}
