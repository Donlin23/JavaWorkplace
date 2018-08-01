package javaImooc.javaSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author:Donlin
 * @Description: 实现UDP服务器通信
 * @Date: Created in 20:11 2018/1/22
 * @Version: 1.0
 */
public class UDPServer {

    public static void main(String[] args) {
        try {
            /**
             * 接收客户端发送的数据
             */
            //1.创建服务器端DatagramSocket，指定端口
            DatagramSocket datagramSocket = new DatagramSocket(8888);
            //2.创建数据报，用于接受客户端发送的数据
            byte[] data = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(data,data.length);
            System.out.println("***UDP服务器已启动***");
            //3.接收客户端发送的数据   PS:receive()方法在接收数据报之前会一直阻塞
            datagramSocket.receive(datagramPacket);
            //4.读取数据
            String info = new String(data,0,datagramPacket.getLength());
            System.out.println("我是服务器，客户端说："+info);

            /**
             * 向客户端响应数据
             */
            //1.定义客户端的地址、端口、数据
            InetAddress inetAddress = datagramPacket.getAddress();
            int port = datagramPacket.getPort();
            byte[] data2 = "欢迎您".getBytes();
            //2.创建数据报，包含响应的数据信息
            DatagramPacket datagramPacket1 = new DatagramPacket(data2,data2.length,inetAddress,port);
            //3.响应客户端
            datagramSocket.send(datagramPacket1);
            //4.关闭资源
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
