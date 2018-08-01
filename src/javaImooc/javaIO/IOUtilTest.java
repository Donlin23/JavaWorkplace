package javaImooc.javaIO;

import java.io.File;
import java.io.IOException;

/**
 * @Author:Donlin
 * @Description: IOUtil类的测试内容
 * @Date: Created in 19:20 2018/3/16
 * @Version: 1.0
 */
public class IOUtilTest {
    public static void main(String[] args) {
        File demo = new File("FileDemo");
        if (!demo.exists()){
            demo.mkdir();
        }
        //System.out.println(demo.getAbsolutePath()+"\\File.txt");

        //IOUtilTest1的内容
        System.out.println("IOUtilTest1内容：");
        try {
            IOUtil.printHex(demo.getAbsolutePath()+"\\File.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //IOUtilTest2的内容
        System.out.println("\n\nIOUtilTest2内容：");
        try {
            long start = System.currentTimeMillis();
            IOUtil.printHexByByteArray(demo.getAbsolutePath()+"\\File.txt");
            System.out.println();
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //IOUtilTest3内容
        System.out.println("\n\nIOUtilTest3内容：");
        File srcFile = new File(demo.getAbsolutePath()+"\\File.txt");
        File destFile = new File(demo.getAbsolutePath()+"\\File1.txt");
        try {
            IOUtil.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
