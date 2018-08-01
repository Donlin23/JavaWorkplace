package javaImooc.javaSecurity;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @Author:Donlin
 * @Description: Blowfish加密算法实验，JCE提供了加密的实现。
 * @Date: Created in 10:59 2018/2/6
 * @Version: 1.0
 */
public class BlowfishTest {
    private static String src = "just do it!";

    public static void main(String[] args) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
            keyGenerator.init(64);
            SecretKey secretKey = keyGenerator.generateKey();

            Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            byte[] encryptedBytes = cipher.doFinal(src.getBytes());
            System.out.println("encrypt:"+new String(encryptedBytes));

            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            System.out.println("decrypt:"+new String(decryptedBytes));
            //System.out.println(keyGenerator.getProvider().getName());
        } catch (NoSuchAlgorithmException e) {
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
