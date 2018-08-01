package javaNetworkProgramming.URLAndURI_5;

import java.io.*;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:Donlin
 * @Description: 5.12 下载由口令保护的web页面的程序
 * @Date: Created in 21:42 2018/3/24
 * @Version: 1.0
 */
public class SecureSourceViewer {
    public static void main(String[] args) {

        Authenticator.setDefault(new DialogAuthenticator());

        for (int i = 0; i < args.length; i++) {
            try {
                //打开URL进行读取
                URL u = new URL(args[i]);
                try(InputStream in = new BufferedInputStream(u.openStream())){
                    //将InputStream串链到一个Reader
                    Reader r = new InputStreamReader(in);
                    int c;
                    while((c = r.read()) != -1){
                        System.out.println((char) c);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                //e.printStackTrace();
                System.err.println(args[i] + " is not a pasreable URL.");
            }

            //打印一个空行，以分隔页面
            System.out.println();
        }

        //由于我们使用了AWT，所以必须显示退出
        System.exit(0);

    }
}
