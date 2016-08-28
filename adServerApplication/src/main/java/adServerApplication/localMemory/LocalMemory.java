package adServerApplication.localMemory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;

import org.eclipse.persistence.internal.jpa.parsing.LogicalOperatorNode;

import adServerApplication.model.AdCampaign;

@Singleton
public class LocalMemory {
	
	public static int i=0;
	public static final Map<String,AdCampaign>AdCampaignMemoryMap =  new HashMap<String,AdCampaign>();
	public static LocalMemory localMemoryInstance;
//	private LocalMemory()
//	{
//		AdCampaignMemoryMap= new HashMap<String,AdCampaign>(); 
//	}
	
//	public static LocalMemory getInstance()
//	{
//		if(localMemoryInstance== null)
//			localMemoryInstance = new LocalMemory();
//		
//		return localMemoryInstance;
//	}
	/**
	 * @return the adCampaignMemoryMap
	 */
	public static Map<String, AdCampaign> getAdCampaignMemoryMap() {
		return AdCampaignMemoryMap;
	}
	
	public static int addCampaignValueInMap(AdCampaign adCampaign)
	{
		synchronized (LocalMemory.class) {
			getAdCampaignMemoryMap().put(adCampaign.getPartner_id(),adCampaign);
			return getAdCampaignMemoryMap().size();
		}
	}
	
	public static void removeCampaignValueInMap(AdCampaign adCampaign)
	{
		synchronized (LocalMemory.class) {
			getAdCampaignMemoryMap().remove(adCampaign).getPartner_id();
		}
	}
	
	public static boolean isPartnerAdExist(AdCampaign adCampaign)
	{
		synchronized (LocalMemory.class) {
			return getAdCampaignMemoryMap().containsKey(adCampaign.getPartner_id());
		}
		
	}
	
	public static List<AdCampaign> getAllCampaign()
	{
		List<AdCampaign> adCampaignList = null;
		synchronized (LocalMemory.class) {
			adCampaignList = new ArrayList<AdCampaign>();
		Iterator 	mapItrator = getAdCampaignMemoryMap().values().iterator();
			while(mapItrator.hasNext())
			{
				adCampaignList.add((AdCampaign)mapItrator.next());
			}
			
		}
		return adCampaignList;
	}

	public static AdCampaign getAdCampaign(AdCampaign adCampaign)
	{
		synchronized (LocalMemory.class) {
			
			return LocalMemory.getAdCampaignMemoryMap().get(adCampaign.getPartner_id());
		}
	}

	public static AdCampaign getAdCampaign(String partnerId) {
		synchronized (LocalMemory.class) {
			return LocalMemory.getAdCampaignMemoryMap().get(partnerId);
		}
		
	}
}
