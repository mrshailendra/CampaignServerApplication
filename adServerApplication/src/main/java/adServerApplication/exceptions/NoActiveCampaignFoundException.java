package adServerApplication.exceptions;

public class NoActiveCampaignFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4087259042870819688L;

	public NoActiveCampaignFoundException(String message){
		super(message);
	}
}
