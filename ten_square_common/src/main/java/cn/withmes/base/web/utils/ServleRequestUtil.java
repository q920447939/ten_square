package cn.withmes.base.web.utils;

/**
 * @desc Servlet请求工具类
 * @author liming
 * @date 2015年8月18日 下午6:13:43
 * 
 */
public class ServleRequestUtil {
/*

	private static Logger logger = LoggerFactory.getLogger(ServleRequestUtil.class);

	public static String getRequestContent(HttpServletRequest request) {
		String remoteAddr = ServletUtils.getIpAddr(request);
		logger.info("接收到客户端url:{}", remoteAddr + request.getRequestURI());
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			request.setCharacterEncoding("UTF-8");
			StringBuffer sb = new StringBuffer();
			is = request.getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			br = new BufferedReader(isr);
			String str = "";
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			return sb.toString();
		} catch (Exception e) {
			logger.info("读取手机客户端数据异常", e);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (Exception e2) {
				logger.info("接收手机客户端信息后，释放资源异常", e2);
			}

		}
		return null;
	}

	*/
/**
	 * 直接发送消息对象
	 *
	 * @param rsp
	 * @param msgOut 待发送的消息对象
	 *//*

	public static void send(HttpServletResponse rsp, String msgOut) {

		logger.info("回应客户端,参数：{}", msgOut);
		rsp.setCharacterEncoding("UTF-8");
		rsp.setContentType("text/html;charset=UTF-8");
		OutputStreamWriter ow = null;
		ServletOutputStream servletOut = null;
		try {
			servletOut = rsp.getOutputStream();
			ow = new OutputStreamWriter(servletOut, "UTF-8");
			ow.write(msgOut);
		} catch (IOException e) {
			logger.info("向手机客户端发送信息异常", e);
		} finally {
			try {
				if (ow != null) {
					ow.close();
				}
				if (servletOut != null) {
					servletOut.close();
				}

			} catch (IOException e) {
				logger.info("向手机客户端发送信息后，释放资源异常", e);
			}
		}
	}
*/

}
