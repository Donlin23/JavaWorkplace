package javaNetworkProgramming.InternetAddress_4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author:Donlin
 * @Description: 4.2 查找本地机器的地址
 * @Date: Created in 21:27 2018/3/20
 * @Version: 1.0
 */
public class MyAddress {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            //调用getHostName()才会请求DNS服务器
            //InetAddress inetAddress = InetAddress.getByName("23.75.54.144");
            //System.out.println(inetAddress.getHostName());
            String dottedQuad = address.getHostAddress();
            System.out.println(dottedQuad);
            System.out.println(address);
        } catch (UnknownHostException e) {
            System.out.println("Could not find this computer's address!");
            e.printStackTrace();
        }
    }
}
