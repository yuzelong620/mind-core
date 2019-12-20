package com.mind.core.util;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date; 

/**
 * 时间工具类
 * @author ninglong
 *
 */
public class TimeUtil {
	
	public final static String cnFomat = "YYYY-MM-dd HH:mm:ss";
	public final static String dayFomat = "yyyyMMdd";
	public static final String FULL_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 获取YYYY-MM-DD hh:mm:ss 格式的时间
	 */
	public static String getCnFomatTime(long time){
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(FULL_TIME_FORMAT);
		return sdf.format(date);
	}
	
	/**
	 * 获取yyyy-MM-dd HH:mm:ss 格式的时间的当前毫秒数
	 * @throws ParseException 
	 */
	public static long getDayFomatTimeMSecond(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(FULL_TIME_FORMAT);
		long millTime = 0;
        if (!StringUtils.isEmpty(time)) {
        	Calendar c = Calendar.getInstance();
    		Date date = sdf.parse(time);
    		c.setTime(date);
    		millTime = c.getTimeInMillis();
		}
		return millTime;
	}
	
	/**
	 * 获取YYYY-MM-DD 格式的时间
	 */
	public static String getCnFomatDay(long time){
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(dayFomat);
		return sdf.format(date);
	}
	
	
	/**
	 * 获取yyyyMMdd 格式的时间的当前0点毫秒数
	 * @throws ParseException 
	 */
	public static long getDayFomatTimeSecond(String time) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(dayFomat);
		long millTime = 0;
		Calendar c = Calendar.getInstance();
		Date date = sdf.parse(time);
		c.setTime(date);
		millTime = c.getTimeInMillis();
		return millTime;
	}
	
	/**
	 * 秒级别的时间戳的时间比较
	 */
	public static boolean isSameDaySecond(int oldTime, int newTime) {
		if(oldTime==newTime){
			return true;
		}else if(oldTime==0||newTime==0){
			return false;
		}else{
			
			Calendar oldCalendar = Calendar.getInstance();
			oldCalendar.setTimeInMillis(oldTime*1000L);
			Calendar newCalendar = Calendar.getInstance();
			newCalendar.setTimeInMillis(newTime*1000L);
			return oldCalendar.get(Calendar.DAY_OF_YEAR) == newCalendar.get(Calendar.DAY_OF_YEAR);
		}
	}
	
	/**
	 * 是否是昨天的时间
	 */
	public static boolean isYesterday(int time){
		Calendar oldCalendar = Calendar.getInstance();
		oldCalendar.setTimeInMillis(time*1000L);
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		c.add(Calendar.DATE, -1);
		return oldCalendar.get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR);
	}
	
	/**
	 * 是否是7天前的当天时间
	 */
	public static boolean isSevendaysAgo(int time){
		Calendar oldCalendar = Calendar.getInstance();
		oldCalendar.setTimeInMillis(time*1000L);
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		c.add(Calendar.DATE, -7);
		return oldCalendar.get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR);
	}
	/**
	 * 是否是几天前的时间
	 * @param time 对比时间
	 * @param days 天数 
	 * @return
	 */
	public static boolean isTimeAgo(int time,int days){
		Calendar oldCalendar = Calendar.getInstance();
		oldCalendar.setTimeInMillis(time*1000L);
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return oldCalendar.get(Calendar.DAY_OF_YEAR) == c.get(Calendar.DAY_OF_YEAR);
	}
	/**
	 * 得到今天这个小时的时间
	 */
	public static long getTodayFixHour(int hour) {
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTimeInMillis();
	}
	/**
	 * 得到昨天这个小时的时间
	 */
	public static long getYestodayFixHour(int hour) {
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		c.add(Calendar.DATE, -1);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTimeInMillis();
	}
	/**
	 * 得到某一的0点
	 */
	public static long getZoreSecond(int day) {
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		c.add(Calendar.DATE, day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTimeInMillis();
	}
	
	/**
	 * 得到明天这个小时的时间
	 */
	public static long getTomorrowFixHour(int hour) {
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTimeInMillis();
	}
	
	/**
	 * 获取当天0点0分
	 * @return
	 */
	public static int getTodayZoreSecond(){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0); 
		cal.set(Calendar.MINUTE, 0); 
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MILLISECOND, 0); 
		return (int)(cal.getTimeInMillis()/1000L);
	}
	
	/**
	 * 根据字符串获取当天时间
	 * @param time (格式:"00:00")
	 * @return
	 */
	public static long getTodayFixByStr(String time){
		String[] times = time.split(":");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(times[0])); 
		cal.set(Calendar.MINUTE, Integer.parseInt(times[1])); 
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MILLISECOND, 0); 
		return cal.getTimeInMillis();
	}
	/**
	 * 根据字符串获取明天时间
	 * @param time (格式:"00:00")
	 * @return
	 */
	public static long getTomorrowFixByStr(String time){
		String[] times = time.split(":");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(times[0])); 
		cal.set(Calendar.MINUTE, Integer.parseInt(times[1])); 
		cal.set(Calendar.SECOND, 0); 
		cal.set(Calendar.MILLISECOND, 0); 
		return cal.getTimeInMillis();
	}
	/**
	 * 获得当天时间的秒数
	 * @return
	 */
	public static int getDaySecond() {
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int minute = c.get(Calendar.MINUTE);
		int second = c.get(Calendar.SECOND);
		return hour*3600+minute*60+second;
	}
	
	/**
	 * 根据秒数获得相应小时数
	 */
	public static int getHourBySecond(int second){
		return second/60/60;
		
	}
	
	/**
	 * 得到今天是星期几
	 */
	public static int getWeekDay() {
		Calendar c = Calendar.getInstance();
		int weekDay = c.get(Calendar.DAY_OF_WEEK) - 1;
		weekDay = weekDay == 0 ? 7 : weekDay;
		return weekDay;
	}
	/**
	 * 得到今天是星期几
	 */
	public static int getWeekDay(int now) {
		Calendar c = Calendar.getInstance();
	    c.setTime( new Date(now*1000l));
		int weekDay = c.get(Calendar.DAY_OF_WEEK) - 1;
		weekDay = weekDay == 0 ? 7 : weekDay;
		return weekDay;
	}

}