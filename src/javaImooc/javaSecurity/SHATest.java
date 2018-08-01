package javaImooc.javaSecurity;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;

/**
 * @Author:Donlin
 * @Description: 实现SHA家族的算法（安全散列算法）,应用于消息鉴别等，在Http协议中比较多使用，浏览器约定，或者是SSL中应用
 * @Date: Created in 20:32 2018/1/1
 * @Version: 1.0
 */
public class SHATest {
    private static String src = "imooc Security SHA";

    public static void main(String[] args) {
        jdkSHA1();
        bcSHA1();
        bcSHA224();
        bcSHA256();
    }

    /**
     * @Description: 使用jdk实现了SHA1算法，类似于MD5的实现，都MessageDigest类
     * @Params:
     * @return:
     */
    public static void jdkSHA1(){
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA");
            sha.update(src.getBytes());
            byte[] result = sha.digest();
            System.out.println("jdk sha-1:"+Hex.encodeHexString(result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 使用bc实现了SHA1算法，可以通过addProvider的方式进行
     * @Params:
     * @return:
     */
    public static void bcSHA1(){
        try {
            //通过addProvider()方式调用BC的实现
            Security.addProvider(new BouncyCastleProvider());
            MessageDigest sha = MessageDigest.getInstance("SHA","BC");
            sha.getProvider();
            sha.update(src.getBytes());//可以写成sha.digest(src.getBytes())
            byte[] result = sha.digest();
            System.out.println("bc sha-1:"+Hex.encodeHexString(result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }

        //通过BC原生方法调用SHA1的实现
//        Digest digest = new SHA1Digest();
//        digest.update(src.getBytes(),0,src.getBytes().length);
//        byte[] sha1Bytes = new byte[digest.getDigestSize()];
//        digest.doFinal(sha1Bytes,0);
//        System.out.println("BC sha-1:"+ org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
    }

    /**
     * @Description: 通过bc的原生方式实现SHA224算法
     * @Params:
     * @return:
     */
    public static void bcSHA224(){
        Digest digest = new SHA224Digest();
        digest.update(src.getBytes(),0,src.getBytes().length);
        byte[] sha224Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha224Bytes,0);
        System.out.println("bc sha-224:"+ org.bouncycastle.util.encoders.Hex.toHexString(sha224Bytes));
    }

    /**
     * @Description: 通过addProvider()方式调用BC的实现SHA256算法
     * @Params:
     * @return:
     */
    public static void bcSHA256(){
        try {
            // 这里也是通过addProvider()方法调用BC的实现，在jdk的使用中可以先使用update(src)方法将要消息摘要的内容传进去，再使用digest()方法生成摘要
            // 也可以直接通过digest(src)的方法生成摘要
            Security.addProvider(new BouncyCastleProvider());
            MessageDigest sha = MessageDigest.getInstance("SHA256");
            byte[] sha256 = sha.digest(src.getBytes());
            System.out.println("bc sha-256:"+ org.bouncycastle.util.encoders.Hex.toHexString(sha256));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
