package cn.withmes.common.exception;

/**
 * @Description:Manager层异常类
 * @param:
 * @return:
 * @auther: liming
 * @date: 2018/5/19 11:11
 */
public class ControllerException extends Exception {

	private static final long serialVersionUID = 356381812673914209L;

	private int errorCode;

	public ControllerException() {
	}

	public ControllerException(String msg) {
		super(msg);
	}

	public ControllerException(Throwable cause) {
		super(cause);
	}

	public ControllerException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ControllerException(int code, String msg) {
		super(msg);
		this.errorCode = code;
	}

	public ControllerException(int code, String msg, Throwable cause) {
		super(msg, cause);
		this.errorCode = code;
	}

	public int getErrorCode() {
		return this.errorCode;
	}
}
