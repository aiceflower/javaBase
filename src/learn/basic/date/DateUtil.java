package learn.basic.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import learn.basic.string.StringUtil;

public class DateUtil {
	
	private static final String DEFAULT_FMT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 获取当前日期
	 * 
	 * @param sdf日期格式化对象
	 * @return
	 */
	public static String getCurrentDate(SimpleDateFormat sdf) {
		Calendar calendar = Calendar.getInstance();
		return sdf.format(calendar.getTime());
	}
	
	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(DEFAULT_FMT);
		};
	};
	
	/**
	 * 获取格式化对象
	 * @return
	 */
	public static SimpleDateFormat getSimpleDateFormat(){
		return formatter.get();
	}
	
	/**
	 * 格式化日期，yyyy-MM-dd HH:mm:ss
	 * @param date 待格式化的日期
	 * @return 格式化后的字符串
	 */
	public static String formatDate(Date date){
		return formatDate(date,null);
	}
	
	/**
	 * 按照指定格式格式化日期
	 * @param date 待格式化的日期
	 * @param fmt 格式
	 * @return 格式化后的字符串
	 */
	public static String formatDate(Date date,String fmt){
		SimpleDateFormat format = formatter.get();
		if(StringUtil.isNullOrEmpty(fmt)){
			String pattern = format.toPattern();
			if(!pattern.equals(DEFAULT_FMT)){
				format.applyPattern(DEFAULT_FMT);
			}
			return format.format(date);
		}else{
			format.applyPattern(fmt);
			return format.format(date);
		}
	}
}
