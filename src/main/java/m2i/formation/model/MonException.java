package m2i.formation.model;

public class MonException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MonException() {
		super();
	}

	public MonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MonException(String message, Throwable cause) {
		super(message, cause);
	}

	public MonException(String message) {
		super(message);
	}

	public MonException(Throwable cause) {
		super(cause);
	}

}
