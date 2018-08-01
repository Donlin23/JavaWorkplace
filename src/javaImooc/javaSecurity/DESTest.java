package javaImooc.javaSecurity;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

/**
 * @Author:Donlin
 * @Description: DES算法实现,通过jdk自带以及BouncyCastle提供的实现，ps:DES已经淘汰了，一般情况下都不会使用这个对称密码了
 * @Date: Created in 15:20 2018/1/2
 * @Version: 1.0
 */
public class DESTest {

    private static String src = "imooc security des";

    public static void main(String[] args) {
        jdkDES();
        bcDES();
    }

    /**
     * @Description: 使用jdk实现DES算法
     * @Params:
     * @return:
     */
    public static void jdkDES(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");//实例化keyGenerator
            keyGenerator.init(56);//指定密钥长度
            SecretKey secretKey = keyGenerator.generateKey();//生成密钥
            byte[] bytesKey = secretKey.getEncoded(); //获得密钥，转换成字节数组

            DESKeySpec deSKeySpec = new DESKeySpec(bytesKey); //转换成DES适用的KEY
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key desKey = factory.generateSecret(deSKeySpec);

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); //实例化“密码本”Cipher，这是java加解密中非常重要的一个类
            cipher.init(Cipher.ENCRYPT_MODE,desKey); //加密
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk des encrypt:"+ Hex.encodeHexString(result));

            cipher.init(Cipher.DECRYPT_MODE,desKey); //解密
            result = cipher.doFinal(result);
            System.out.println("jdk des decrypt:"+new String(result));

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

    /**
     * @Description: 通过addprovider()方法调用bc的实现
     * @Params:
     * @return:
     */
    public static void bcDES(){
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES","BC");
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] bytesKey = secretKey.getEncoded();

            DESKeySpec deSKeySpec = new DESKeySpec(bytesKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key desKey = factory.generateSecret(deSKeySpec);

            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,desKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("bc des encrypt:"+ Hex.encodeHexString(result));

            cipher.init(Cipher.DECRYPT_MODE,desKey);
            result = cipher.doFinal(result);
            System.out.println("bc des decrypt:"+new String(result));
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
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}
