package javaNetworkProgramming.URLAndURI_5;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:Donlin
 * @Description: 5.2 下载一个web界面
 * @Date: Created in 15:33 2018/3/23
 * @Version: 1.0
 */
public class SourceViewer {

    private static String url = "http://www.oreilly.com";

    public static void main(String[] args) {
        if (url.length()>0){
            InputStream in = null;
            try {
                URL u = new URL(url);
                in = u.openStream();
                //缓冲输入以提高性能
                in = new BufferedInputStream(in);
                //将InputStream串链到一个reader
                Reader r = new InputStreamReader(in);
                int c;
                while((c = r.read()) != -1){
                    System.out.print((char) c);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
