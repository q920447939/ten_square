package cn.withmes.common.exception;

/**
 * @Description:参数验证层异常类
 * @param:
 * @return:
 * @auther: liming
 * @date: 2018/5/19 11:11
 */
public class ValidateErrorException extends RuntimeException {

	private static final long serialVersionUID = 356381812673914209L;

	private int errorCode;

	public ValidateErrorException() {
	}

	public ValidateErrorException(String msg) {
		super(msg);
	}

	public ValidateErrorException(Throwable cause) {
		super(cause);
	}

	public ValidateErrorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ValidateErrorException(int code, String msg) {
		super(msg);
		this.errorCode = code;
	}

	public ValidateErrorException(int code, String msg, Throwable cause) {
		super(msg, cause);
		this.errorCode = code;
	}

	public int getErrorCode() {
		return this.errorCode;
	}
}
