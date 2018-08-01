package javaNetworkProgramming.URLConnection_7;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * @Author:Donlin
 * @Description: 7.4 返回Http首部
 * @Date: Created in 16:08 2018/3/25
 * @Version: 1.0
 */
public class HeaderViewer {

    private static String url = "http://www.oreilly.com";

    public static void main(String[] args) {
        try {
            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            System.out.println("Content-type:" + uc.getContentType());
            if (uc.getContentEncoding() != null){
                System.out.println("Content-encoding:" + uc.getContentEncoding());
            }
            if (uc.getDate() != 0){
                System.out.println("Date:" + new Date(uc.getDate()));
            }
            if (uc.getLastModified() != 0){
                System.out.println("Last modified:" + new Date(uc.getLastModified()));
            }
            if (uc.getExpiration() != 0){
                System.out.println("Expiration date:" + new Date(uc.getExpiration()));
            }
            if (uc.getContentLength() != -1){
                System.out.println("Content-length:" + uc.getContentLength());
            }
        } catch (MalformedURLException e) {
            System.err.println(url + " is not a URL I understand.");
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
