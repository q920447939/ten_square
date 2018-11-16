package cn.withmes.common.utils.security;


/**
 * .ClassName: DESUtils(des加密解密类) <br/>
 * date: 2015年7月31日 上午11:28:51 <br/>
 * @author tangjh
 */
public class DESUtils {

	private static final String DEFAULT_KEY ="3B827D20";

	/**
	 * decrypt:【解密】. <br/>
	 * @param content解密的内容
	 * @param key 解密的key
	 * @throws Exception.<br/>
	 */
/*	public static String decrypt(String content) throws Exception {
		byte[] bytesrc = Encodes.decodeBase64(content);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(DEFAULT_KEY.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(DEFAULT_KEY.getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}*/
	
	/**
	 * decrypt:【解密】. <br/>
	 * @param content解密的内容
	 * @param key 解密的key
	 * @throws Exception.
	 */
/*	public static String decrypt(String content, String key) throws Exception {
		byte[] bytesrc = Encodes.decodeBase64(content);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}*/

	/**
	 * encrypt:【加密】. <br/>
	 * @param content 加密的内容
	 * @param key 加密key
	 */
/*	public static String encrypt(String content) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(DEFAULT_KEY.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(DEFAULT_KEY.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		byte[] encryptbyte = cipher.doFinal(content.getBytes());
		return new String(Encodes.encodeBase64(encryptbyte));
	}*/

	/**
	 * encrypt:【加密】. <br/>
	 * @param content 加密的内容
	 * @param key 加密key
	 */
/*	public static String encrypt(String content, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		byte[] encryptbyte = cipher.doFinal(content.getBytes());
		return new String(Encodes.encodeBase64(encryptbyte));
	}
	*/
}
