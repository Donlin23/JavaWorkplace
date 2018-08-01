package javaImooc.javaIO;

import java.io.*;

/**
 * @Author:Donlin
 * @Description: 字节字符转换流，通过InputStreamReader、OutputStreamWriter字符流对FileInputStream、FileOutputStream字节流进行转换
 * @Date: Created in 20:18 2018/3/16
 * @Version: 1.0
 */
public class IsrAndOswDemo {
    public static void main(String[] args) throws IOException {
        File demo = new File("FileDemo");

        FileInputStream in = new FileInputStream(demo.getAbsoluteFile()+"\\imooc.txt");
        InputStreamReader isr = new InputStreamReader(in,"UTF-8");
        FileOutputStream out = new FileOutputStream(demo.getAbsoluteFile()+"\\imooc1.txt");
        OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");

        char[] buffer = new char[8 * 1024];
        int c;

        while((c = isr.read(buffer,0,buffer.length))!=-1){
            String s = new String(buffer,0,c);
            System.out.print(s);
            osw.write(buffer,0,c);
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
