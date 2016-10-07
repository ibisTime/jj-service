package com.cdkj.service.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static final String DB_DATE_FORMAT_STRING = "yyyyMMdd";

    public static final String FRONT_DATE_FORMAT_STRING = "yyyy-MM-dd";

    public static final String DATA_TIME_PATTERN_1 = "yyyy-MM-dd HH:mm:ss";

    public static final String DATA_TIME_PATTERN_2 = "yyyy-MM-dd HH:mm";

    public static final String DATA_TIME_PATTERN_3 = "yyyyMMDDhhmmss";

    public static final String DATA_TIME_PATTERN_4 = "yyyyMMDDhhmmss";

    public static final String DATA_TIME_PATTERN_5 = "yyyyMMddHHmmssSSS";

    public static final String DATA_TIME_PATTERN_6 = "yyyy年MM月dd日";

    public static final String TIME_BEGIN = " 00:00:00";

    public static final String TIME_MIDDLE = " 12:00:00";

    public static final String TIME_END = " 23:59:59";

    public static Date getEndDatetime(String inputRepayDate) {
        Date repayDatetime = DateUtil.strToDate(inputRepayDate
                + DateUtil.TIME_END, DateUtil.DATA_TIME_PATTERN_1);
        return repayDatetime;
    }

    public static Date getRelativeDate(Date startDate, int second) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(startDate);
            calendar.add(Calendar.SECOND, second);
            return calendar.getTime();
        } catch (Exception e) {
            return startDate;
        }
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.strToDate("2015-01-01",
            DateUtil.DATA_TIME_PATTERN_1));
    }

    /** 
     * Date按格式pattern转String
     * @param date
     * @param pattern
     * @return 
     * @create: 2015-4-18 下午11:02:34 miyb
     * @history: 
     */
    public static String dateToStr(Date date, String pattern) {
        String str = null;
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        try {
            str = formater.format(date);
        } catch (Exception e) {
        }
        return str;
    }

    /** 
     * 获取当天开始时间
     * @return 
     * @create: 2014-10-14 下午4:24:57 miyb
     * @history: 
     */
    public static Date getTodayStart() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        return (Date) currentDate.getTime().clone();
    }

    /** 
     * 获取当天结束时间
     * @return 
     * @create: 2014-10-14 下午4:24:57 miyb
     * @history: 
     */
    public static Date getTodayEnd() {
        Calendar currentDate = new GregorianCalendar();
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return (Date) currentDate.getTime().clone();
    }

    /**
     * 相对参数today的明日起始时刻。比如今天是11日23点，明日起始时刻为12日0点0分0秒
     * @param today
     * @return 
     * @create: 2015年11月16日 上午11:49:51 myb858
     * @history:
     */
    public static Date getTomorrowStart(Date today) {
        String str = dateToStr(today, FRONT_DATE_FORMAT_STRING);
        Date tommrow = getRelativeDate(
            strToDate(str, FRONT_DATE_FORMAT_STRING), 24 * 3600);
        return tommrow;
    }

    /** 
     * String 按格式pattern转Date
     * @param str
     * @param pattern
     * @return 
     * @create: 2015-4-18 下午11:02:34 miyb
     * @history: 
     */
    public static Date strToDate(String str, String pattern) {
        Date date = null;
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        try {
            date = formater.parse(str);
        } catch (Exception e) {
        }
        return date;
    }

    /**
     * 删除—
     * @param pattern
     * @return 
     * @create: 2015年10月27日 下午7:59:41 myb858
     * @history:
     */
    public static String remove_(String strDate) {
        String string = null;
        try {
            string = strDate.replace("-", "");
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return string;
    }

    /**
     * 按格式获取当前时间
     * @param pattern
     * @return 
     * @create: 2015-5-7 上午11:22:04 miyb
     * @history:
     */
    public static String getToday(String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date());
    }

    /**
     * 
     * @param date
     * @param addOneDay 是否加1天
     * @return 
     * @create: 2015-5-7 上午11:25:23 miyb
     * @history:
     */
    public static Date getFrontDate(String date, boolean addOneDay) {
        Date returnDate = null;
        try {
            returnDate = new SimpleDateFormat(FRONT_DATE_FORMAT_STRING)
                .parse(date);
            if (addOneDay) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(returnDate);
                calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
                returnDate = calendar.getTime(); // 这个时间就是日期往后推一天的结果
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return returnDate;
    }

    /**
     * 统计两个时间差，返回的是天数(即24小时算一天，少于24小时就为0，用这个的时候最好把小时、分钟等去掉)
     * @param beginStr 开始时间
     * @param endStr 结束时间
     * @param format 时间格式
     * @return
     */
    public static int daysBetween(String beginStr, String endStr, String format) {
        Date end = strToDate(endStr, format);
        Date begin = strToDate(beginStr, format);
        long times = end.getTime() - begin.getTime();
        return (int) (times / 60 / 60 / 1000 / 24);
    }

    /**
     * 统计两个时间差，返回的是天数(即24小时算一天，少于24小时就为0，用这个的时候最好把小时、分钟等去掉)
     * @param beginDate
     * @param endDate
     * @return 
     * @create: 2015年11月16日 上午11:20:51 myb858
     * @history:
     */
    public static int daysBetween(Date beginDate, Date endDate) {
        long times = endDate.getTime() - beginDate.getTime();
        return (int) (times / 60 / 60 / 1000 / 24);
    }
}
