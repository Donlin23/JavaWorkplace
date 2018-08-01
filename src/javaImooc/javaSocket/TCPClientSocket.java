package javaImooc.javaSocket;

import java.io.*;
import java.net.Socket;

/**
 * @Author:Donlin
 * @Description: 基于TCP协议的Socket通信，实现用户登录；客户端
 * @Date: Created in 19:22 2018/1/22
 * @Version: 1.0
 */
public class TCPClientSocket {

    public static void main(String[] args) {
        try {
            //1.创建客户端Socket，指定服务器地址和端口
            Socket socket = new Socket("localhost",8888);
            //2.获取输出流，向服务器端发送信息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("用户名：admin；密码：123");
            printWriter.flush();
            socket.shutdownOutput();

            //3.获取输入流，并读取服务器端的响应信息
            InputStream inputStream =socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            //循环读取输入流
            while((info=bufferedReader.readLine())!=null){
                System.out.println("data:"+info);
            }
            socket.shutdownInput();//关闭输入流

            //3.关闭资源
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
