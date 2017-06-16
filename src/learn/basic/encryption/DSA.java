package learn.basic.encryption;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


/**
 * ����ǩ���㷨--DSA
 * 
 * RSA��DSA��ECDSA��ǩ���㷨
 * 
 * @author pillow
 *
 */

/*
 * DSS(Digital Signature Standard)����ǩ����׼ DSA(Digital Signature Algorithm)����ǩ���㷨
 * DSA����������ǩ���޷����м���ͨѶ
 * �㷨  ���� ��Կ����Ϊ512~1024Ϊ64����������Ĭ�ϳ���Ϊ1024 
 * SHA1withDSA    ʵ�ַ�  JDK
 * -------------------------
 * SHA224withDSA   ʵ�ַ�BC
 * SHA256withDSA
 * SHA384withDSA
 * SHA512withDSA
 */
public class DSA {
	public static String src = "imooc security dsa";

	public static void main(String[] args) {
		jdkDSA();
	}

	public static void jdkDSA() {
		try {
			// 1.��ʼ����Կ
			KeyPairGenerator keyPairGenerator = KeyPairGenerator
					.getInstance("DSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			DSAPublicKey dsaPublicKey = (DSAPublicKey) keyPair.getPublic();
			DSAPrivateKey dsaPrivateKey = (DSAPrivateKey) keyPair.getPrivate();

			// 2.ִ��ǩ��
			PKCS8EncodedKeySpec pkscEncodedKeySpec = new PKCS8EncodedKeySpec(
					dsaPrivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("DSA");
			PrivateKey privateKey = keyFactory
					.generatePrivate(pkscEncodedKeySpec);
			Signature signature = Signature.getInstance("SHA1withDSA");
			signature.initSign(privateKey);
			signature.update(src.getBytes());
			byte result[] = signature.sign();
			//String encode = HexBin.encode(result);
			//System.out.println(encode.length());
			//System.out.println(HexBin.encode(result));
			// 3.��֤ǩ��
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
					dsaPublicKey.getEncoded());
			keyFactory = KeyFactory.getInstance("DSA");
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			signature = Signature.getInstance("SHA1withDSA");
			signature.initVerify(publicKey);
			signature.update(src.getBytes());
			boolean bool = signature.verify(result);
			System.out.println(bool);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
