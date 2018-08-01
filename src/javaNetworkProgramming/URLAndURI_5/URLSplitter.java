package javaNetworkProgramming.URLAndURI_5;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:Donlin
 * @Description: 5.4 URL的组成部分
 * @Date: Created in 16:15 2018/3/23
 * @Version: 1.0
 */
public class URLSplitter {

    //private static String url = "ftp://mp3:mp3@138.247.121.61:21000/c%3a";
    private static String url = "http://www.oreilly.com";

    public static void main(String[] args) {
        try {
            URL u = new URL(url);
            System.out.println("The URL is " + u);
            System.out.println("The schema is " + u.getProtocol());
            System.out.println("The user info is " + u.getUserInfo());
            System.out.println("The host is " + u.getHost());
            System.out.println("The port is " + u.getPort());
            System.out.println("The path is " + u.getPath());
            System.out.println("The ref is " + u.getRef());
            System.out.println("The query string is " + u.getQuery());
        } catch (MalformedURLException e) {
            System.out.println(url + " is not a URL I understand.");
            e.printStackTrace();
        }
    }
}
