/** 
 *@Project: common-common
 *@Author: leegoo
 *@Date: 2017年7月27日 
 * 
 */    
package cn.withmes.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: LoggerUtils 
 * @author leegoo
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
