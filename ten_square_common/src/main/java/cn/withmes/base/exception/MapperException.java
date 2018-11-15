package cn.withmes.base.exception;

public class MapperException extends Exception {
	private static final long serialVersionUID = 356381812673914209L;
	private int errorCode;

	public MapperException() {
	}

	public MapperException(String msg) {
		super(msg);
	}

	public MapperException(Throwable cause) {
		super(cause);
	}

	public MapperException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MapperException(int code, String msg) {
		super(msg);
		this.errorCode = code;
	}

	public MapperException(int code, String msg, Throwable cause) {
		super(code + ":" + msg, cause);
		this.errorCode = code;
	}

	public int getErrorCode() {
		return this.errorCode;
	}
}
