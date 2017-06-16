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
		// DES����
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
	 * Base64����
	 * 
	 * @param source��Ҫ���ܵ��ַ���
	 * @return ��Base64���ܺ���ַ���
	 */
	public static String encodeBase64(String source) {
		return Base64.encode(source.getBytes());
	}

	/**
	 * Base64����
	 * 
	 * @param encode��Base64���ܺ���ַ���
	 * @return ��Base64���ܺ���ַ���
	 */
	public static String decodeBase64(String encode) {
		return new String(Base64.decode(encode));
	}

	/**
	 * DES����
	 * 
	 * @param sourcesource��Ҫ���ܵ��ַ���Ĭ����Կ
	 * @return ��DES���ܺ���ַ���
	 * @throws Exception
	 */
	public static String encodeDES(String source) throws Exception {
		return DES.encryptDES(source, encryptKey);
	}

	/**
	 * DES����
	 * 
	 * @param encode��DES���ܺ���ַ���Ĭ����Կ
	 * @return ��DES���ܺ���ַ���
	 * @throws Exception
	 */
	public static String decodeDES(String encode) throws Exception {
		return DES.decryptDES(encode, encryptKey);
	}

	// DES����
	/**
	 * @param source��Ҫ���ܵ��ַ���
	 * @param encryptKey������Կ
	 * @return ��DES���ܺ���ַ���
	 * @throws Exception
	 */
	public static String encodeDES(String source, String encryptKey)
			throws Exception {
		return DES.encryptDES(source, encryptKey);
	}

	/**
	 * @param encode��DES���ܺ���ַ���
	 * @param decryptKey������Կ
	 * @return ��DES���ܺ���ַ���
	 * @throws Exception
	 */
	public static String decodeDES(String encode, String decryptKey)
			throws Exception {
		return DES.decryptDES(encode, decryptKey);
	}

	public static String getRandomString(int length) { // length��ʾ�����ַ����ĳ���
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
