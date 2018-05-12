package sr03.utc.fr;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Stateless
@Path("/voiture")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")

public class MyWS {
	
	@EJB
	private RequeteLocal voiture;
	
	@GET
	@Path("/finitions")
    public Response getFinition()
    {
		return Response.ok(this.voiture.getFinitions()).build();
    }
	
	@GET
	@Path("/motorisations")
    public Response getMotorisation()
    {
		return Response.ok(this.voiture.getMotorisations()).build();
    }
	
	@GET
	@Path("/boitevitesses")
    public Response getBoiteVitesse()
    {
		return Response.ok(this.voiture.getBoiteVitesses()).build();
    }
	
	@GET
	@Path("/couleurs")
    public Response getCouleur()
    {
		return Response.ok(this.voiture.getCouleurs()).build();
    }
	
	
	
	@GET
	@Path("/getVoitureByMotorisation")
    public Response getVoitureByMotorisation(@QueryParam("mid") int mid)
    {
		return Response.ok(this.voiture.getVoitureByMotorisation(mid)).build();
    }
	
	@GET
	@Path("/getBoiteVitesseByMotorisation")
    public Response getBoiteVitesseByMotorisation(@QueryParam("mid") int mid)
    {
		return Response.ok(this.voiture.getBoiteVitesseByMotorisation(mid)).build();
    }
	
	
	
	
	@GET
	@Path("/getVoitureByPrixbase")
    public Response getVoitureByPrixTotal(@QueryParam("pmin") int pmin, @QueryParam("pmax") int pmax)
    {
		return Response.ok(this.voiture.getVoitureByPrixbase(pmin, pmax)).build();
    }

	
}
