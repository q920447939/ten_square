/** 
 *@Project: base-common 
 *@Author: liming
 *@Date: 2017年7月27日 
 * 
 */    
package cn.withmes.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: LoggerUtils 
 * @author liming
 * @date 2017年7月27日
 *
 * =================================================================================================
 *     Task ID			  Date			     Author		      Description
 * ----------------+----------------+-------------------+-------------------------------------------
 *
 */

public class LoggerUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.class);
	
	public static Logger getLogger(){
		return logger;
	}

}
