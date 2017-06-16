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
 * 数字签名算法--RSA
 * 
 * RSA，DSA，ECDSA是签名算法
 * 
 * @author pillow
 *
 */

/*
 * rsa也是非对称加密算法，运用非常广泛 。数字签名算法--RSA 密钥和加密算法都叫RSA 包括 MD 和 SHA两类 算法
 * 以下密钥长度为512~65536为64的整数倍 签名长度与密钥长度相同 MD2withRSA MD5withRSA SHA1withRSA
 * 这三种默认长度为1024 由JDK方实现 -------------------------------- SHA224withRSA
 * 以下的默认长度为2048 由BC实现 SHA256withRSA SHA385withRSA SHA512withRSA RIPEMD128withRSA
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
			// 1.初始化密钥
			KeyPairGenerator keyPairGenerator = KeyPairGenerator
					.getInstance("RSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
			RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

			// 2.执行签名
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

			// 3.验证签名
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
