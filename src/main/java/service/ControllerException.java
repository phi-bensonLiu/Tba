package service;

public class ControllerException extends Exception{
	private String message = null;

	public ControllerException() {
		super();
	}

	public ControllerException(String message) {
		super(message);
		this.message = message;
	}

	public ControllerException(Throwable cause) {
		super(cause);
	}

	@Override
	public String toString() {
		return message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
