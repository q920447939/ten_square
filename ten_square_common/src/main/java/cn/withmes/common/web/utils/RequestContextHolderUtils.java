/** 
 *@Project: cool-common-web
 *@Author: liming
 *@Date: 2018年5月8日 
 *@Copyright: ©2018-2028 www.haokukeji.com Inc. All rights reserved. 
 */    
package cn.withmes.common.web.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: RequestContextHolderUtils 
 * @Description: 请求上下文工具栏
 * @author liming
 * @date 2018年5月8日
 */

public class RequestContextHolderUtils {

    /**
     * 上下文获取{@link HttpServletRequest}
     * @Author wanghong
     * @return
     */
    public static HttpServletRequest request() {
        HttpServletRequest request =
            ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 上下文获取{@link HttpServletResponse}
     * @Author wanghong
     * @return
     */
    public static HttpServletResponse response() {
        HttpServletResponse response =
            ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        return response;
    }
}
