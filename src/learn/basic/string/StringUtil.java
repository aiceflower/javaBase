package learn.basic.string;

import java.util.Random;
import java.util.UUID;


public class StringUtil {

	/**
	 * 随机生成某长度的字符串
	 * 
	 * @param length表示生成字符串的长度
	 *            (小写字母和数字)
	 * @return 生成的字符串
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
		// 字符串大小可以更改
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
	 * 验证字符串是否为空或是长度为零
	 */
	public static boolean isNullOrEmpty(String string) {
		return (string == null || "".equals(string)) ? true : false;
	}

	/**
	 * 验证字符串非空且长度为非零
	 * 
	 * @param string
	 * @return
	 */
	public static boolean notNullOrEmpty(String string) {
		return isNullOrEmpty(string) ? false : true;
	}

	/**
	 * 小写金额转换为大写金额
	 */
	public static String lowerCashToUpperCash(String money) {
		String M = "";
		String[] MyScale = { "分", "角", "元", "拾", "佰", "仟", "万", "拾", "佰", "仟",
				"亿", "拾", "佰", "仟", "兆", "拾", "佰", "仟" };
		String MyBase[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		boolean isPoint = false;
		if (money.indexOf(".") != -1) {
			// 去掉小数点后的金额
			money = money.substring(0, money.indexOf("."))
					+ money.substring(money.indexOf(".") + 1);
			isPoint = true;
		}
		for (int i = money.length(); i > 0; i--) {
			// 后续遍历金额的每一位
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
	 * 获取UUID字符串
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
