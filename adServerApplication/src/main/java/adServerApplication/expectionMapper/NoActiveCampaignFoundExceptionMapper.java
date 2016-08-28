package adServerApplication.expectionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import adServerApplication.exceptions.NoActiveCampaignFoundException;
import adServerApplication.model.ErrorMessage;
@Provider
public class NoActiveCampaignFoundExceptionMapper implements ExceptionMapper<NoActiveCampaignFoundException> {

	@Override
	public Response toResponse(NoActiveCampaignFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(),
				998, "http://myCustomResponseCode.html");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage).build();
	}

}
