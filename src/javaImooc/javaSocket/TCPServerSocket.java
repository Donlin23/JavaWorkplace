package javaImooc.javaSocket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:Donlin
 * @Description: 基于TCP协议的Socket通信，实现用户登录；服务器端
 * @Date: Created in 19:21 2018/1/22
 * @Version: 1.0
 */
public class TCPServerSocket {

    /**
     * 单机环境下最简单的客户端
     * @param args
     */
//    public static void main(String[] args) {
//        try {
//            //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
//            ServerSocket serverSocket = new ServerSocket(8888);
//            //2.调用accept()方法开始监听，等待客户端的连接
//            System.out.println("***服务器即将启动，等待客户端的连接***");
//            Socket socket = serverSocket.accept();
//            //3.获取输入流，并读取客户端信息
//            InputStream inputStream = socket.getInputStream();//字节输入流
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//将字节流转换为字符流
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//为输入流添加缓冲
//            String info = null;
//            //循环读取客户端的信息
//            while((info = bufferedReader.readLine())!=null ){
//                System.out.println("我是服务器，客户端说："+info);
//            }
//            socket.shutdownInput();//关闭输入流
//
//            //4.获取输出流，响应客户端的请求
//            OutputStream outputStream = socket.getOutputStream();
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            printWriter.write("欢迎您！");
//            printWriter.flush();
//
//            //5.关闭资源
//            printWriter.close();
//            outputStream.close();
//
//            bufferedReader.close();
//            inputStreamReader.close();
//            inputStream.close();
//            socket.close();
//            serverSocket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    public static void main(String[] args) {
        try {
            //1.创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = null;
            //记录客户端的数量
            int count = 0;
            System.out.println("***服务器即将启动，等待客户端的连接***");
            //循环监听等待客户端的连接
            while (true){
                //调用accept()方法开始监听，等待客户端的连接
                socket = serverSocket.accept();
                //创建一个新的线程
                ServerThread serverThread = new ServerThread(socket);
                //启动线程
                serverThread.start();
                //计数
                count++;
                System.out.println("客户端的数量："+count);
                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("当前客户端的IP地址："+inetAddress.getHostAddress());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
