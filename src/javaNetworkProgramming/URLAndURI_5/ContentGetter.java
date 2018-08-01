package javaNetworkProgramming.URLAndURI_5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:Donlin
 * @Description:
 * @Date: Created in 15:57 2018/3/23
 * @Version: 1.0
 */
public class ContentGetter {

    private static String url = "http://www.oreilly.com/";

    public static void main(String[] args) {
        if (url.length() > 0){
            try {
                URL u = new URL(url);
                Object o = u.getContent();
                System.out.println("I got a " + o.getClass().getName());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
