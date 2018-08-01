package javaNetworkProgramming.InternetAddress_4;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * @Author:Donlin
 * @Description: 4.8 列出所有网络接口的程序
 * @Date: Created in 15:17 2018/3/21
 * @Version: 1.0
 */
public class InterfaceLister {
    public static void main(String[] args) throws SocketException, UnknownHostException {
//        InetAddress local = InetAddress.getByName("127.0.0.1");
//        NetworkInterface ni = NetworkInterface.getByInetAddress(local);
//        System.out.println(no);
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()){
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
        }
    }
}
