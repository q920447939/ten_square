package cn.withmes.common.utils;

/**
 * DESC: 分布式主键生成器
 * @author leegoo
 * @DATE 2015年8月11日下午3:01:50
 * @version 0.1.0
 * 
 */
public class UuidUtils {
	
	/**
	 * Twitter_Snowflake ID生成器
	 */
	private static SnowflakeId snowflakeId = new SnowflakeId();
	
	/**
	 * @Description: 生成ID
	 * @return   
	 * @author leegoo
	 * @date 2018年4月13日
	 */
	public static String generate() {
		return String.valueOf(snowflakeId.nextId());
	}

	@Deprecated
	public static String getUuid(){
		return UUIDHexGenerator.generate();
	}
	
}
