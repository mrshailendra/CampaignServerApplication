package adServerApplication.adServerApplicationTest;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import adServerApplication.localMemory.LocalMemory;
import adServerApplication.model.AdCampaign;
import adServerApplication.services.AdService;
import junit.framework.Assert;

public class AdServiceTest {

	 AdCampaign adCampaign;
	 AdService adService;

	@Before
	public void setUp() throws Exception {
				adService = new AdService();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateAdCampaign() {
		//boolean beforeCreation = LocalMemory.isPartnerAdExist(adCampaign);
		adCampaign = new AdCampaign("TestABC",10,"This Ad is for test", 
				Calendar.getInstance().getTime());

		adService.createAdCampaign(adCampaign);
		
		boolean afterCalling = LocalMemory.isPartnerAdExist(adCampaign);
		Assert.assertEquals(true, afterCalling);
	}

	@Test
	public void testGetAdCampaignForPartner() {
		adCampaign = new AdCampaign("TestXYZ",100,"This Ad is for test", Calendar.getInstance().getTime());

		adService.createAdCampaign(adCampaign);
		AdCampaign adCampaignTmp = adService.getAdCampaignForPartner(adCampaign.getPartner_id());
		boolean condition = adCampaignTmp!= null && adCampaignTmp.getPartner_id()== adCampaign.getPartner_id();
		
		Assert.assertTrue(condition);	
		
	}

	@Test
	public void testCheckActiveCampaign() {
		fail("Not yet implemented"); // TODO
	}

}
