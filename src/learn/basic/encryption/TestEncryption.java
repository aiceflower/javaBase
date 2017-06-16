package learn.basic.encryption;

import java.util.Random;


public class TestEncryption {
	public static void main(String[] args) throws Exception {
		String strBase = "abcde";
		String encodeBase = encodeBase64(strBase);
		String decodeBase = decodeBase64(encodeBase);
		System.out.println(strBase);
		System.out.println(encodeBase);
		System.out.println(decodeBase);
		System.out.println("-----------------------");
		// DES加密
		String strDes = "abcde";
		String encodeDes = encodeDES(strDes);
		String decodeDes = decodeDES(encodeDes);
		System.out.println(strDes);
		System.out.println(encodeDes);
		System.out.println(decodeDes);
		System.out.println(encryptKey);
	}

	private static String encryptKey;
	static {
		encryptKey = getRandomString(8);
	}
	/**
	 * Base64加密
	 * 
	 * @param source需要加密的字符串
	 * @return 经Base64加密后的字符串
	 */
	public static String encodeBase64(String source) {
		return Base64.encode(source.getBytes());
	}

	/**
	 * Base64解密
	 * 
	 * @param encode经Base64加密后的字符串
	 * @return 经Base64解密后的字符串
	 */
	public static String decodeBase64(String encode) {
		return new String(Base64.decode(encode));
	}

	/**
	 * DES加密
	 * 
	 * @param sourcesource需要加密的字符串默认密钥
	 * @return 经DES加密后的字符串
	 * @throws Exception
	 */
	public static String encodeDES(String source) throws Exception {
		return DES.encryptDES(source, encryptKey);
	}

	/**
	 * DES解密
	 * 
	 * @param encode经DES加密后的字符串默认密钥
	 * @return 经DES解密后的字符串
	 * @throws Exception
	 */
	public static String decodeDES(String encode) throws Exception {
		return DES.decryptDES(encode, encryptKey);
	}

	// DES加密
	/**
	 * @param source需要加密的字符串
	 * @param encryptKey加密密钥
	 * @return 经DES加密后的字符串
	 * @throws Exception
	 */
	public static String encodeDES(String source, String encryptKey)
			throws Exception {
		return DES.encryptDES(source, encryptKey);
	}

	/**
	 * @param encode经DES加密后的字符串
	 * @param decryptKey解密密钥
	 * @return 经DES解密后的字符串
	 * @throws Exception
	 */
	public static String decodeDES(String encode, String decryptKey)
			throws Exception {
		return DES.decryptDES(encode, decryptKey);
	}

	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
}
