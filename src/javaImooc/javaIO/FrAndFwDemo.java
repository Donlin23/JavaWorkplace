package javaImooc.javaIO;

import java.io.*;

/**
 * @Author:Donlin
 * @Description: 文件读写的字符流FileWriter和FileReader字符流
 * @Date: Created in 20:30 2018/3/16
 * @Version: 1.0
 */
public class FrAndFwDemo {
    public static void main(String[] args) throws IOException {
        //File file = new File("FileDemo\\imoocutf81.txt");
        FileReader fr = new FileReader("FileDemo\\imoocutf81.txt");
        FileWriter fw = new FileWriter("FileDemo\\imoocutf82.txt");

        char[] buffer = new char[2056];
        int c;
        while((c = fr.read(buffer,0,buffer.length))!=-1){
            System.out.print(String.valueOf(buffer));
            fw.write(buffer,0,c);
            fw.flush();
        }
        fr.close();
        fw.close();

    }
}
