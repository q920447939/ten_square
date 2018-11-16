
package cn.withmes.common.utils;


import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 日期计算工具类
  * @author liming@haokukeji.com
  * @date 2018/5/8
  *
  * =================================================================================================
  *     Task ID			  Date			     Author		      Description
  * ----------------+----------------+-------------------+-------------------------------------------
 */
public class CalendarUtils {
    private static final Logger log = LoggerFactory.getLogger(CalendarUtils.class);

    /**
     * 一小时毫秒数
     */
    public static final long ONE_HOUR_MS = 3600 * 1000;
    /**
     * 一天毫秒数
     */
    public static final long ONE_DAY_MS = ONE_HOUR_MS * 24;

    private static final int[][] fields = {
            {Calendar.MILLISECOND}, {Calendar.SECOND}, {Calendar.MINUTE},
            {Calendar.HOUR_OF_DAY, Calendar.HOUR}, {Calendar.DAY_OF_MONTH, Calendar.DATE, Calendar.DAY_OF_YEAR, Calendar.DAY_OF_WEEK, Calendar.AM_PM},
            {Calendar.MONTH}, {Calendar.YEAR}, {Calendar.ERA}
    };

    /**
     * 计算周期时长结束时间点
     * @param startTime 开始时间点
     * @param period 周期表达式
     * @param isAfter 是否向后计算, true-向后计算, false-向前计算
     * @return 返回计算后结果, 如果period格式不正确或者为空，则返回null
     */
    public static Date calcPeroidEndTime(Date startTime, String period, boolean isAfter) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startTime);
        if (setPeriod(cal, period, isAfter)) {
            return cal.getTime();
        } else {
           return null;
        }
    }

    /**
     * 添加周期时间长
     * @param time 被添加的时间对象
     * @param period 添加周期
     * @param isAfter 是否向后计算，true-向后计算,false-向前计算
     * @return
     */
    public static boolean setPeriod(Calendar time, String period, boolean isAfter) {
        if (!isNormalPeriod(period)) {
            return false;
        }
        int start = 0;
        long timeInMillis = time.getTimeInMillis();
        boolean isPeriod = false;
        if (period.startsWith("P")) {
            start = 1;
            isPeriod = true;
        }
        try {
            char unit = period.charAt(period.length() - 1);
            if (unit >= '0' && unit <= '9') {
                int count = Integer.parseInt(period.substring(start));
                time.add(Calendar.DAY_OF_MONTH, isAfter ? count : -count);
                return true;
            }
            int field;
            switch (unit) {
                case 'Y': //年
                    field = Calendar.YEAR;
                    break;
                case 'M': //月
                    field = Calendar.MONTH;
                    break;
                case 'W': //周
                    field = Calendar.WEEK_OF_MONTH;
                    break;
                case 'D': //日
                    field = Calendar.DAY_OF_MONTH;
                    break;
                case 'H': //时
                    field = Calendar.HOUR_OF_DAY;
                    break;
                case 'I': //分
                    field = Calendar.MINUTE;
                    break;
                case 'S': //秒
                    field = Calendar.SECOND;
                    break;
                default:
                    log.info("无效表达式: " + period);
                    return false;
            }
            int count = Integer.parseInt(period.substring(start, period.length() - 1));
            if (isPeriod) {
                time.add(field, isAfter ? count : -count);
            } else if (count != 0) {
                truncate(time, field);
                if (isAfter) {
                    time.add(field,  count);
                    time.add(Calendar.SECOND, -1);
                } else {
                    time.add(field,  -count + 1);
                }
            }
        } catch (Exception e) {
            log.error("时间长度表达式（{}）无效", period, e);
            time.setTimeInMillis(timeInMillis);
            return false;
        }
        return true;
    }

    /**
     * 是否是正确的时长表达式, 2W, 3D
     * @param period
     * @return
     */
    public static boolean isNormalPeriod(String period) {
        if (StringUtils.isEmpty(period)) {
            return false;
        }
        int end = period.length();
        char unit = period.charAt(end - 1);
        if ("YMWDHIS".indexOf(unit) >= 0) {
            end --;
        }
        int start = period.startsWith("P") ? 1 : 0;
        if (start >= end) {
            return false;
        }
        for (int i = start; i < end; i ++) {
            char ch = period.charAt(i);
            if (ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * 时间截取, 只支持年月日时分秒
     * @param time 被截取的时间对象
     * @param field 截取粒度, Calendar相关常量
     */
    public static void truncate(Calendar time, int field) {
        if (time == null) {
            return;
        }
        if (field == Calendar.WEEK_OF_MONTH || field == Calendar.WEEK_OF_YEAR) {
            field = Calendar.DAY_OF_WEEK;
            time.set(field, time.getActualMinimum(field));
        }
        for (int i = 0; i < fields.length; ++ i) {
            if (!ArrayUtils.contains(fields[i], field)) {
                time.set(fields[i][0], time.getActualMinimum(fields[i][0]));
            }
        }
        throw new IllegalArgumentException("The field " + field + " is not supported");
    }


    /**
     * 时间截取, 只支持年月日时分秒
     * @param time 被截取的时间对象
     * @param field 截取粒度, Calendar相关常量
     */
    public static Date truncate(Date time, int field) {
        if (time == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        truncate(cal, field);
        return cal.getTime();
    }

}
