package cn.withmes.base.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

	private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
			"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "HH:mm" };

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd）
	 */
	public static String getDate() {
		return getDate("yyyy-MM-dd");
	}

	/**
	 * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String getDate(String pattern) {
		return DateFormatUtils.format(new Date(), pattern);
	}

	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	public static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String formatDateTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前时间字符串 格式（HH:mm:ss）
	 */
	public static String getTime() {
		return formatDate(new Date(), "HH:mm:ss");
	}

	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 得到当前年份字符串 格式（yyyy）
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 得到当前月份字符串 格式（MM）
	 */
	public static String getMonth() {
		return formatDate(new Date(), "MM");
	}

	/**
	 * 得到当天字符串 格式（dd）
	 */
	public static String getDay() {
		return formatDate(new Date(), "dd");
	}

	/**
	 * 得到当前星期字符串 格式（E）星期几
	 */
	public static String getWeek() {
		return formatDate(new Date(), "E");
	}

	/**
	 * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	 * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm" }
	 */
	public static Date parseDate(Object str) {
		if (str == null) {
			return null;
		}
		try {
			return parseDate(str.toString(), parsePatterns);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 获取过去的天数
	 * 
	 * @param date
	 * @return
	 */
	public static long pastDays(Date date) {
		long time = new Date().getTime() - date.getTime();
		return time / (24 * 60 * 60 * 1000);
	}

	public static Date getDateStart(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 00:00:00");
		} catch (ParseException e) {
			logger.error("getDateStart错误", e);
		}
		return date;
	}

	public static Date getDateEnd(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(formatDate(date, "yyyy-MM-dd") + " 23:59:59");
		} catch (ParseException e) {
			logger.error("getDateEnd错误", e);
		}
		return date;
	}

	/**
	 * @Description: 获取时间的年/月/周的第一时间</br>
	 *               Calendar.DAY_OF_YEAR(本年的开始时间) 2018-01-01 00:00:00</br>
	 *               Calendar.DAY_OF_MONTH(本月的开始时间) 2018-05-01 00:00:00</br>
	 *               Calendar.DAY_OF_WEEK(本周的开始时间) 2018-05-07 00:00:00</br>
	 *               Calendar.HOUR_OF_DAY(今日的开始时间) 2018-05-09 00:00:00</br>
	 *               Calendar.HOUR(本小时的开始时间) 2018-05-09 15:00:00(默认)
	 * @param date
	 * @param field
	 * @return
	 * @author liming
	 * @date 2018年5月10日
	 */
	public static Date getFirstDate(Date date, int field) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.set(Calendar.MINUTE, 0);
		cld.set(Calendar.SECOND, 0);
		switch (field) {
		case Calendar.DAY_OF_YEAR:// 年
			cld.set(Calendar.HOUR_OF_DAY, 0);
			cld.set(Calendar.DAY_OF_YEAR, 1);
			break;
		case Calendar.DAY_OF_MONTH:// 月
			cld.set(Calendar.HOUR_OF_DAY, 0);
			cld.set(Calendar.DAY_OF_MONTH, 1);
			break;
		case Calendar.DAY_OF_WEEK:// 周,每周的开始第一天是周日,所以这里需要设为第二天
			cld.set(Calendar.HOUR_OF_DAY, 0);
			cld.set(Calendar.DAY_OF_WEEK, 2);
			break;
		case Calendar.HOUR_OF_DAY:
			cld.set(Calendar.HOUR_OF_DAY, 0);
			break;
		default:
			break;
		}
		return cld.getTime();
	}

	/**
	 * @Description: 获取时间的年/月/周的结束时间</br>
	 *               Calendar.DAY_OF_YEAR(本年最终时间) 2018-12-31 23:59:59</br>
	 *               Calendar.DAY_OF_MONTH(本月最终时间)2018-05-31 23:59:59</br>
	 *               Calendar.DAY_OF_WEEK(本周日最终时间)2018-05-13 23:59:59</br>
	 *               Calendar.HOUR_OF_DAY(今日最终时间) 2018-05-09 23:59:59</br>
	 *               Calendar.DAY_OF_YEAR(此小时最终时间)2018-05-09 15:59:59(默认)
	 * @param date
	 * @param field
	 * @return
	 * @author liming
	 * @date 2018年5月10日
	 */
	public static Date getLastDate(Date date, int field) {
		Calendar cld = Calendar.getInstance();
		cld.setTime(date);
		cld.set(Calendar.MINUTE, cld.getActualMaximum(Calendar.MINUTE));
		cld.set(Calendar.SECOND, cld.getActualMaximum(Calendar.SECOND));
		switch (field) {
		case Calendar.DAY_OF_YEAR:// 年
			cld.set(Calendar.HOUR_OF_DAY, cld.getActualMaximum(Calendar.HOUR_OF_DAY));
			cld.set(Calendar.DAY_OF_YEAR, cld.getActualMaximum(Calendar.DAY_OF_YEAR));
			break;
		case Calendar.DAY_OF_MONTH:// 月
			cld.set(Calendar.HOUR_OF_DAY, cld.getActualMaximum(Calendar.HOUR_OF_DAY));
			cld.set(Calendar.DAY_OF_MONTH, cld.getActualMaximum(Calendar.DAY_OF_MONTH));
			break;
		case Calendar.DAY_OF_WEEK:// 周,每周的最后一天默认是周六,所以需要在周六再加一天
			cld.set(Calendar.HOUR_OF_DAY, cld.getActualMaximum(Calendar.HOUR_OF_DAY));
			cld.set(Calendar.DAY_OF_WEEK, 7);
			cld.add(Calendar.DAY_OF_MONTH, 1);
			break;
		case Calendar.HOUR_OF_DAY:
			cld.set(Calendar.HOUR_OF_DAY, cld.getActualMaximum(Calendar.HOUR_OF_DAY));
			break;
		default:
			break;
		}
		return cld.getTime();
	}

	/**
	 * 判断字符串是否是日期
	 * 
	 * @param timeString
	 * @return
	 */
	public static boolean isDate(String timeString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);
		try {
			format.parse(timeString);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 格式化时间
	 * 
	 * @param timestamp
	 * @return
	 */
	public static String dateFormat(Date timestamp) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(timestamp);
	}

	/**
	 * 获取系统时间Timestamp
	 * 
	 * @return
	 */
	public static Timestamp getSysTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 获取系统时间Date
	 * 
	 * @return
	 */
	public static Date getSysDate() {
		return new Date();
	}

	/**
	 * 生成时间随机数
	 * 
	 * @return
	 */
	public static String getDateRandom() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}

	/**
	 * 日期大小比较
	 * 
	 * @param startDate
	 *            开始日期时间
	 * @param endDate
	 *            结束日期时间
	 * @return 返回结果 endDate大于startDate，返回大于0
	 */
	public static Integer compareDate(Date startDate, Date endDate) {
		Integer flag = 0;
		if (startDate.getTime() > endDate.getTime()) {
			flag = -1;
		} else if (startDate.getTime() < endDate.getTime()) {
			flag = 1;
		} else {
			flag = 0;
		}
		return flag;

	}

	/**
	 * 比较两个日期相差的天数(以24小时计算)
	 *
	 * @param beginDate
	 *            开始日期
	 * @param endDate
	 *            结束日期
	 * @return 相差天数
	 */
	public static int getIntervalDays(Date beginDate, Date endDate) {
		if (null == beginDate || null == endDate) {
			return -1;
		}

		long intervalMilli = endDate.getTime() - beginDate.getTime();
		return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	}

	/**
	 * 
	 * @Description: 获取两个日期相差的天数(以日期的开始时间计算)
	 * @param smdate
	 * @param bdate
	 * @return
	 * @author liming
	 * @date 2018年5月10日
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		smdate = getFirstDate(smdate, Calendar.HOUR_OF_DAY);
		bdate = getFirstDate(bdate, Calendar.HOUR_OF_DAY);
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
}
