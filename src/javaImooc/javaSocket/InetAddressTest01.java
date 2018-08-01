package javaImooc.javaSocket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @Author:Donlin
 * @Description: 实现获取InetAddress类实例
 * @Date: Created in 18:50 2018/1/22
 * @Version: 1.0
 */
public class InetAddressTest01 {

    public static void main(String[] args) {
        //获取本机的InetAddress实例
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("计算机名："+inetAddress.getHostName());
            System.out.println("IP地址："+inetAddress.getHostAddress());
            byte[] bytes = inetAddress.getAddress();
            System.out.println("字节数组形式的IP："+ Arrays.toString(bytes));
            System.out.println(inetAddress);

            //根据机器名获取InetAddress实例
            InetAddress inetAddress1 = InetAddress.getByName("DESKTOP-AQBD14H");
            System.out.println("计算机名："+inetAddress1.getHostName());
            System.out.println("IP地址："+inetAddress1.getHostAddress());

            //根据IP地址获取InetAddress实例
            InetAddress inetAddress2 = InetAddress.getByName("192.168.4.2");
            System.out.println("计算机名："+inetAddress2.getHostName());
            System.out.println("IP地址："+inetAddress2.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
