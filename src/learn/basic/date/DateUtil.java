package learn.basic.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
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
}
