package cn.withmes.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 字符文本工具类
  * @author liming@haokukeji.com
  * @date 2018/5/7
  *
  * =================================================================================================
  *     Task ID			  Date			     Author		      Description
  * ----------------+----------------+-------------------+-------------------------------------------
 *
 */
public class TextUtils {
	
	private static final Logger LOG = LoggerFactory.getLogger(TextUtils.class);


	private static String[] PHONE_PREFIXES = null;



	/**
	 * 字符串值列表中是否包含该值
	 * @param valueList 字符串值列表(用','隔开各值)
	 * @param value 搜索的单个字符串值, 该值如果包含逗号','时总是返回false
	 * @return
	 */
	public static boolean containsValue(String valueList, String value) {
		return indexOfValue(valueList, value) >= 0;
	}

	/**
	 * 查询指定值在对应列表的位置， 第一个值的位置为0，第二个值为1...
	 * @param valueList 字符串值列表(用','隔开各值)
	 * @param value 搜索的单个字符串值, 该值如果包含逗号','时总是返回-1
	 * @return
	 */
	public static int indexOfValue(String valueList, String value) {
		return indexOfValue(valueList, value, true);
	}
	/**
	 * 查询指定值在对应列表中的值索引
	 * @param valueList 字符串值列表(用','隔开各值)
	 * @param value 搜索的单个字符串值, 该值如果包含逗号','时总是返回-1
	 * @param valueIndexOfList true-返回值在列表中的值索引，false-返回值在列表中的字符索引
	 * @return
	 */
	public static int indexOfValue(String valueList, String value, boolean valueIndexOfList) {
		if (valueList == null || value == null || value.indexOf(',') >= 0) {
			return -1;
		}
		if (valueList.startsWith(value)) {
			if (valueList.length() > value.length()  && valueList.charAt(value.length()) == ',') {
				return 0;
			} else if (valueList.length() == value.length()) {
				return 0;
			}
		}
		int count = 1;
		int index = valueList.indexOf(',') + 1;
		while (index > 0) {
			if (valueList.startsWith(value, index)) {
				int end = index + value.length();
				if (valueList.length() > end && valueList.charAt(end) == ',') {
					return valueIndexOfList ? count : index;
				} else if (valueList.length() == end) {
					return valueIndexOfList ? count : index;
				}
			}
			index = valueList.indexOf(',', index) + 1;
			count ++;
		}
		return -1;
	}

	/**
	 * 转化成list
	 * @param valueList
	 * @return
	 */
	public static List<String> asList(String valueList) {
		if (StringUtils.isEmpty(valueList)) {
			return Collections.emptyList();
		}
		List<String> result = new ArrayList<>();
		int startIndex = 0;
		int endIndex;
		while ((endIndex = valueList.indexOf(',', startIndex)) >= 0) {
			result.add(valueList.substring(startIndex, endIndex));
			startIndex = endIndex + 1;
		}
		result.add(valueList.substring(startIndex));
		return result;
	}

	/**
	 * 移除值列表中对应的第一个值, 如果不存在, 则不变
	 * @param valueList 字符串值列表(用','隔开各值)
	 * @param value 单个字符串值, 该值不能包含逗号',', 否则不作处理
	 * @return 返回移除后的值列表, 如果不变, 则返回原列表串对象
	 */
	public static String removeValue(String valueList, String value) {
		int start = indexOfValue(valueList, value, false);
		if (start > 0) {
			valueList = valueList.substring(0, start - 1) + valueList.substring(start + value.length());
			return valueList;
		}
		if (start == 0) {
			if (valueList.length() > value.length()) {
				valueList = valueList.substring(value.length() + 1);
			} else {
				valueList = "";
			}
		}
		return valueList;
	}

	/**
	 * 值列表中添加值, 如果已存在则不变
	 * @param valueList 字符串值列表(用','隔开各值)
	 * @param value 字符串值
	 * @return 返回添加后的值列表, 如果不变, 则返回原列表串对象
	 */
	public static String addValue(String valueList, String value) {
		if (value == null || value.length() == 0 || containsValue(valueList, value)) {
			return valueList;
		}
		if (valueList == null || valueList.length() == 0) {
			return value;
		}
		int start = indexOfValue(value, valueList, false);
		if (start == 0) {
			return value;
		}
		if (start > 0) {
			return new StringBuilder(valueList).append(",")
					.append(value, 0, start - 1)
					.append(value, start + valueList.length(), value.length())
					.toString();
		}
		return valueList + "," + value;
	}

	/**
	 * 获取值列表元素个数
	 * @param valueList
	 * @return
	 */
	public static int getSize(String valueList) {
		if (valueList == null || valueList.isEmpty()) {
			return 0;
		}
		int start = -1;
		int count = 1;
		while ((start = valueList.indexOf(',', start + 1)) >= 0) {
			count ++;
		}
		return count;
	}

	/**
	 * 获取指定位置的值, 如果列表是null或值索引大于列表元素个数,则返回null
	 * @param valueList 值列表
	 * @param valueIndex 值在列表中的值索引，从0开始，第一个值是0，第二个值是1,...
	 * @return
	 */
	public static String getValue(String valueList, int valueIndex) {
		if (valueList == null || valueIndex < 0) {
			return null;
		}
		int startIndex = 0;
		int endIndex;
		while ((endIndex = valueList.indexOf(',', startIndex)) >= 0) {
			if (valueIndex == 0) {
				break;
			}
			startIndex = endIndex + 1;
			valueIndex --;
		}
		if (valueIndex != 0) {
			return null;
		}
		if (endIndex >= 0) {
			return valueList.substring(startIndex, endIndex);
		} else {
			return valueList.substring(startIndex);
		}
	}



	/**
	 * 校验手机号是否合法
	 * @param phoneNum
	 * @return
	 */
	public static boolean isCellPhone(String phoneNum) {
		if (StringUtils.isBlank(phoneNum)) {
			return false;
		}
		if (phoneNum.length() != 11) { //号码不是11位
			return false;
		}
		for (int i = 0, len = phoneNum.length(); i < len; i++) {
			char ch = phoneNum.charAt(i);
			if (ch < '0' || ch > '9') { //含有非数字字符
				return false;
			}
		}
		String[] prefixes = PHONE_PREFIXES;
		if (prefixes == null || prefixes.length == 0) { //如果没有配置前缀
			return true;
		}
		for (int i = 0; i < prefixes.length; i++) {
			if (phoneNum.startsWith(prefixes[i])) { //是前缀之一
				return true;
			}
		}
		return false;
	}




}
