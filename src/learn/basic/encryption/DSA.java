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
 * 数字签名算法--DSA
 * 
 * RSA，DSA，ECDSA是签名算法
 * 
 * @author pillow
 *
 */

/*
 * DSS(Digital Signature Standard)数字签名标准 DSA(Digital Signature Algorithm)数字签名算法
 * DSA仅包含数字签名无法进行加密通讯
 * 算法  以下 密钥长度为512~1024为64的整数倍，默认长度为1024 
 * SHA1withDSA    实现方  JDK
 * -------------------------
 * SHA224withDSA   实现方BC
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
			// 1.初始化密钥
			KeyPairGenerator keyPairGenerator = KeyPairGenerator
					.getInstance("DSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			DSAPublicKey dsaPublicKey = (DSAPublicKey) keyPair.getPublic();
			DSAPrivateKey dsaPrivateKey = (DSAPrivateKey) keyPair.getPrivate();

			// 2.执行签名
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
			// 3.验证签名
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
