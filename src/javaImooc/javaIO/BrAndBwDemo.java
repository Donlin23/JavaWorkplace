package javaImooc.javaIO;


import java.io.*;

/**
 * @Author:Donlin
 * @Description: 过滤器BufferedReader、BufferedWriter字符流，可以对FileReader、FileWriter字符流进行封装，
 *                   也可以对InputStreamReader、OutputStreamWriter进行封装
 * @Date: Created in 20:41 2018/3/16
 * @Version: 1.0
 */
public class BrAndBwDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("FileDemo\\imooc.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("FileDemo\\imooc2.txt"));

        String line;
        while((line = br.readLine())!=null){
            System.out.println(line);
            bw.write(line);
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
