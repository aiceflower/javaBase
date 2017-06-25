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
	 * ��ȡû���ظ����ַ���
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
     * ��ȡ32λ����ַ���
     */
    public static String nextString() {
        return nextString(32);
    }
 
    /**
     * ��ȡָ�������ַ���
     */
    public static String nextString(int length) {
    	setLength(length);
    	for (int idx = 0; idx < buf.length; ++idx)
    		buf[idx] = symbols[random.nextInt(symbols.length)];
    	return new String(buf);
    }
    
    //��ȫ
    private static SecureRandom sr = new SecureRandom();
    /**
     * ���ɰ�ȫ����� ��
     */
    public static String nextSessionId() {
      return nextSessionId(32);
    }
    public static String nextSessionId(int len){
    	if(len<26){//128 λ��ȫ�����������,���㹻��ȫ��
    		 throw new IllegalArgumentException("not secure, length < 26: " + len);
    	}
    	return new BigInteger(len*5, sr).toString(32);//������ 32 ���Ʊ����ÿһ�����ֿɱ��� 5 λ
    }
    
    /**
     * ��ջ׷����Ϣת��Ϊ�ַ���
     */
    @SuppressWarnings("unused")
	public static String parseThrowableToStr(Throwable e){
    	//��һ
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		
		//����
		StringBuffer sb = new StringBuffer();
		for ( StackTraceElement ele : e.getStackTrace()) {
			sb.append(ele.toString()+"\r\n");
		}
		return sb.toString();
    }
    
    /**
     * ����ǰ�����
     * @param str
     * @param len
     * @return
     */
    public static String lPadZero(int source,int len){
    	//org.apache.commons.lang.StringUtils.leftPad(String str, int size, '0')
    	return String.format("%0"+len+"d", source);
    }
    
    /**
     * ����ǰ�����
     * @param str
     * @param len
     * @return
     */
    public static String leftPad(int source,int len){
    	DecimalFormat df = new DecimalFormat(getZero(len,'0'));
        return df.format(source);
    }
    /**
     * ����ǰ���ָ���ַ�
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
     * ���������ȡָ���ַ���
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
     * ���������ȡָ���ַ���
     */
    public static String getStrByRegIgnoreCase(String source,String reg){
    	Pattern p = Pattern.compile(reg,Pattern.CASE_INSENSITIVE);
    	Matcher m = p.matcher(source);
    	m.find();
    	return m.group();
    }
}
