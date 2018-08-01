package javaImooc.javaSocket;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:Donlin
 * @Description: 学习获取并创建URL实例对象
 * @Date: Created in 18:59 2018/1/22
 * @Version: 1.0
 */
public class URLTest01 {

    public static void main(String[] args) {
        try {
            //创建一个URL实例
            URL imooc = new URL("http://www.imooc.com");
            //?后面表示参数，#后面表示锚点
            URL url = new URL(imooc,"/index.html?username=tom#test");
            System.out.println("协议："+url.getProtocol());
            System.out.println("主机："+url.getHost());
            //如果未指定端口号，则使用默认端口号，此时getPort()方法返回值为-1
            System.out.println("端口："+url.getPort());
            System.out.println("文件路径："+url.getPath());
            System.out.println("文件名："+url.getFile());
            System.out.println("相对路径："+url.getRef());
            System.out.println("查询字符串："+url.getQuery());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
