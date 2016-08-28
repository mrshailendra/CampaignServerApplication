package adServerApplication.expectionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import adServerApplication.exceptions.ActiveCampaignFoundException;
import adServerApplication.model.ErrorMessage;

@Provider
public class ActiveCampaignFoundExceptionMapper  implements ExceptionMapper<ActiveCampaignFoundException>{

	@Override
	public Response toResponse(ActiveCampaignFoundException exception) {
		ErrorMessage errMessage = new ErrorMessage(exception.getMessage(),
				999, "http://myCustomeErrorCode.html");
		return Response.status(999)
		.entity(errMessage)
		.build();
		
	}

	

}
