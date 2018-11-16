package cn.withmes.common.exception;

public class SqlSessionServiceException extends ServiceException {

	private static final long serialVersionUID = 6962567129345583538L;

	public SqlSessionServiceException(String message, Exception cause) {
		super(message, cause);
	}

	public SqlSessionServiceException(String message) {
		super(message);
	}
}