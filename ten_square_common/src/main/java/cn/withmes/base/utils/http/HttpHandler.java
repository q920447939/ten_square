package cn.withmes.base.utils.http;


/**
 * ClassName: HttpHandler 
 * @Description: HTTP请求处理类
 * @author liming
 * @date 2016年11月10日
 *
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *
 */
public class HttpHandler {
	
	/*public static Logger logger = LoggerFactory.getLogger(HttpHandler.class);

	private HttpClient httpClient;
	
	private HttpMethod httpMethod;
	//默认编码
	private static final String DEFAULT_ENCODE = "UTF-8";
	//默认传输文本类型
	private static final String DEFAULT_CONTENTTYPE = "application/json";
	//默认连接超时时间,默认为3s
	private static final int DEFAULT_CONNECTION_TIMEOUT = 6000;	
	
	//http 设置文本编码
	private String encode;
	//http请求URL
	private String url;
	//http 请求参数对象
	private Object arg;
	//http 请求类型
	private HttpType type;
	//http 请求设置类型
	private String contentType;
	//http 请求超时时间
	private int timeOut;
	
	public HttpHandler(String url,HttpType type){
		this(url,null,type);
	}
	
	public HttpHandler(String url,Object arg,HttpType type){
		this(url,arg,type,null);
	}
	
	public HttpHandler(String url,Object arg,HttpType type,String contentType){
		this(url,arg,type,contentType,null);
	}
	
	public HttpHandler(String url,Object arg,HttpType type,String contentType,String encode){
		this(url,arg,type,contentType,encode,0);
	}
	
	public HttpHandler(String url,Object arg,HttpType type,String contentType,String encode,int timeOut){
		this.url = url;
		this.arg = arg;
		this.type = type;
		if(contentType == null) {
			this.contentType = DEFAULT_CONTENTTYPE;
		}
		if(encode == null) {
			this.encode = DEFAULT_ENCODE;
		}
		if(timeOut == 0) {
			this.timeOut = DEFAULT_CONNECTION_TIMEOUT;
		}
	}
	
	*//**
	 * 请求处理
	 * @return   
	 * @author liming
	 * @date 2017年3月28日
	 *//*
	public String processRequest(){
		initHttpClient();
		initHttpMethod();
		//处理请求
		String result = processHandle();
		//关闭连接
		this.closeConnection();
		return result;
	}
	
	*//**
	 * 关闭连接  
	 *//*
	private void closeConnection() {
		this.httpClient.getHttpConnectionManager().closeIdleConnections(0);
	}

	*//**
	 * 初始化连接
	 *//*
	private void initHttpClient(){
		this.httpClient = new HttpClient();
		this.httpClient.getParams().setContentCharset(this.encode);
		//设置连接超时时间
		this.httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(this.timeOut);
	}
	

	private void initHttpMethod(){
		this.httpMethod = HttpMethodFactory.createMethod(url, arg, type, contentType);
	}
	
	*//**
	 * 处理请求
	 *//*
	protected String processHandle(){
		try {
			int state = this.httpClient.executeMethod(this.httpMethod);
			if(state != 200){
				return processResult(Response.FAILURE,"http请求失败，返回状态码：" + state);
			}
			return this.httpMethod.getResponseBodyAsString();
		} catch (Exception e) {
			logger.error("处理请求异常:{}",e);
			return processResult(Response.FAILURE,e.getMessage());
		} 
	}

	public String processResult(String status,String message){
		Response resp = new Response();
		resp.setStatus(status);
		resp.setMessage(message);
		return (new JsonMapper()).toJson(resp);
	}
	
	public HttpClient getHttpClient() {
		return httpClient;
	}


	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}


	public HttpMethod getHttpMethod() {
		return httpMethod;
	}


	public void setHttpMethod(HttpMethod httpMethod) {
		this.httpMethod = httpMethod;
	}


	public String getEncode() {
		return encode;
	}


	public void setEncode(String encode) {
		this.encode = encode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Object getArg() {
		return arg;
	}

	public void setArg(Object arg) {
		this.arg = arg;
	}

	public HttpType getType() {
		return type;
	}

	public void setType(HttpType type) {
		this.type = type;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}*/
}
