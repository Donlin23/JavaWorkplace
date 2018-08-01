package javaImooc.javaSecurity;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

/**
 * @Author:Donlin
 * @Description: MAC(Message Authentication Code)消息认证码算法，其实就是消息摘要算法中加入一个密钥的元素，以实现可靠通信的消息鉴别
 *                  通常也称为HMAC算法（keyed-Hash Message Authentication Code）含有密钥的散列函数算法
 * @Date: Created in 20:53 2018/1/1
 * @Version: 1.0
 */
public class MACTest {

    private static String src = "imooc security hmac";

    public static void main(String[] args) {
        jdkHmacMD5();
        bcHmacMD5();
    }

    /**
     * @Description: 通过jdk实现HmacMD5的验证算法
     * @Params:
     * @return:
     */
    public static void jdkHmacMD5(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");//初始化KeyGenerator，为了生成密钥
            SecretKey secretKey = keyGenerator.generateKey();//产生密钥
            byte[] key = secretKey.getEncoded();//获得密钥，一般转换成字节数组形式保存或传输

            SecretKey restoreSecretKey = new SecretKeySpec(key,"HmacMD5");//还原密钥，将字节数组还原成密钥对象
            Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());//实例化MAC
            mac.init(restoreSecretKey);//初始化MAC
            byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());//执行摘要
            System.out.println("jdk hmacMD5:"+ Hex.encodeHexString(hmacMD5Bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 分别通过bc的原生方法和addProvider()方法进行实现HmacMD5
     * @Params:
     * @return:
     */
    public static void bcHmacMD5(){
        //使用addProvider()方法进行调用bc的实现
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5","BC");//初始化KeyGenerator，使用BC作为实现的Provider
            keyGenerator.getProvider();
            SecretKey secretKey = keyGenerator.generateKey();//产生密钥
            byte[] key = secretKey.getEncoded();//获得密钥，一般转换成字节数组形式保存或传输

            SecretKey restoreSecretKey = new SecretKeySpec(key,"HmacMD5");//还原密钥，将字节数组还原成密钥对象
            Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());//实例化MAC
            mac.init(restoreSecretKey);//初始化MAC
            byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());//执行摘要
            System.out.println("bc hmacMD5:"+ Hex.encodeHexString(hmacMD5Bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        //bc原生方法
//        HMac hmac = new HMac(new MD5Digest());
//        hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));//这里使用"aaaaaaaaaa"作为密钥进行消息摘要计算
//        hmac.update(src.getBytes(),0,src.getBytes().length);
//
//        byte[] hmacMD5Bytes = new byte[hmac.getMacSize()];//执行摘要
//        hmac.doFinal(hmacMD5Bytes,0);
//
//        System.out.println("bc hmacMD5:"+ org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
    }
}
