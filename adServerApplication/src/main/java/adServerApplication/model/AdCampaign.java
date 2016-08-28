/**
 * 
 */
package adServerApplication.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author shaimish
 *
 */
@XmlRootElement
public class AdCampaign {
	
	private String partner_id;
	private int duration;
	/**
	 * @return the ad_content
	 */
	public String getAd_content() {
		return ad_content;
	}
	/**
	 * @param ad_content the ad_content to set
	 */
	public void setAd_content(String ad_content) {
		this.ad_content = ad_content;
	}
	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}
	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	private String ad_content;
	private Date createdOn;
	/**
	 * @return the partner_id
	 */
	public String getPartner_id() {
		return partner_id;
	}
	/**
	 * @param partner_id the partner_id to set
	 */
	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}
	/**
	 * @return the duration for campain in int (seconds)
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	

}
