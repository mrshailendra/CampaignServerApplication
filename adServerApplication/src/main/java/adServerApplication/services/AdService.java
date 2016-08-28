/**
 * 
 */
package adServerApplication.services;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import adServerApplication.exceptions.ActiveCampaignFoundException;
import adServerApplication.exceptions.NoActiveCampaignFoundException;
import adServerApplication.localMemory.LocalMemory;
import adServerApplication.model.AdCampaign;

/**
 * @author shaimish
 *
 */
public class AdService {

	/**
	 * This method is used for creating a new Add
	 */

	public AdCampaign createAdCampaign(AdCampaign adCampaign) {

		AdCampaign returnTmpObject = null;

		// Check If this adCampaign add is Active or not

		if (!LocalMemory.isPartnerAdExist(adCampaign)) {

			System.out.println();
			adCampaign.setCreatedOn(Calendar.getInstance().getTime());
			LocalMemory.addCampaignValueInMap(adCampaign);
			returnTmpObject = LocalMemory.getAdCampaign(adCampaign);
			return returnTmpObject;

		} else {
			// AdCampaign partnerAdCampaign =
			// LocalMemory.getAdCampaign(adCampaign.getPartner_id());
			//
			// Date campaignDateOld = new
			// Date(partnerAdCampaign.getCreatedOn().getTime() +
			// (partnerAdCampaign.getDuration()*1000));
			// if(checkActiveCampaign(campaignDateOld))
			// {
			// throw new ActiveCampaignFoundException(
			// "Partner campaign is active, Pls try after sometime");
			// }
			throw new ActiveCampaignFoundException("Partner campaign is active, Pls try after sometime");
		}

	}

	/**
	 * 
	 */
	public AdCampaign getAdCampaignForPartner(String partnerId) {
		AdCampaign partnerAdCampaign = LocalMemory.getAdCampaign(partnerId);
		if(partnerAdCampaign != null)
		{
			System.out.println("Campaign Date Brfore Duration Add:-" + partnerAdCampaign.getCreatedOn());

			Date campaignDateOld = new Date(
					partnerAdCampaign.getCreatedOn().getTime() + (partnerAdCampaign.getDuration() * 1000));

			// Date currentDate = Calendar.getInstance().getTime();
			if (checkActiveCampaign(campaignDateOld)) {
				throw new NoActiveCampaignFoundException("no active ad campaigns exist for the specified partner");
			}
		}
		return partnerAdCampaign;

	}

	/**
	 * 
	 * @param existingCampaignDate
	 *            IF this campaign is Active return True
	 * @return
	 */
	public boolean checkActiveCampaign(Date existingCampaignDate) {
		System.out.println("Campaign Date :- " + existingCampaignDate);
		boolean activeFlag = false;
		Date currentDate = Calendar.getInstance().getTime();
		System.out.println("Current Date :- " + currentDate);
		if (existingCampaignDate.before(currentDate))
			activeFlag = true;
		return activeFlag;
	}

}
