package cn.withmes.base.web;



import cn.withmes.base.enums.ResultCode;
import cn.withmes.base.enums.ResultEnum;
import cn.withmes.base.mode.HeaderInfo;
import cn.withmes.base.mode.ResponseData;
import cn.withmes.base.web.utils.CustomDateEditorBase;
import cn.withmes.base.web.utils.RequestContextHolderUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 基础Controller
 * ClassName: BaseGeneralController 
 * @author liming
 * @date 2017年3月22日
 */
public abstract class BaseRestfulController {
	
    protected final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 返回数据封装
	 * @param data 消息内容
	 * @param result 消息code
	 * @return   Map
	 * @author liming
	 * @param <T>
	 * @date 2017年3月22日
	 */
    protected <T> ResponseData<T> resultData(T data, ResultEnum<Integer> result) {
		return ResponseData.builder(data, result);
	}
	/**
	 * 返回成功结果数据封装
	 * @param data 数据内容
	 * @return
	 * @author liming
	 * @param <T>
	 * @date 2017年3月22日
	 */
    protected <T> ResponseData<T> successData(T data) {
		return ResponseData.builder(data, ResultCode.SUCCESS);
	}
	
    protected <T> ResponseData<T> successData() {
        return ResponseData.builder(null, ResultCode.SUCCESS);
    }
	
	
	/**
	 * 转换所有Url请求参数到Bean
	 * @param request
	 * @return 入参Bean
	 * @author liming
	 */
/*	public RequestParams convertParams(HttpServletRequest request){
		Map<String, String[]> requestParameterMap = request.getParameterMap();
		Map<String, String> paramters = Maps.newHashMap();
        for (Entry<String, String[]> e : requestParameterMap.entrySet()) {  
            String key = e.getKey();  
            String[] v = e.getValue();  
            paramters.put(key, StringUtils.join(v, ","));
        } 
		paramters.put("ip", ServletUtils.getIpAddr(request));
        return BeanMapper.map(paramters, RequestParams.class);
	}*/
	
    /**
     * @Description: 获取请求header公共参数
     * @param request
     * @return
     * @author liming
     * @date 2018年4月24日
     */
    protected HeaderInfo getHeaderInfo(HttpServletRequest request) {
        HeaderInfo headerInfo = new HeaderInfo();
      /*  headerInfo.setClientId(request.getHeader(HeaderConstant.CLIENT_ID));
        headerInfo.setClientType(request.getHeader(HeaderConstant.CLIENT_TYPE));
        headerInfo.setClientAgent(request.getHeader(HeaderConstant.CLIENT_AGENT));
        headerInfo.setVersion(request.getHeader(HeaderConstant.VERSION));
        headerInfo.setScreen(request.getHeader(HeaderConstant.SCREEN));
        headerInfo.setToken(request.getHeader(HeaderConstant.TOKEN));
        headerInfo.setSign(request.getHeader(HeaderConstant.SIGN));*/
        return headerInfo;
    }

    /**
     * @Description: 获取请求header公共参数
     * @return
     * @author wanghong
     * @date 2018年4月24日
     */
    protected HeaderInfo getHeaderInfo() {
        return getHeaderInfo(request());
    }

    /**
     * @Description: 获取请求header自定义参数
     * @param name 自定义参数key
     * @author wanghong
     * @return
     */
    protected String getHeaderValue(String name) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        return request().getHeader(name);
    }

	@InitBinder
    public void initBinder(WebDataBinder binder) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditorBase(
                dateFormat, false));
        
        //String类型转换，将所有传递进来的String进行HTML编码，防止XSS攻击
 		binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
 			@Override
 			public void setAsText(String text) {
 				setValue(text == null ? null : 
 					StringEscapeUtils.escapeHtml4(text.trim()));
 			}
 			@Override
 			public String getAsText() {
 				Object value = getValue();
 				return value != null ? value.toString() : "";
 			}
 		});
    }
	
	
	public Map<String, Object> builderParams(HttpServletRequest request, Model model) {
		Map<String, Object> retParams = new HashMap<String,Object>(request.getParameterMap().size());
		Map<String, String[]> params = request.getParameterMap();
		if (null != params && params.size() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for (Entry<String, String[]> p : params.entrySet()) {
				if (null == p.getValue() || p.getValue().length == 0){
					continue;
				}
				// 只转换一个参数，多个参数不转换
				String[] values = (String[]) p.getValue();
				String match = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|"
						+ "[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})"
						+ "-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|"
						+ "[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
				if (values[0].matches(match)) {
					try {
						retParams.put(p.getKey(), sdf.parse(values[0]));
					} catch (ParseException e) {
						retParams.put(p.getKey(), values);
					}
				}else if(p.getKey().equals("queryCondition")&&model.asMap().containsKey("queryCondition")){
					retParams.put(p.getKey(), model.asMap().get("queryCondition"));
				} else {
					retParams.put(p.getKey(), values[0]);
				}
			}
		}
		return retParams;
	}

    /**
     * 上下文获取{@link HttpServletRequest}
     * 
     * @Author wanghong
     * @return
     */
    protected HttpServletRequest request() {
        return RequestContextHolderUtils.request();
    }

    /**
     * 上下文获取{@link HttpServletResponse}
     * 
     * @Author wanghong
     * @return
     */
    protected HttpServletResponse response() {
        return RequestContextHolderUtils.response();
    }

}
