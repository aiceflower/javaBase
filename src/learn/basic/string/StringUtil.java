package learn.basic.string;

import java.util.Random;
import java.util.UUID;


public class StringUtil {

	/**
	 * �������ĳ���ȵ��ַ���
	 * 
	 * @param length��ʾ�����ַ����ĳ���
	 *            (Сд��ĸ������)
	 * @return ���ɵ��ַ���
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * @param len
	 * @return
	 */
	public static String getNoRepeatRandomString(int len) {
		// �ַ�����С���Ը���
		String generateSource = "0123456789abcdefghigklmnopqrstuvwxyz";
		String rtnStr = "";
		for (int i = 0; i < len; i++) {
			String nowStr = String.valueOf(generateSource.charAt((int) Math
					.floor(Math.random() * generateSource.length())));
			rtnStr += nowStr;
			generateSource = generateSource.replaceAll(nowStr, "");
		}
		return rtnStr;
	}

	/**
	 * 
	 * ��֤�ַ����Ƿ�Ϊ�ջ��ǳ���Ϊ��
	 */
	public static boolean isNullOrEmpty(String string) {
		return (string == null || "".equals(string)) ? true : false;
	}

	/**
	 * ��֤�ַ����ǿ��ҳ���Ϊ����
	 * 
	 * @param string
	 * @return
	 */
	public static boolean notNullOrEmpty(String string) {
		return isNullOrEmpty(string) ? false : true;
	}

	/**
	 * Сд���ת��Ϊ��д���
	 */
	public static String lowerCashToUpperCash(String money) {
		String M = "";
		String[] MyScale = { "��", "��", "Ԫ", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ",
				"��", "ʰ", "��", "Ǫ", "��", "ʰ", "��", "Ǫ" };
		String MyBase[] = { "��", "Ҽ", "��", "��", "��", "��", "½", "��", "��", "��" };
		boolean isPoint = false;
		if (money.indexOf(".") != -1) {
			// ȥ��С�����Ľ��
			money = money.substring(0, money.indexOf("."))
					+ money.substring(money.indexOf(".") + 1);
			isPoint = true;
		}
		for (int i = money.length(); i > 0; i--) {
			// ������������ÿһλ
			int MyData = Integer.parseInt(String.valueOf(money.charAt(money
					.length() - i)));
			M += MyBase[MyData];
			if (isPoint) {
				M += MyScale[i - 1];
			} else {
				M += MyScale[i + 1];
			}
		}
		return M;

	}
	
	/**
	 * ��ȡUUID�ַ���
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
