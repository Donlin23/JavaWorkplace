package javaNetworkProgramming.URLAndURI_5;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author:Donlin
 * @Description: 5.1 虚拟机支持哪些协议
 * @Date: Created in 15:05 2018/3/23
 * @Version: 1.0
 */
public class ProtocolTester {
    public static void main(String[] args) {
        //超文本传输协议 http
        testProtocol("http://www.abc.org");

        //安全 http https
        testProtocol("https://www.amazon.com/exec/obidos/order2/");

        //文件传输协议 ftp
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq");

        //简单邮件传输协议 mailto
        testProtocol("mailto:elharo@ibiblio.org");

        //远程登录协议 telnet
        testProtocol("telnet://dibner.poly.edu");

        //本地文件访问协议 file
        testProtocol("file:///etc/passwd");

        //gopher
        testProtocol("gopher://gopher.anc.org.za");

        //轻量组目录访问协议 ldap
        testProtocol("ldap://ldap.itd.umich.edu/o=University%20of%20Michigan,c=US?posterAddress");

        //JAR
        testProtocol("jar:http://cafeaulait.org/books/javaio/ioexample/javaio.jar");

        //NFS,网络文件系统
        testProtocol("nfs://utopia.poly.edu.usr/tmp");

        //JDBC定制协议
        testProtocol("jdbc:mysql://luna.ibiblio.org:3306/NEWS");

        //RMI，远程方法调用的定制协议
        testProtocol("rmi://ibiblio.org/RenderEngine");

        //HotJava的定制协议
        testProtocol("doc:/UsersGuide/release.html");
        testProtocol("netdoc:/UsersGuide/release.html");
        testProtocol("systemresource://www.abc.org/+/index.html");
        testProtocol("verbatim:http://www.abc.org");
    }

    /**
     * 测试当前虚拟机是否支持这个url的协议
     * @param url
     */
    private static void testProtocol(String url){
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol()+" is supported.");
        } catch (MalformedURLException e) {
            String protocol = url.substring(0,url.indexOf(":"));
            System.out.println(protocol + " is not supported.");
            //e.printStackTrace();
        }
    }

}
