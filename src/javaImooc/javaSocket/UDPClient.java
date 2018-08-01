package javaImooc.javaSocket;

import java.io.IOException;
import java.net.*;

/**
 * @Author:Donlin
 * @Description: 实现UDP通信的客户端
 * @Date: Created in 20:18 2018/1/22
 * @Version: 1.0
 */
public class UDPClient {

    public static void main(String[] args) {
        try {
            /**
             *  客户端向服务器端发送数据
             */
            //1.定义服务器的地址、端口号、数据
            InetAddress inetAddress = InetAddress.getByName("localhost");
            int port = 8888;
            byte[] data = "用户名：admin;密码：123".getBytes();
            //2.创建数据报，包含发送的数据信息
            DatagramPacket datagramPacket = new DatagramPacket(data,data.length,inetAddress,port);
            //3.创建DatagramSocket对象
            DatagramSocket datagramSocket = new DatagramSocket();
            //4.向服务器端发送数据报
            datagramSocket.send(datagramPacket);

            /**
             * 接收服务器端响应的数据
             */
            //1.创建数据报，用于接受服务器端响应的数据
            byte[] data2 = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(data2,data2.length);
            //2.接收服务器端的数据报
            datagramSocket.receive(datagramPacket1);
            //3.打印数据报的信息
            String reply = new String(data2,0,datagramPacket1.getLength());
            System.out.println("我是客户端，服务器说："+reply);
            datagramSocket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
