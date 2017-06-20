package learn.basic.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import learn.basic.string.StringUtil;

public class DateUtil {
	
	private static final String DEFAULT_FMT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * ��ȡ��ǰ����
	 * 
	 * @param sdf���ڸ�ʽ������
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
	 * ��ȡ��ʽ������
	 * @return
	 */
	public static SimpleDateFormat getSimpleDateFormat(){
		return formatter.get();
	}
	
	/**
	 * ��ʽ�����ڣ�yyyy-MM-dd HH:mm:ss
	 * @param date ����ʽ��������
	 * @return ��ʽ������ַ���
	 */
	public static String formatDate(Date date){
		return formatDate(date,null);
	}
	
	/**
	 * ����ָ����ʽ��ʽ������
	 * @param date ����ʽ��������
	 * @param fmt ��ʽ
	 * @return ��ʽ������ַ���
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
