package cn.withmes.common.utils.http;


/**
 * 
 * ClassName: HttpMethodFactory 
 * @Description: HTTP请求处理工厂
 * @author leegoo
 * @date 2016年11月10日
 *
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *
 */
public class HttpMethodFactory {

/*
	public static HttpMethod createMethod(String url, HttpType type, String contentType) {
		return createMethod(url, null, type, contentType);
	}
*/

/*	public static HttpMethod createMethod(String url, Object arg, HttpType type, String contentType) {
		HttpMethod hm = null;
		switch (type) {
			case PUT:
				hm = new PutMethod(url);
				break;
			case POST:
				hm = new PostMethod(url);
				break;
			case DELETE:
				hm = new DeleteMethod(url);
				break;
			case GET:
				hm = new GetMethod(url);
				break;
			default:
				break;
		}

		if (hm == null) {
			return null;
		}
		hm.addRequestHeader(new Header("Content-type", contentType));
		if (hm instanceof EntityEnclosingMethod) {
			String json = null;
			if (arg != null) {
				json = JsonMapper.toJson(arg);
			}
			EntityEnclosingMethod eem = (EntityEnclosingMethod) hm;
			eem.setRequestBody(json);
		}
		return hm;
	}*/
}