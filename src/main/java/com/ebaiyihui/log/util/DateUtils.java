package com.ebaiyihui.log.util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @Description: 日期处理类
 * @author maden
 * @date 2016年12月9日 下午5:35:37
 */
public class DateUtils {
	
	 private final static String FULL_FORMAT = "yyyy-MM-dd HH:mm:ss";

	private final static String SIMPLE_FORMAT = "yyyy-MM-dd";

	private final static String FORMAT = "yyyyMMddHHmmss";
	
	private final static String SUB_HOURE_FORMAT = "yyyyMMddHH";
	
	private final static String TIME_FORMAT="HH:mm:ss";
	
	/** 
     * 得到几天前的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateBefore(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);  
        return now.getTime();  
    }    
    
    /** 
         *   得到几天后的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
	
    /**
     * 
     * @Description: 得到当前日期的=>   时:分:秒
     * @Tags: @return 
     * @throws
     * @Author MDH
     * @Date 2019年1月14日
     * @return String
     */
	public static String getCurrentTimeToString(){
		Calendar calendar=Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(TIME_FORMAT);
		return df.format(calendar.getTime());
	}
    
    /**
         * 得到 (Date类型的日期+N个月) 的日期Date类型  加法
     * @param date
     * @param month
     * @return
     */
    public static Date getAddMonth(Date date , int month){
    	 Calendar now = Calendar.getInstance();  
    	 now.setTime(date);
    	 now.add(Calendar.MONTH, month);
    	return now.getTime();
    }
    
    /**
     * 得到 (Date类型的日期-N个月) 的日期字符串   减法
     * @param date
     * @param month
     * @return
     */
    public static Date getSubtractMonth(Date date , int month){
    	 Calendar now = Calendar.getInstance();  
    	 now.setTime(date);
    	 now.add(Calendar.MONTH, -month);
    	return now.getTime();
    }
    
    
    
    /**
     * 得到 (Date类型的日期+N年) 的日期Date类型  加法
     * @param date
     * @param month
     * @return
     */
    public static Date getAddYear(Date date , int year){
    	 Calendar now = Calendar.getInstance();  
    	 now.setTime(date);
    	 now.add(Calendar.YEAR, year);
    	return now.getTime();
    }
    
    
    /**
     * 得到 (Date类型的日期-N个月) 的日期字符串   减法
     * @param date
     * @param month
     * @return
     */
    public static Date getSubtractYear(Date date , int year){
    	 Calendar now = Calendar.getInstance();  
    	 now.setTime(date);
    	 now.add(Calendar.YEAR, -year);
    	return now.getTime();
    }
    
    
    
    
    
	private static Calendar initCurrentDate()
	{
		Date date = new Date(System.currentTimeMillis());
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c;
	}
	public static int getCurrentYear()
	{
		Calendar c = initCurrentDate();
		return c.get(Calendar.YEAR);
	}
	public static int getCurrentMonth(){
		return initCurrentDate().get(Calendar.MONTH)+1;
	}
	public static int getCurrentDay(){
		return initCurrentDate().get(Calendar.DAY_OF_MONTH);
	}
	public static int getCurrentHour(){
		return initCurrentDate().get(Calendar.HOUR_OF_DAY);
	}
	public static int getCurrentMinute(){
		return initCurrentDate().get(Calendar.MINUTE);
	}
	public static int getCurrentSecond(){
		return initCurrentDate().get(Calendar.SECOND);
	}
	public static String getCurrentDate(String format){
		SimpleDateFormat parse = new SimpleDateFormat(format);
		return parse.format(new Date());
	}
	public static Date parseDate(String str, String parsePatterns) throws ParseException {
        if (str == null || parsePatterns == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }

        SimpleDateFormat parser = null;
        ParsePosition pos = new ParsePosition(0);
                parser = new SimpleDateFormat(parsePatterns);
            pos.setIndex(0);
            Date date = parser.parse(str, pos);
            if (date != null && pos.getIndex() == str.length()) {
                return date;
            }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }
	public static String dateToString(Date date, String par)
	{
		if(date==null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(par);
		return sdf.format(date);
	}
	/**
	 * 将日期字符串转换为长整型
	 * @param date 格式(yyyy-MM-dd)
	 * @return
	 */
	public static long strToDateLong(String date) {
		long l = 0L;
		try {
			Calendar ca = Calendar.getInstance();
			ca.setTime(java.sql.Date.valueOf(date));
			l=ca.getTimeInMillis();
		} catch (Exception e) {
			new Exception("日期字符串转长整形错误",e);
		}
		return l;
	}
	public static String longToStrDate(String format,long time){
		DateFormat df = new SimpleDateFormat(format);
		return df.format(new Date(time));
	}
	public static Date strToDate(String str, String parsePatterns) throws ParseException {
		return parseDate(str,parsePatterns);
	}


	/**
	 * 得到 n 天后的日期
	 *
	 * @param days
	 * @return
	 */
	public static Date getAfterCurrentDay(int days) {
		Date result = null;
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.add(Calendar.DAY_OF_WEEK, +days);
			result = calendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 得到当前日期的年月日时分秒
	 *
	 * @return
	 */
	public static String getCurrentDateTimeString() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(FORMAT);
		return df.format(calendar.getTime());
	}

	/**
	 * 得到当前日期的年-月-日 时:分:秒
	 *
	 * @return
	 */
	public static String getCurrentDateToString() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(FULL_FORMAT);
		return df.format(calendar.getTime());
	}

