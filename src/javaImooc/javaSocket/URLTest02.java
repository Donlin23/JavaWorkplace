package javaImooc.javaSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:Donlin
 * @Description: 通过URL实例获取URL的数据
 * @Date: Created in 19:08 2018/1/22
 * @Version: 1.0
 */
public class URLTest02 {

    public static void main(String[] args) {
        try {
            //创建一个URL实例
            URL url = new URL("http://www.baidu.com");
            //通过URL的openStream()方法获取URL对象所表示的资源字节输入流
            InputStream inputStream = url.openStream();
            //将字节输入流转换为字符输入流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //为字符输入流添加缓冲
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //读取数据
            String data = bufferedReader.readLine();
            //循环读取数据
            while(data!=null){
                System.out.println(data); //打印数据
                data = bufferedReader.readLine();
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
