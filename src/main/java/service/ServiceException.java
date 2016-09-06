package service;

public class ServiceException extends Exception {
	private String message = null;
	
	public ServiceException(String message) {
		super(message);
		this.message = message;
	}
}
