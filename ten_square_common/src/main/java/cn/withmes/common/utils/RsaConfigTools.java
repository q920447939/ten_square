package cn.withmes.common.utils;

import javax.crypto.Cipher;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * DESC: RSA 非对称加密
 * @DATE 2015年8月11日下午3:01:50
 * 
 */
public class RsaConfigTools{
	
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
 
    private static final String PUBLIC_KEY_STRING = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALZ2HOMX/xlnB72kaEuom"
    		+ "7Tu4CPE8c9Mc6Z/c6gQMt4gOZNE6wo9tBIravL/9Ihe9I86AfhrfZL72czJOno6XXECAwEAAQ==";
    private static final String PRIVATE_KEY_STRING = "MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAtnYc"
    		+ "4xf/GWcHvaRoS6ibtO7gI8Txz0xzpn9zqBAy3iA5k0TrCj20Eitq8v/0iF70jzoB+Gt9kvvZzMk6ejpdcQIDAQABAkE"
    		+ "AjAPZKP86F9EzZHisPBrX2aFRSMGR2cTOHp9BLl+32TFNA8IIVUDZ5CWi/xqvktFeztaHUInqGX7QGDhfUVviAQIhAP"
    		+ "U5LaPfkVWzyrovNJ4H3T/H4H5i3ncTZ5XXuMvRSCVhAiEAvnrY5R6aZM7YyXWktWy5yzdM8KPX7py7cB8G3/kZIhECI"
    		+ "AFcq/A5EamUMhAOqxAlowjzpz+MdQfcR7sBU7luFCSBAiB8qpB8XKw2ID84k3uqli9/toDv2nxAGmp+9n+cZT8y0QIg"
    		+ "OanqZ9lJpSpPpcwRb5DiqEasvGGTIMIuZjBJ8qygEVk=";
    
    
    /**
     * DESC: 用公钥加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String key)
            throws Exception {
        // 对公钥解密
        byte[] keyBytes = Base64.base64ToByteArray(key);
 
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
 
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
 
        return cipher.doFinal(data);
    }
 
    /**
     * DESC: 用私钥加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解码
        byte[] keyBytes = Base64.base64ToByteArray(key);
        
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory factory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = factory.generatePrivate(spec);
		Cipher cipher = Cipher.getInstance("RSA");
        try {
		    cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        } catch (InvalidKeyException e) {
            //For IBM JDK,
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) privateKey;
            RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(rsaPrivateKey.getModulus(), rsaPrivateKey.getPrivateExponent());
            Key fakePublicKey = KeyFactory.getInstance("RSA").generatePublic(publicKeySpec);
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, fakePublicKey);
        }

        
        return cipher.doFinal(data);
    }
 
    /**
     * DESC: 用私钥加密
     * @param source
     * @return
     * @throws Exception
     */
    public static String encrypt(String source) throws Exception {
    	byte[] encryptedBytes = encryptByPrivateKey(source.getBytes("UTF-8"), PRIVATE_KEY_STRING);
    	return Base64.byteArrayToBase64(encryptedBytes);
    }
    
    
    /**
     * DESC: 用私钥解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = Base64.base64ToByteArray(key);
 
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
 
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
 
        return cipher.doFinal(data);
    }
 
    /**
     * DESC: 用公钥解密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String key)
            throws Exception {
        // 对密钥解密
        byte[] keyBytes = Base64.base64ToByteArray(key);
 
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
 
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        try {
        	cipher.init(Cipher.DECRYPT_MODE, publicKey);
        } catch (InvalidKeyException e) {
        	//For IBM JDK,
            RSAPublicKey rsaPublicKey = (RSAPublicKey) publicKey;
            RSAPrivateKeySpec spec = new RSAPrivateKeySpec(rsaPublicKey.getModulus(), rsaPublicKey.getPublicExponent());
            Key fakePrivateKey = KeyFactory.getInstance("RSA").generatePrivate(spec);
            cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, fakePrivateKey);
		}
 
        return cipher.doFinal(data);
    }
    
    /**
     * DESC: 用公钥解密
     * @param source
     * @return
     * @throws Exception
     */
    public static String decrypt(String source) throws Exception {
    	byte[] sourceBytes = Base64.base64ToByteArray(source);
    	byte[] decryptBytes = decryptByPublicKey(sourceBytes, PUBLIC_KEY_STRING);
    	return new String(decryptBytes);
    }
    
    /**
     * 初始化密钥 (公钥、密钥)
     * @return
     * @throws Exception
     */
    public static Map<String, String> getKey() throws Exception {
    	
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        //设置 密钥大小
        keyPairGen.initialize(512);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 取得公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 取得私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
 
        Map<String, String> keyMap = new HashMap<String, String>(2);
 
        keyMap.put("public_key", Base64.byteArrayToBase64(publicKey.getEncoded()));
        keyMap.put("private_key", Base64.byteArrayToBase64(privateKey.getEncoded()));
        return keyMap;
    }
    
    /**
     * 用私钥对信息生成数字签名
     * @param data 加密数据
     * @param privateKey 私钥
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = Base64.base64ToByteArray(privateKey);
 
        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
 
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
 
        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
 
        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);
 
        return Base64.byteArrayToBase64(signature.sign());
    }
 
    /**
     * 校验数字签名
     * @param data 加密数据
     * @param publicKey 公钥
     * @param sign 数字签名
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     * 
     */
    public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {
 
        // 解密由base64编码的公钥
        byte[] keyBytes = Base64.base64ToByteArray(publicKey);
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);
 
        // 验证签名是否正常
        return signature.verify(Base64.base64ToByteArray(sign));
    }
    
}