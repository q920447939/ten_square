package cn.withmes.base.exception;

/**
 * DESC: RPC异常类
 * @DATE 2015年9月2日上午10:51:58
 */
public class RpcException extends Exception {
	private static final long serialVersionUID = 356381812673914209L;
	private int errorCode;
	private String projectName;

	public RpcException(String projectName, String msg) {
		super(msg);
		this.projectName = projectName;
	}

	public RpcException(String projectName, Throwable cause) {
		super(cause);
		this.projectName = projectName;
	}

	public RpcException(String projectName, String msg, Throwable cause) {
		super(msg, cause);
		this.projectName = projectName;
	}

	public RpcException(String projectName, int errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
		this.projectName = projectName;
	}

	public RpcException(int errorCode, String msg, String projectName,
			Throwable cause) {
		super(msg, cause);
		this.errorCode = errorCode;
		this.projectName = projectName;
	}

	public int getErrorCode() {
		return this.errorCode;
	}

	public String getProjectName() {
		return this.projectName;
	}
}
