package javaImooc.javaSecurity;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * @Author:Donlin
 * @Description: 3-DES算法实现,通过jdk自带以及BouncyCastle提供的实现，
 * @Date: Created in 15:47 2018/1/2
 * @Version: 1.0
 */
public class DESedeTest {

    private static String src = "imooc security 3-des";

    public static void main(String[] args) {
        jdk3DES();
    }

    /**
     * @Description: 通过jdk实现3-DES算法
     * @Params:
     * @return:
     */
    public static void jdk3DES(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");//实例化一个keyGenerator
            //keyGenerator.init(168);
            //SecureRandom()会根据不同的算法生成一个随机的密钥长度
            keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            //一般都是通过SecretKey根据不同的"Spec"后缀的类生成指定算法的密钥
            DESedeKeySpec deSedeKeySpec = new DESedeKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            Key desKey = factory.generateSecret(deSedeKeySpec);

            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,desKey);//加密
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk 3des encrypt:"+ Hex.encodeHexString(result));

            cipher.init(Cipher.DECRYPT_MODE,desKey);//解密
            result = cipher.doFinal(result);
            System.out.println("jdk 3des decrypt:"+new String(result));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
    }

}
