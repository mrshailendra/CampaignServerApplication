package adServerApplication.resources;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import adServerApplication.exceptions.ActiveCampaignFoundException;
import adServerApplication.localMemory.LocalMemory;
import adServerApplication.model.AdCampaign;
import adServerApplication.services.AdService;

@Path("ad")
public class AdResorce {

	AdService adService = new AdService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AdCampaign> getAllAd() {
		return LocalMemory.getAllCampaign();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createNewCsampaign(AdCampaign adCampaign) {
		//System.out.println("************reaching request******************");
		AdCampaign newcreatedCampaign = adService.createAdCampaign(adCampaign);

		return Response.status(Status.CREATED).entity(newcreatedCampaign).build();

	}

	@GET
	@Path("{partner_id}")
	public Response featchAdCampaign(@PathParam("partner_id") String id) {
		System.out.println("**Hi I am data Found****");
		AdCampaign partnerAdCampaign = adService.getAdCampaignForPartner(id);
		
		return Response.status(Status.FOUND).entity(partnerAdCampaign).build();
	}
}
