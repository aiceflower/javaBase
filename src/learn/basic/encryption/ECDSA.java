package learn.basic.encryption;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * ECDSA签名算法
 * 
 * RSA，DSA，ECDSA是签名算法
 * 
 * @author pillow
 *
 */
/*
 * 微软
 * Elliptic Curve Digital Signature Algorithm,椭圆曲线数字签名算法
 * 速度快， 强度高，签名短
 * 算法 密钥长度112~571默认256 签名长度          	       实现方
 * NONEwithECDSA     		128		  JDK/BC
 * RIPEMD160withECDSA		160		  BC
 * SHA1withECDSA			160		  JDK/BC	
 * SHA224withECDSA			224       BC
 * SHA256withECDSA			256       JDK/BC
 * SHA384withECDSA			384       JDK/BC
 * SHA512withECDSA			512       JDK/BC
 */
public class ECDSA {
	public static String src = "imooc security ecdsa";

	public static void main(String[] args) {
		ecdsa();
	}

	public static void ecdsa() {
		// 初始化密钥
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator
					.getInstance("EC");
			keyPairGenerator.initialize(256);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			ECPublicKey ecPublicKey = (ECPublicKey) keyPair.getPublic();
			ECPrivateKey ecPrivateKey = (ECPrivateKey) keyPair.getPrivate();

			// 执行签名
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(
					ecPrivateKey.getEncoded());
			KeyFactory keyFactory = KeyFactory.getInstance("EC");
			PrivateKey privateKey = keyFactory
					.generatePrivate(pkcs8EncodedKeySpec);
			Signature signature = Signature.getInstance("SHA1withECDSA");
			signature.initSign(privateKey);
			signature.update(src.getBytes());
			byte[] result = signature.sign();
//			System.out.println(HexBin.encode(result));

			// 3.验证
			X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(
					ecPublicKey.getEncoded());
			keyFactory = KeyFactory.getInstance("EC");
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			signature = Signature.getInstance("SHA1withECDSA");
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
