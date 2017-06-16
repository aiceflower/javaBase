package learn.basic.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
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
}
