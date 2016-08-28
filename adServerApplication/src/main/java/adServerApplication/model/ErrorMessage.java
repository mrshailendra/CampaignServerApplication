package adServerApplication.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private int errorCode;
	private String documentaion;
	
	public ErrorMessage()
	{
		
	}
	
	public ErrorMessage(String errorMessages, int errorCode,String documentation)
	{
		this.errorCode = errorCode;
		this.errorMessage =  errorMessages;
		this.documentaion = documentation;
		
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the documentaion
	 */
	public String getDocumentaion() {
		return documentaion;
	}

	/**
	 * @param documentaion the documentaion to set
	 */
	public void setDocumentaion(String documentaion) {
		this.documentaion = documentaion;
	}

}
