package cn.withmes.common.utils;

import java.math.BigDecimal;

/**
 * ClassName: DataFormatUtil 
 * @Description: 基本数据类型格式化工具
 * @author leegoo
 * @date 2016年12月23日
 */
public class DataFormatUtil {
	
	/**
	 * 保留小数位数
	 */
	public static final Integer BIGDECIMAL_SCALE_NUM = 2;
	
	/**
	 * 四舍五入保留类型 1：直接删除多余的小数位
	 */
	public static final Integer BIGDECIMAL_SCALE_TYPE_ONE = 1;
	
	/**
	 * 四舍五入保留类型 2 ：进位处理
	 */
	public static final Integer BIGDECIMAL_SCALE_TYPE_TWO = 2;
	
	/**
	 * 四舍五入保留类型 3：四舍五入
	 */
	public static final Integer BIGDECIMAL_SCALE_TYPE_THREE = 3;
	
	/**
	 * 默认空字符串
	 */
	private static final String DEFAULT_NULL_STR = "";

	/**
	 * @Description: 格式化价格
	 * @param price 价格
	 * @return   
	 */
	public static String format(BigDecimal price){
		return format(price,BIGDECIMAL_SCALE_NUM,BIGDECIMAL_SCALE_TYPE_ONE);
	}
	
	/**
	 * @Description: 格式化价格参数
	 * @param price
	 * @param num
	 * @param type
	 */
	public static String format(BigDecimal price,Integer num, Integer type){
		if(price == null){
			return "0.00";
		}
		return priceConvertToString(price,num,type);
	}
	
	/**
	 * @Description: 格式化字符串
	 * @param str
	 * @return   
	 * @author leegoo
	 * @date 2016年12月23日
	 */
	public static String format(String str){
		return format(str,DEFAULT_NULL_STR);
	}
	
	/**
	 * @Description: 格式化字符串对象
	 * @param str
	 * @param defaultStr
	 */
	public static String format(String str,String defaultStr){
		return str == null ? defaultStr : str;
	}
	
	/**
	 * @Description: 格式化Integer
	 * @param intVal
	 */
	public static Integer format(Integer intVal){
		return intVal == null ? Integer.valueOf(0) : intVal;
	}
	
	/**
	 * 
	 * @Description: 价格字段的String转换
	 * @param obj Object 需要转换的值
	 * @param num Integer 保存的小数位数
	 * @param type Integer 保存小数的类型 1：直接删除多余的小数位 2：进位处理 3：四舍五入
	 * @return resultPrice  String
	 */
	public static String priceConvertToString(Object obj, Integer num, Integer type) {
		BigDecimal resultPrice = bigDecimalConvert(obj, num, type);
		if (resultPrice != null) {
			return resultPrice.toString();
		}
		return "";
	}
	
	/**
	 * 
	 * @Description: 价格字段的转换
	 * @param obj Object 需要转换的值
	 * @param num Integer 保存的小数位数
	 * @param type Integer 保存小数的类型 1：直接删除多余的小数位 2：进位处理 3：四舍五入
	 * @return priceDb  BigDecimal
	 */
	private static BigDecimal bigDecimalConvert(Object obj, Integer num, Integer type) {
		// 如果金额为空，默认为0展示
		String price = String.valueOf(obj);
		if (StringUtils.isBlank(price)) {
			price = BigDecimal.ZERO.toString();
		}
		BigDecimal priceDb = null;
		switch (type) {
			case 1:
				priceDb = new BigDecimal(price).setScale(num, BigDecimal.ROUND_DOWN);
				break;
			case 2:
				priceDb = new BigDecimal(price).setScale(num, BigDecimal.ROUND_UP);
				break;
			case 3:
				priceDb = new BigDecimal(price).setScale(num, BigDecimal.ROUND_HALF_UP);
				break;
			default:
				priceDb = new BigDecimal(price).setScale(num, BigDecimal.ROUND_DOWN);
				break;
		}
		return priceDb;
	}
	
	/**
	 * @Description: 格式化字符串
	 * @param str
	 */
	public static Integer parseInt(String str){
		String convertStr = format(str,DEFAULT_NULL_STR);
		return Integer.parseInt(convertStr);
	}
	
}
