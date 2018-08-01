package javaNetworkProgramming.InternetAddress_4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author:Donlin
 * @Description:
 * @Date: Created in 21:58 2018/3/20
 * @Version: 1.0
 */
public class ReverseTest {
    public static void main(String[] args) {
        try {
            InetAddress ia = InetAddress.getByName("www.baidu.com");
            System.out.println(ia);
            System.out.println(ia.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
