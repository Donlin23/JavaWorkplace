package javaImooc.javaSecurity;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * @Author:Donlin
 * @Description: 分别使用jdk、BouncyCastle、CommonsCodeC实现MD2、MD4、MD5算法（Message Digest）消息摘要算法
 *                  jdk只提供MD2和MD5算法的实现，BouncyCastle都实现了MD家族的算法
 * @Date: Created in 19:46 2018/1/1
 * @Version: 1.0
 */
public class MDTest {
    private static String src = "imooc security md";

    public static void main(String[] args) {
        jdkMD2();
        jdkMD5();
        bcMD4();
        bcMD5();
    }

    /**
     * @Description: 使用jdk实现了MD5的算法
     * @Params:
     * @return:
     */
    public static void jdkMD5(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(src.getBytes());
            System.out.println("JDK MD5:"+ Hex.encodeHexString(md5Bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 使用jdk实现了MD2算法
     * @Params:
     * @return:
     */
    public static void jdkMD2(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] md2Bytes = md.digest(src.getBytes());
            System.out.println("JDK MD2:"+ Hex.encodeHexString(md2Bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 使用BouncyCastle实现了MD4算法
     * @Params:
     * @return:
     */
    public static void bcMD4(){
        //Security.addProvider可以动态加载算法的实现方，默认是jdk，当jdk没有提供指定算法的实现时，会查找接下来的实现提供方，配置文件在
        // %JAVA%\jdk1.8.0_131\jre\lib\security\java.security
        try {
            Security.addProvider(new BouncyCastleProvider());
            MessageDigest md = MessageDigest.getInstance("MD4");
            byte[] md4Bytes = md.digest(src.getBytes());
            System.out.println("BC MD4:"+Hex.encodeHexString(md4Bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
          //通过Bouncy Castle中的方法实现MD4算法
//        Digest digest = new MD4Digest();
//        digest.update(src.getBytes(),0,src.getBytes().length);
//        byte[] md4Bytes = new byte[digest.getDigestSize()];
//        digest.doFinal(md4Bytes,0);
//        System.out.println("BC MD4:"+ org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
    }

    /**
     * @Description: 使用BouncyCastle实现了MD5算法
     * @Params:
     * @return:
     */
    public static void bcMD5(){
        Digest digest = new MD5Digest();
        digest.update(src.getBytes(),0,src.getBytes().length);
        byte[] md5Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md5Bytes,0);
        System.out.println("BC MD5:"+ org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
    }

}
