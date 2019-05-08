package sr03.utc.fr;

//import java.util.List;

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
	@Path("/voitures")
    public Response getVoiture()
    {
		return Response.ok(this.voiture.getVoitures()).build();
    }
	
	@GET
	@Path("/getMotorisationByVoiture")
    public Response getMotorisationByVoiture(@QueryParam("vid") int vid)
    {
		return Response.ok(this.voiture.getMotorisationByVoiture(vid)).build();
    }
	
	@GET
	@Path("/getBoiteVitesseByVoiture")
    public Response getBoiteVitesseByVoiture(@QueryParam("vid") int vid)
    {
		return Response.ok(this.voiture.getBoiteVitesseByVoiture(vid)).build();
    }
	
	@GET
	@Path("/getCouleurByVoiture")
    public Response getCouleurByVoiture(@QueryParam("vid") int vid)
    {
		return Response.ok(this.voiture.getCouleurByVoiture(vid)).build();
    }
	
	@GET
	@Path("/getFinitionByVoiture")
    public Response getFinitionByVoiture(@QueryParam("vid") int vid)
    {
		return Response.ok(this.voiture.getFinitionByVoiture(vid)).build();
    }
	
	@GET
	@Path("/getAcByFinition")
    public Response getAcByFinition(@QueryParam("fid") int fid)
    {
		return Response.ok(this.voiture.getAcByFinition(fid)).build();
    }
	
	@GET
	@Path("/getNaviByFinition")
    public Response getNaviByFinition(@QueryParam("fid") int fid)
    {
		return Response.ok(this.voiture.getNaviByFinition(fid)).build();
    }
	
	
	
	
	
	
	// ------------- pas utilise ------------------
	
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
	@Path("/getBoiteVitesseByMotorisation")
    public Response getBoiteVitesseByMotorisation(@QueryParam("mid") int mid)
    {
		return Response.ok(this.voiture.getBoiteVitesseByMotorisation(mid)).build();
    }
	
	@GET
	@Path("/getMotorisationByBoiteVitesse")
    public Response getMotorisationByBoiteVitesse(@QueryParam("bvid") int bvid)
    {
		return Response.ok(this.voiture.getMotorisationByBoiteVitesse(bvid)).build();
    }
	
	@GET
	@Path("/getVoitureByMotorisation")
    public Response getVoitureByMotorisation(@QueryParam("mid") int mid)
    {
		return Response.ok(this.voiture.getVoitureByMotorisation(mid)).build();
    }
	
	@GET
	@Path("/getVoitureByBoiteVitesse")
    public Response getVoitureByBoiteVitesse(@QueryParam("bvid") int bvid)
    {
		return Response.ok(this.voiture.getVoitureByBoiteVitesse(bvid)).build();
    }
	
	@GET
	@Path("/getScByFinition")
    public Response getScByFinition(@QueryParam("fid") int fid)
    {
		return Response.ok(this.voiture.getScByFinition(fid)).build();
    }
	
	@GET
	@Path("/getVoitureByPrixbase")
    public Response getVoitureByPrixbase(@QueryParam("pmin") int pmin, @QueryParam("pmax") int pmax)
    {
		return Response.ok(this.voiture.getVoitureByPrixbase(pmin, pmax)).build();
    }
	
	
}
