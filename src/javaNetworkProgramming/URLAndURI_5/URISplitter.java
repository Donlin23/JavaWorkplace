package javaNetworkProgramming.URLAndURI_5;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @Author:Donlin
 * @Description: 5.6 URI的各部分
 * @Date: Created in 16:44 2018/3/23
 * @Version: 1.0
 */
public class URISplitter {

    //private static String uri = "tel:+1-800-9988-9938";
    private static String uri = "http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc";

    public static void main(String[] args) {
        try {
            URI u = new URI(uri);
            System.out.println("The URI is " + u);
            if (u.isOpaque()){
                System.out.println("This is an opaque URI.");
                System.out.println("The schema is " + u.getScheme());
                System.out.println("The schema specific part is " + u.getSchemeSpecificPart());
                System.out.println("The fragment ID is " + u.getFragment());
            }else {
                System.out.println("This is a hierarchical URI.");
                System.out.println("The schema is " + u.getScheme());
                u = u.parseServerAuthority();
                System.out.println("The host is " + u.getHost());
                System.out.println("The user info is " + u.getUserInfo());
                System.out.println("The port is " + u.getPort());
                System.out.println("The authority is " + u.getAuthority());
                System.out.println("The path is " + u.getPath());
                System.out.println("The query string is " + u.getQuery());
                System.out.println("The fragment ID is " + u.getFragment());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

}
