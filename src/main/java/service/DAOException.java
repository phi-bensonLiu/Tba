package service;

public class DAOException extends Exception {
	private String message = null;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
		this.message = message;
	}

	public DAOException(Throwable cause) {
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
