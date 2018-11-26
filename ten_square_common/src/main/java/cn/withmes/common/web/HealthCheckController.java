/** 
 *@Project: common-web
 *@Author: leegoo
 *@Date: 2017年1月7日 
 * 
 */    
package cn.withmes.common.web;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * ClassName: HealthCheckController 
 * 服务监控检测页面
 * @author leegoo
 * @date 2017年1月7日
 *
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *
 */
@Controller
@RestController
public class HealthCheckController extends BaseRestfulController{

	
	@RequestMapping("/health")
	@ResponseBody
	public Map<String,Object> health() {
		Map<String,Object> map = Maps.newHashMap();
		map.put("status", "UP");
		return map;
	}
	
	
}
