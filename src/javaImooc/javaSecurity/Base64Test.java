package javaImooc.javaSecurity;


import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * @Author:Donlin
 * @Description: Base64算法学习，分别通过jdk、commonsCodec、BouncyCastle三种方式进行实现
 *                  应用于E-mail、密钥、证书文件等
 * @Date: Created in 15:35 2017/12/29
 * @Version: 1.0
 */
public class Base64Test {

    private static String src = "imooc security base64";

    public static void main(String[] args) {
        jdkBase64();
        commonsCodeBase64();
        bouncyCastleBase64();
    }

    /**
     * @Description: 使用jdk自带包实现Base64算法
     * @Params:
     * @return:
     */
    public static void jdkBase64() {
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(src.getBytes());
        System.out.println("encode:" + encode);

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            System.out.println("decode:" + new String(decoder.decodeBuffer(encode)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 使用commonsCodec工具包实现Base64算法
     * @Params:
     * @return:
     */
    public static void commonsCodeBase64(){
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        System.out.println("encode:"+new String(encodeBytes));

        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        System.out.println("decode:"+new String(decodeBytes));

    }

    /**
     * @Description: 使用bouncyCastles实现Base64算法
     * @Params:
     * @return:
     */
    public static void bouncyCastleBase64(){
        byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("encode:"+new String(encodeBytes));

        byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
        System.out.println("decode:"+new String(decodeBytes));
    }
}
