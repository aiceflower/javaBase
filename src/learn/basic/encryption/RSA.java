package learn.basic.encryption;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * ����ǩ���㷨--RSA
 * 
 * RSA��DSA��ECDSA��ǩ���㷨
 * 
 * @author pillow
 *
 */

/*
 * rsaҲ�ǷǶԳƼ����㷨�����÷ǳ��㷺 ������ǩ���㷨--RSA ��Կ�ͼ����㷨����RSA ���� MD �� SHA���� �㷨
 * ������Կ����Ϊ512~65536Ϊ64�������� ǩ����������Կ������ͬ MD2withRSA MD5withRSA SHA1withRSA
 * ������Ĭ�ϳ���Ϊ1024 ��JDK��ʵ�� -------------------------------- SHA224withRSA
 * ���µ�Ĭ�ϳ���Ϊ2048 ��BCʵ�� SHA256withRSA SHA385withRSA SHA512withRSA RIPEMD128withRSA
 * RIPEMD160withRSA
 * 
 * @author pillow
 */
public class RSA {
	public static String src = "imooc security rsa";
	public static void main(String[] args) {
		jdkRSA();
	}

	public static void jdkRSA() {

		try {
			// 1.��ʼ����Կ
			KeyPairGenerator keyPairGenerator = KeyPairGenerator
					.getInstance("RSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

			// 2.ִ��ǩ��
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
					rsaPrivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			PrivateKey privateKey = keyFactory
					.generatePrivate(pkcs8EncodedKeySpec);
			Signature signature = Signature.getInstance("MD5withRSA");
			signature.initSign(privateKey);
			signature.update(src.getBytes());
			byte result[] = signature.sign();
//			System.out.println(HexBin.encode(result));

			// 3.��֤ǩ��
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
					rsaPublicKey.getEncoded());
			keyFactory = KeyFactory.getInstance("RSA");
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			signature = Signature.getInstance("MD5withRSA");
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
