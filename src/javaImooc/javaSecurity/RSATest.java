package javaImooc.javaSecurity;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Author:Donlin
 * @Description: 实现RSA加密系统
 * @Date: Created in 21:41 2018/1/2
 * @Version: 1.0
 */
public class RSATest {

    private static String src = "imooc security rsa";

    public static void main(String[] args) {
        jdkRSA();
    }

    /**
     * @Description: 使用jdk实现RSA加密系统
     * @Params:
     * @return:
     */
    public static void jdkRSA(){
        try {
            //1.初始化密钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); //实例化keyPairGenerator
            keyPairGenerator.initialize(512); //指定密钥长度
            KeyPair keyPair = keyPairGenerator.generateKeyPair(); //生成密钥对
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic(); //获取RSA公钥
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate(); //获取RSA私钥
            System.out.println("Public Key:"+ org.apache.commons.codec.binary.Base64.encodeBase64String(rsaPublicKey.getEncoded()));
            System.out.println("Private Key:"+ org.apache.commons.codec.binary.Base64.encodeBase64String(rsaPrivateKey.getEncoded()));

            //2.私钥加密、公钥解密——加密
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded()); //私钥privateKey遵循PKCS8标准
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,privateKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("私钥加密、公钥解密——加密："+ org.apache.commons.codec.binary.Base64.encodeBase64String(result));

            //3.私钥加密、公钥解密——解密
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());  //公钥publicKey遵循X509标准
            keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);

            cipher.init(Cipher.DECRYPT_MODE,publicKey);
            result = cipher.doFinal(result);
            System.out.println("私钥加密、公钥解密——解密："+new String(result));

            //4.公钥加密、私钥解密——加密
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            result = cipher.doFinal(src.getBytes());
            System.out.println("公钥加密、私钥解密——加密："+org.apache.commons.codec.binary.Base64.encodeBase64String(result));


            //5.公钥加密、私钥解密——解密
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            result = cipher.doFinal(result);
            System.out.println("公钥加密、私钥解密——解密："+new String(result));



        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
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
