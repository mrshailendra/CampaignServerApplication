package adServerApplication.exceptions;

public class NoCampaignDataFounException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6533649054911780669L;
	
	public NoCampaignDataFounException(String message)
	{
		super(message);
	}

}
