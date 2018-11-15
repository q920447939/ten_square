package cn.withmes.base.exception;

public class FatalSequenceException extends Exception {

	private static final long serialVersionUID = 1L;

	public FatalSequenceException(String message) {
		super(message);
	}

	public FatalSequenceException(String message, Throwable cause) {
		super(message, cause);
	}
}
