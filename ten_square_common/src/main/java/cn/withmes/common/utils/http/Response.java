package cn.withmes.common.utils.http;

/**
 * ClassName: Response 
 * @Description: http响应类
 * @author liming
 * @date 2016年11月10日
 *
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *
 */
public class Response {
	
	private String status;
	private String message;
	
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
