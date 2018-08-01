package javaNetworkProgramming.InternetAddress_4;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author:Donlin
 * @Description: 4.1 显示www.oreilly.com地址的程序
 * @Date: Created in 21:23 2018/3/20
 * @Version: 1.0
 */
public class OReillyByName {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.oreilly.com");
            System.out.println(address);
        } catch (UnknownHostException e) {
            System.out.println("Could not find www.oreilly.com!");
            e.printStackTrace();
        }
    }
}
