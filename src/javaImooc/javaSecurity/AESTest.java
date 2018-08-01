package javaImooc.javaSecurity;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * @Author:Donlin
 * @Description: 实现AES算法，AES通常用于移动通信系统加密以及基于SSH协议的软件
 * @Date: Created in 16:08 2018/1/2
 * @Version: 1.0
 */
public class AESTest {

    private static String src = "imooc security aes";

    public static void main(String[] args) {
        jdkAES();
    }

    /**
     * @Description: 通过jdk实现AES算法
     * @Params:
     * @return:
     */
    public static void jdkAES(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");//实例化keyGenerator
            keyGenerator.init(128); //指定密钥长度
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            //AES密钥的转换要简单一些，底层提供SecretKeySpec的构造方法
            Key key = new SecretKeySpec(keyBytes,"AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);//加密
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk aes encrypt:"+ Hex.encodeHexString(result));

            cipher.init(Cipher.DECRYPT_MODE,secretKey);//解密
            result = cipher.doFinal(result);
            System.out.println("jdk aes decrypt:"+new String(result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }
}
