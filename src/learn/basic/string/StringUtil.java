package learn.basic.string;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
	 * 获取没有重复的字符串
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
	
	/**
	 * 
	 */
	private static final char[] symbols;

    static {
        StringBuilder tmp = new StringBuilder();
        for (char ch = '0'; ch <= '9'; ++ch)
            tmp.append(ch);
        for (char ch = 'a'; ch <= 'z'; ++ch)
            tmp.append(ch);
        symbols = tmp.toString().toCharArray();
    }

    private static final Random random = new Random();

    private static  char[] buf;

    private static void setLength(int length) {
        if (length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
        buf = new char[length];
    }

    /**
     * 获取32位随机字符串
     */
    public static String nextString() {
        return nextString(32);
    }
 
    /**
     * 获取指定长度字符串
     */
    public static String nextString(int length) {
    	setLength(length);
    	for (int idx = 0; idx < buf.length; ++idx)
    		buf[idx] = symbols[random.nextInt(symbols.length)];
    	return new String(buf);
    }
    
    //安全
    private static SecureRandom sr = new SecureRandom();
    /**
     * 生成安全的随机 数
     */
    public static String nextSessionId() {
      return nextSessionId(32);
    }
    public static String nextSessionId(int len){
    	if(len<26){//128 位安全随机数的生成,是足够安全的
    		 throw new IllegalArgumentException("not secure, length < 26: " + len);
    	}
    	return new BigInteger(len*5, sr).toString(32);//不过以 32 进制编码的每一个数字可编码 5 位
    }
    
    /**
     * 将栈追踪信息转换为字符串
     */
    @SuppressWarnings("unused")
	public static String parseThrowableToStr(Throwable e){
    	//法一
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		
		//法二
		StringBuffer sb = new StringBuffer();
		for ( StackTraceElement ele : e.getStackTrace()) {
			sb.append(ele.toString()+"\r\n");
		}
		return sb.toString();
    }
    
    /**
     * 整数前填充零
     * @param str
     * @param len
     * @return
     */
    public static String lPadZero(int source,int len){
    	//org.apache.commons.lang.StringUtils.leftPad(String str, int size, '0')
    	return String.format("%0"+len+"d", source);
    }
    
    /**
     * 整数前填充零
     * @param str
     * @param len
     * @return
     */
    public static String leftPad(int source,int len){
    	DecimalFormat df = new DecimalFormat(getZero(len,'0'));
        return df.format(source);
    }
    /**
     * 整数前填充指定字符
     */
    public static String leftPad(int source,int len,char c){
    	DecimalFormat df = new DecimalFormat(getZero(len,c));
    	return df.format(source);
    }
    private static String getZero(int len,char c){
    	StringBuilder sb = new StringBuilder();
    	while(len>0){
    		len--;
    		sb.append(c);
    	}
    	return sb.toString();
    }
    
    /**
     * 根据正则获取指定字符串
     */
    public static String getStrByReg(String source,String reg){
    	Pattern p = Pattern.compile(reg);
    	Matcher m = p.matcher(source);
    	m.find();
    	try {
    		return m.group();
		} catch (Exception e) {
			return "";
		}
    }
    /**
     * 根据正则获取指定字符串
     */
    public static String getStrByRegIgnoreCase(String source,String reg){
    	Pattern p = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
    	Matcher m = p.matcher(source);
    	m.find();
    	return m.group();
    }
}
