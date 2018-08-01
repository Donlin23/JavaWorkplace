package javaImooc.javaSecurity;


import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

/**
 * @Author:Donlin
 * @Description: 实现DH算法（一个密钥交换方案）,重点学习！
 *                  DH算法主要用于构建通信双方的密钥参数，不构造加密方案
 * @Date: Created in 21:13 2018/1/2
 * @Version: 1.0
 */
public class DHTest {

    private static String src = "imooc security dh";

    public static void main(String[] args) {
        jdkDH();
    }

    public static void jdkDH(){
        try {
            //1.初始化发送方密钥
            KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH"); //初始化senderkeyPairGenerator
            senderKeyPairGenerator.initialize(512);  //指定密钥长度
            KeyPair senderKeyPair = senderKeyPairGenerator.generateKeyPair(); //生成发送方的密钥对
            byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded(); //获得发送方公钥，发送给接收方（一般通过网络、文件传输...）

            //2.初始化接收方密钥
            KeyFactory senderKeyFactory = KeyFactory.getInstance("DH"); //实例化一个密钥工厂
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc); //获取发送方的公钥（字节数组），转换为X509标准
            PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec); //还原为发送方的公钥
            DHParameterSpec dhParameterSpec = ((DHPublicKey)senderPublicKey).getParams(); //获取发送方公钥的公开参数

            KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");//初始化receiverKeyPairGenerator
            receiverKeyPairGenerator.initialize(dhParameterSpec); //根据发送方公开的参数指定密钥参数
            KeyPair receiverKeyPair = receiverKeyPairGenerator.generateKeyPair(); //生成接收方的密钥对
            byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded(); //获得接收方公钥，发送给发送方

            KeyFactory receiverKeyFactory = KeyFactory.getInstance("DH"); //发送方实例化一个密钥工厂类
            x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc); //获取接收方的公钥（字节数组），转换为X509标准
            PublicKey receiverPublicKey = receiverKeyFactory.generatePublic(x509EncodedKeySpec); //根据接收方的公钥参数生成

            //3.密钥构建（根据密钥协议）
            KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance("DH");//接收方实例化密钥交换协议类
            receiverKeyAgreement.init(receiverKeyPair.getPrivate()); //利用接收方的私钥
            receiverKeyAgreement.doPhase(senderPublicKey,true); //以及发送方的公钥，计算出一个会话密钥参数
            SecretKey receiverDesKey = receiverKeyAgreement.generateSecret("DES");//通过该密钥参数生成一个DES会话密钥

            KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");//发送方实例化密钥交换类
            senderKeyAgreement.init(senderKeyPair.getPrivate()); //利用发送方的私钥
            senderKeyAgreement.doPhase(receiverPublicKey,true); //以及接收方的公钥，计算出一个会话密钥参数
            SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES"); //通过该密钥参数生成一个DES会话密钥

            //验证DH密钥交换协议，发送方的密钥参数和接收方的密钥参数所生成的DES密钥相同
            if(Objects.equals(receiverDesKey,senderDesKey)){
                System.out.println("双方密钥相同");
            }

            //4.加密
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,senderDesKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk dh encrypt:"+ Hex.encodeHexString(result));

            //5.解密
            cipher.init(Cipher.DECRYPT_MODE,receiverDesKey);
            result = cipher.doFinal(result);
            System.out.println("jdk dh decrypt:"+new String(result));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
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
