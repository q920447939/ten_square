package cn.withmes.common.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * DESC: 加密工具类
 * @DATE 2015年7月22日下午5:09:30
 */
public class EncryptionUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(EncryptionUtils.class);
	
	
	private static final String SHA1 = "SHA-1";
	private static final String MD5 = "MD5";

	private static SecureRandom random = new SecureRandom();

	
	/**
	 * DESC: 生成md5 
	 * @param data
	 * @return
	 */
	public static String md5(String data){
		if(StringUtils.isEmpty(data)){
			return "";
		}
		return DigestUtils.md5Hex(data);
	}

	/**
	 * 对文件进行md5散列.
	 */
	public static byte[] md5(InputStream input) throws IOException {
		return digest(input, MD5);
	}
	
	/**
	 * DESC: SHA加密
	 * @param data
	 * @return
	 */
	public  static String sha(String data){
		if(StringUtils.isEmpty(data)){
			return "";
		}
		return DigestUtils.sha1Hex(data);
	}
	/**
	 * DESC: BASE64编码
	 * @param data
	 * @return
	 */
/*	public static String base64Encode(String data){
		if(StringUtils.isEmpty(data)){
			return "";
		}
		try {
			return new String(Base64.encodeBase64(data.getBytes(),true),SessionConstant.UTF8_ENCODE);
		} catch (UnsupportedEncodingException e) {
			logger.error("BASE64编码异常", e);
		}
		return "";
	}*/
	/**
	 * DESC: BASE64解码
	 * @param data
	 * @return
	 */
/*	public static String base64Decode(String data){
		if(StringUtils.isEmpty(data)){
			return "";
		}
		try {
			return new String(Base64.decodeBase64(data.getBytes()),SessionConstant.UTF8_ENCODE);
		} catch (UnsupportedEncodingException e) {
			logger.error("BASE64解码异常", e);
		}
		return "";
	}*/
	
	
	/**
	 * 对输入字符串进行sha1散列.
	 */
	public static byte[] sha1(byte[] input) {
		return digest(input, SHA1, null, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt) {
		return digest(input, SHA1, salt, 1);
	}

	public static byte[] sha1(byte[] input, byte[] salt, int iterations) {
		return digest(input, SHA1, salt, iterations);
	}
	
	/**
	 * 对文件进行sha1散列.
	 */
	public static byte[] sha1(InputStream input) throws IOException {
		return digest(input, SHA1);
	}

	/**
	 * 对字符串进行散列, 支持md5与sha1算法.
	 */
	private static byte[] digest(byte[] input, String algorithm, byte[] salt, int iterations) {
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);

			if (salt != null) {
				digest.update(salt);
			}

			byte[] result = digest.digest(input);

			for (int i = 1; i < iterations; i++) {
				digest.reset();
				result = digest.digest(result);
			}
			return result;
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static byte[] digest(InputStream input, String algorithm) throws IOException {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			int bufferLength = 8 * 1024;
			byte[] buffer = new byte[bufferLength];
			int read = input.read(buffer, 0, bufferLength);

			while (read > -1) {
				messageDigest.update(buffer, 0, read);
				read = input.read(buffer, 0, bufferLength);
			}

			return messageDigest.digest();
		} catch (GeneralSecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 生成随机的Byte[]作为salt.
	 * 
	 * @param numBytes byte数组的大小
	 */
	public static byte[] generateSalt(int numBytes) {
		Validate.isTrue(numBytes > 0, "numBytes argument must be a positive integer (1 or larger)", numBytes);

		byte[] bytes = new byte[numBytes];
		random.nextBytes(bytes);
		return bytes;
	}



	public static byte[] encryptHMAC(String data, String secret) throws IOException {
		byte[] bytes = null;
		try {
			SecretKey secretKey = new SecretKeySpec(secret.getBytes("UTF-8"), "HmacMD5");
			Mac mac = Mac.getInstance(secretKey.getAlgorithm());
			mac.init(secretKey);
			bytes = mac.doFinal(data.getBytes("UTF-8"));
		} catch (GeneralSecurityException gse) {
			throw new IOException(gse);
		}
		return bytes;
	}
	
}
