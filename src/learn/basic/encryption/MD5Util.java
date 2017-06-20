package learn.basic.encryption;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	private final static String UTF_8 = "UTF-8";
	
	/**
	 * 获取32位MD5值
	 * @param source
	 * @return
	 */
	public static String getMD532(String source){
		return getMD532(source,UTF_8);
	}
	
	/**
	 * 获取指定编码的32位MD5值
	 * @param source
	 * @param charset
	 * @return
	 */
	public static String getMD532(String source, String charset) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bs = md.digest(source.getBytes(charset));
			StringBuilder sb = new StringBuilder(40);
			for (byte x : bs) {
				if ((x & 0xff) >> 4 == 0) {
					sb.append("0").append(Integer.toHexString(x & 0xff));
				} else {
					sb.append(Integer.toHexString(x & 0xff));
				}
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			return null;
		}
	}
	
	/**
	 * 获取16位MD5
	 * @param source
	 * @return
	 */
	public static String getMD516(String source){
		return getMD532(source,UTF_8).substring(8, 24);  
	}
	
	/**
	 * 获取指定编码的16位MD5
	 * @param source
	 * @return
	 */
	public static String getMD516(String source,String charset){
		return getMD532(source,charset).substring(8, 24);  
	}
}
