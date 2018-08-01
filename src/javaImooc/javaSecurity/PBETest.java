package javaImooc.javaSecurity;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;

/**
 * @Author:Donlin
 * @Description: 实现了PEB加密算法（Password Based Encryption）基于口令加密，PBE算法结合了消息摘要算法和对称加密算法的优点
 * @Date: Created in 16:17 2018/1/2
 * @Version: 1.0
 */
public class PBETest {

    private static String src = "imooc security pbewithmd5anddes";

    public static void main(String[] args) {
        jdkPBE();
    }

    /**
     * @Description: 通过jdk实现PBEwithMD5andDES这个方案
     * @Params:
     * @return:
     */
    public static void jdkPBE(){
        try {
            //初始化“盐”salt，就是一个安全的随机数
            SecureRandom random = new SecureRandom();
            byte[] salt = random.generateSeed(8);

            //设置一个口令，并转换成密钥
            String password = "imooc";
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());

            //实例化一个密钥工厂以生成密钥
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
            Key key =secretKeyFactory.generateSecret(pbeKeySpec);

            //设置一些加密的PBE参数
            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt,100);

            //实例化密码本cipher
            Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.ENCRYPT_MODE,key,pbeParameterSpec);//加密
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk pbe encrypt:"+ Hex.encodeHexString(result));

            cipher.init(Cipher.DECRYPT_MODE,key,pbeParameterSpec);//解密
            result = cipher.doFinal(result);
            System.out.println("jdk pbe decrypt:"+new String(result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
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
