package adServerApplication.expectionMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import adServerApplication.exceptions.NoCampaignDataFounException;
import adServerApplication.model.ErrorMessage;;
@Provider
public class NoCampaignDataFoundExceptionMapper implements ExceptionMapper<NoCampaignDataFounException> {

	@Override
	public Response toResponse(NoCampaignDataFounException exception) {
		ErrorMessage error = new ErrorMessage(exception.getMessage(),
				997,"Http://myResponseCode.html");
		return Response.status(Status.NOT_FOUND).entity(error).build();
		
	}

}
