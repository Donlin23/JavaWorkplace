package javaImooc.javaSecurity;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.spec.InvalidParameterSpecException;

/**
 * @Author:Donlin
 * @Description: 实现ElGamal算法，BC提供实现，这个密码算法只提供公钥加密算法
 * @Date: Created in 21:52 2018/1/2
 * @Version: 1.0
 */
public class ElGamalTest {

    private static String src = "imooc security ElGamal";

    public static void main(String[] args) {
        bcElGamal();
    }

    public static void bcElGamal(){
        try {
            //导入加密提供方，因为jdk未实现，所以要默认实现方就是BC
            Security.addProvider(new BouncyCastleProvider());
            AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance("ElGamal"); //实例化AlgorithmParameterGenerator
            algorithmParameterGenerator.init(256); //指定参数生成长度
            AlgorithmParameters algorithmParameters = algorithmParameterGenerator.generateParameters(); //获取参数
            DHParameterSpec dhParameterSpec = algorithmParameters.getParameterSpec(DHParameterSpec.class); //获得最终的参数

            //常规操作，首先实例化keyPairGenerator，根据参数生成keyPair，从keyPair中提取公钥elGamalPublicKey、私钥elGamalPrivateKey
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ElGamal");
            keyPairGenerator.initialize(dhParameterSpec,new SecureRandom());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PublicKey elGamalPublicKey = keyPair.getPublic();
            PrivateKey elGamalPrivateKey = keyPair.getPrivate();
            System.out.println("Public key:"+org.apache.commons.codec.binary.Base64.encodeBase64String(elGamalPublicKey.getEncoded()));
            System.out.println("Privcate key:"+org.apache.commons.codec.binary.Base64.encodeBase64String(elGamalPrivateKey.getEncoded()));

            Cipher cipher = Cipher.getInstance("ElGamal");
            cipher.init(Cipher.ENCRYPT_MODE,elGamalPublicKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("bc ElGamal encrypt with public key:"+ org.apache.commons.codec.binary.Base64.encodeBase64String(result));

            cipher.init(Cipher.DECRYPT_MODE,elGamalPrivateKey);
            result = cipher.doFinal(result);
            System.out.println("bc ElGamal decrypt with private key:"+new String(result));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
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
