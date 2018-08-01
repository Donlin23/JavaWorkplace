package javaNetworkProgramming.URLConnection_7;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author:Donlin
 * @Description: 7.1 用URLConnection下载一个web页面
 * @Date: Created in 15:13 2018/3/25
 * @Version: 1.0
 */
public class SourceViewer2 {

    private static String url = "http://www.baidu.com";

    public static void main(String[] args) {
        if (url.length() != 0){
            try {
                //打开URLConnection进行读取
                URL u = new URL(url);
                URLConnection uc = u.openConnection();
                try(InputStream raw = uc.getInputStream()){ //自动关闭
                    InputStream buffer = new BufferedInputStream(raw);
                    //将InputStream串链到一个Reader上
                    Reader reader = new InputStreamReader(buffer);
                    int c;
                    while((c = reader.read()) != -1){
                        System.out.print((char)c);
                    }
                }
            } catch (MalformedURLException e) {
                System.err.println(url + " is not a parseable URL.");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