	/**
	 * 得到当前日期的年-月-日
	 *
	 * @return
	 */
	public static String getCurrentDateSimpleToString() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(SIMPLE_FORMAT);
		return df.format(calendar.getTime());
	}

	/**
	 * 得到当前日期的年-月-日
	 *
	 * @return
	 */
	public static Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}

	/**
	 * 得到当前日期的年-月-日
	 *
	 * @return
	 */
	public static Timestamp getCurrentDateTimestamp() {
		Calendar calendar = Calendar.getInstance();
		return new Timestamp(calendar.getTime().getTime());
	}

	/**
	 * 得到当天到下周的日期
	 *
	 * @return
	 */
	public static String getNextWeekToString() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_WEEK, +6);
		SimpleDateFormat df = new SimpleDateFormat(SIMPLE_FORMAT);
		return df.format(calendar.getTime());
	}

	/**
	 * 得到明天的时间
	 *
	 * @return
	 */
	public static String getNextDayToString(String day) {
		String result = "";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(SIMPLE_FORMAT);
		try {
			calendar.setTime(df.parse(day));
			calendar.add(Calendar.DAY_OF_WEEK, +1);
			result = df.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String getLastWeekToString() {
		String result = "";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(SIMPLE_FORMAT);
		try {
			calendar.add(Calendar.WEEK_OF_MONTH, -1);// 周数减一，即上周
			result = df.format(calendar.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取昨天日期
	 *
	 * @param day
	 * @return
	 */
	public static String getYestarDayToString(String day) {
		String result = "";
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(SIMPLE_FORMAT);
		try {
			calendar.setTime(df.parse(day));
			calendar.add(Calendar.DAY_OF_WEEK, -1);
			result = df.format(calendar.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 字符串日期转Date类型
	 *
	 * @param str
	 * @return
	 */
	public static Date stringToSimpleDate(String str) {
		if (str == null || "".equals(str))
			return null;
		SimpleDateFormat df = new SimpleDateFormat(SIMPLE_FORMAT);
		try {
			return df.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 字符串日期转Date类型
	 *
	 * @param str
	 * @return
	 */
	public static Date stringToFullDate(String str) {
		if (str == null || "".equals(str)) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(FULL_FORMAT);
		try {
			return df.parse(str);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Date类型转字符串日期
	 *
	 * @param str
	 * @return
	 */
	public static String dateToSimpleString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat df = new SimpleDateFormat(SIMPLE_FORMAT);
		return df.format(date);
	}

	/**
	 * Date类型转字符串日期
	 *
	 * @param str
	 * @return
	 */
	public static String dateToFullString(Date date) {
		SimpleDateFormat df = new SimpleDateFormat(FULL_FORMAT);
		return df.format(date);
	}

	/**
	 * 根据日期得到星期几
	 *
	 * @param date
	 * @return
	 */
	public static String getWeekChinese(String date) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(SIMPLE_FORMAT);
		try {
			cal.setTime(df.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 判断两个时间的大小 是否后面那个大于前面那个 格式 yyyy-MM-dd
	 *
	 * @param startDate
	 * @param endDate
	 * @return true为是 false为否
	 */
	public static boolean judgeDate(String startStr, String endStr) {
		Date startDate = stringToSimpleDate(startStr);
		Date endDate = stringToSimpleDate(endStr);
		if (startDate.before(endDate)) {
			return true;
		}
		return false;
	}

	/**
	 * 判断两个时间的大小 是否后面那个大于或等于前面那个 格式 yyyy-MM-dd
	 *
	 * @param startDate
	 * @param endDate
	 * @return true为是 false为否
	 */
	public static boolean judgeDateEqual(String startStr, String endStr) {
		Date startDate = stringToSimpleDate(startStr);
		Date endDate = stringToSimpleDate(endStr);
		if (startDate.before(endDate) || startDate.compareTo(endDate) == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 得到多少天的日期 正数为加 负数为减
	 *
	 * @param str
	 * @param day
	 * @return
	 */
	public static String getNumAfterDate(String str, int day) {
		Date startDate = stringToSimpleDate(str);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		calendar.add(Calendar.DAY_OF_WEEK, day);
		return dateToSimpleString(calendar.getTime());
	}

	/**
	 * 将UNIXTIME转为普通的时间
	 *
	 * @param unixTime
	 * @return
	 */
	public static String unixTimeToString(String unixTime) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(Long.parseLong(unixTime));
		return dateToSimpleString(c.getTime());
	}

	/**
	 * 将普通的日间转为UNIXTIME
	 *
	 * @param date
	 * @return
	 */
	public static String stringToUnixTime(String date) {
		Calendar c = Calendar.getInstance();
		Date date2 = stringToSimpleDate(date);
		c.setTime(date2);
		return c.getTimeInMillis() + "";

	}

	/**
	 * 将时间字符串转化成Timestamp时间戳（String的类型必须形如： yyyy-mm-dd hh:mm:ss 这样的格式，否则报错）
	 *
	 * @param tsStr
	 * @return Timestamp
	 */
	public static Timestamp stringToTimestamp(String tsStr) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {
			ts = Timestamp.valueOf(tsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}

	/**
	 * 时间戳转字符串
	 *
	 * @param cc_time
	 * @return
	 */
	public static String getStrByTimestamp(Timestamp cc_time) {
		SimpleDateFormat sdf = new SimpleDateFormat(FULL_FORMAT);
		return sdf.format(cc_time);
	}



	@SuppressWarnings("static-access")
	public static Time strToTime(String strDate) {
		if ("".equals(strDate) || strDate == null) {
			return null;
		}
		String str = strDate;
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Date d = null;
		try {
			d = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Time time = new Time(d.getTime());
		return time.valueOf(str);
	}

	public static Time getTime() {
		Date d = new Date();
		// SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Time time = new Time(d.getTime());
		return time;
	}
	
	/**
	 * dateB - dateA  的日期天数
	 * @param dateA
	 * @param dateB
	 * @return
	 */
	public static int getBetweenDayNumber(String startStr, String endStr) {
		Date dateA = stringToSimpleDate(startStr);
		Date dateB = stringToSimpleDate(endStr);
		long dayNumber = 0;
		long DAY = 24L * 60L * 60L * 1000L;
		try {
			dayNumber = (dateB.getTime() - dateA.getTime()) / DAY;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (int) dayNumber;
	}
	
	/**
	 * 计算两个日期相差的天数 date2-date1
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int daysBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}
	/**
	 * 日期增加天数
	 * @param date
	 * @param addDays
	 * @return
	 */
	public static Date dateAddDays(Date date,int addDays){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, addDays);
		return calendar.getTime();
	}
	
	/**
	 * 日期增加小时
	 * @param date
	 * @param addHours
	 * @return
	 */
	public static Date dateAddHours(Date date,int addHours){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, addHours);
		return calendar.getTime();
	}
	
	/**
	 * 日期增加分钟
	 * @param date
	 * @param addMinutes
	 * @return
	 */
	public static Date dateAddMinutes(Date date,int addMinutes){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, addMinutes);
		return calendar.getTime();
	}
	
	
	/**
	 * 得到传入日期所在月的最后一天
	 * @param date
	 * @return
	 */
	public static String getLastDayBySimpleDay(String date){
		
		String lastDay=null;
		  //创建日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stringToSimpleDate(date));
        calendar.add(Calendar.MONTH, 1);    //加一个月
        calendar.set(Calendar.DATE, 1);     //设置为该月第一天
        calendar.add(Calendar.DATE, -1);    //再减一天即为上个月最后一天
        lastDay = dateToSimpleString(calendar.getTime());
        return lastDay;
	}
	
	/* 
	 * 将时间转换为时间戳
     */    
    public static String dateToStamp(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FULL_FORMAT);
        Date date = null;
		try {
			date = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date == null) {
			return null;
		}
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

	
//	public static void main(String[] args) {
//		String da = longToStrDate(FULL_FORMAT, 1512358115*1000l);
//		System.out.println(da);
//	}
	
	
     /**
      * 得到传入日期所在月的第一天
     * @param date
     * @return
     */
    public static String getFirstDayBySimpleDay(String date){
		
		String lastDay=null;
		  //创建日历
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(stringToSimpleDate(date));
        calendar.set(Calendar.DATE, 1);     //设置为该月第一天
        lastDay = dateToSimpleString(calendar.getTime());
        return lastDay;
	}
    
    
	/**
	 * 判断两个时间的大小 是否后面那个大于前面那个 格式 yyyy-MM-dd hh:ss:mm
	 * 
	 * @param startStr
	 * @param endStr
	 * @return true为是 false为否
	 */
	public static boolean judgeFullDate(String startStr, String endStr) {
		Date startDate = stringToFullDate(startStr);
		Date endDate = stringToFullDate(endStr);
		if (startDate.before(endDate)) {
			return true;
		}
		return false;
	}
	
	 public static int getDaysOfMonth(Date date) {  
	        Calendar calendar = Calendar.getInstance();  
	        calendar.setTime(date);  
	        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
	    } 
	
	/**
	 * 获取当前年月日时分秒的上houre个小时  
	 * 
	 * @return  yyyyMMddHH
	 */
	 public static String beforeOneHourToNowDate(int houre) {  
	        Calendar calendar = Calendar.getInstance();  
	        /* HOUR_OF_DAY 指示一天中的小时 */  
	        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - houre);  
	        SimpleDateFormat df = new SimpleDateFormat(SUB_HOURE_FORMAT);
	        return df.format(calendar.getTime());
	}
	
	 /**
	  * 获取指定时间的秒级时间戳
	  * 
	  * @param date
	  * @return
	  */
    public static Long getSecondTimestamp(Date date){  
        if (null == date) {  
           return 0L;  
        }  
        String timestamp = String.valueOf(date.getTime());  
        int length = timestamp.length();  
        if (length > 3) {  
            return Long.valueOf(timestamp.substring(0,length-3));  
        } else {  
            return 0L;  
        }  
    } 
    
    /**
     * 
     * @Description: 比较date1是或否在startDate和endDate之间
     * @Tags: @param date1        需要比较的日期
     * @Tags: @param startDate    开始日期
     * @Tags: @param endDate      结束日期
     * @Tags: @return 
     * @throws
     * @Author MDH
     * @Date 2018年12月20日
     * @return boolean
     */
    public static boolean compareDate(String date1,String startDate,String endDate){
    	boolean flag = false;
    	if(compare_date(date1,startDate) != -1 && compare_date(date1,endDate) != 1) { 
    		flag = true; 
    	} 
    	return flag;
    }
    
    public static int compare_date(String DATE1, String DATE2) { 
    	try { 
	    	Date dt1 = parseDate(DATE1, SIMPLE_FORMAT);
	    	Date dt2 = parseDate(DATE2, SIMPLE_FORMAT);
	    	if (dt1.getTime() > dt2.getTime()) { 
	    		System.out.println(DATE1+" 在  "+ DATE2 +"前"); 
	    		return 1; 
	    	} else if (dt1.getTime() < dt2.getTime()) { 
	    		System.out.println(DATE1+" 在  "+ DATE2 +"后"); 
	    		return -1; 
	    	} else { 
	    		return 0; 
	    	} 
    	} catch (Exception ex) { 
    		ex.printStackTrace(); 
    	} 
    	return 0; 
	}
    
    
}
