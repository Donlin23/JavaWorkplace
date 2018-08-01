package javaNetworkProgramming.URLConnection_7;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author:Donlin
 * @Description: 7.2 用正确的字符集下载一个web页面
 * @Date: Created in 15:24 2018/3/25
 * @Version: 1.0
 */
public class EncodingAwareSourceViewer {

    private static String url = "http://www.baidu.com";

    public static void main(String[] args) {
        //设置默认编码方式
        String encoding = "ISO-8859-1";
        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            String contentType = uc.getContentType();
            String contentEncoding = uc.getContentEncoding();
            System.out.println(contentType+""+contentEncoding);
            int encodingStart = contentType.indexOf("charset=");//获取“charset”的索引
            System.out.println(encodingStart);
            if (encodingStart != -1) {
                encoding = contentType.substring(encodingStart + 8);//读取的“charset=”后面的内容
            }
            InputStream in = new BufferedInputStream(uc.getInputStream());
            Reader reader = new InputStreamReader(in,encoding);
            int c;
            while((c = reader.read()) != -1){
                System.out.print((char)c);
            }
            reader.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
