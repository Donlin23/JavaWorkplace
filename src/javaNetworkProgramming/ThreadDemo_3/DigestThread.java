package javaNetworkProgramming.ThreadDemo_3;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author:Donlin
 * @Description: 通过继承Thread类重写run()方法，为指定文件计算一个256Wie的SHA-2消息摘要
 * @Date: Created in 12:29 2018/3/17
 * @Version: 1.0
 */
public class DigestThread extends Thread{
    private String fileName;

    public DigestThread(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            FileInputStream in = new FileInputStream(fileName);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(in,sha);
            while(din.read()!=-1){

            }
            din.close();
            byte[] digest = sha.digest();
            StringBuilder result = new StringBuilder(fileName);
            result.append(": ");
            result.append(DatatypeConverter.printHexBinary(digest));
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        for (String fileName : args){
            Thread t = new DigestThread(fileName);
            t.start();
        }
    }

}
