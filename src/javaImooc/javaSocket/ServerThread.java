package javaImooc.javaSocket;

import java.io.*;
import java.net.Socket;

/**
 * @Author:Donlin
 * @Description:
 * @Date: Created in 19:44 2018/1/22
 * @Version: 1.0
 */
public class ServerThread extends Thread {
    //和本线程相关的Socket
    Socket socket = null;

    /**
     * 带参数的构造方法
     * @param socket
     */
    ServerThread(Socket socket){
        this.socket = socket;
    }

    /**
     * 线程执行的操作，响应客户端的请求
     */
    @Override
    public void run() {
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        OutputStream outputStream = null;
        PrintWriter printWriter = null;

        try {
            //获取输入流，并读取客户端信息
            inputStream = socket.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String info = null;
            while ((info=bufferedReader.readLine())!=null){
                System.out.println("我是服务器，客户端说："+info);
            }
            socket.shutdownInput();//关闭输入流
            //获取输出流，响应客户端的请求
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(outputStream);
            printWriter.write("欢迎您！");
            printWriter.flush();//调用flush()方法将缓冲输出
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStream != null) {
                    inputStreamReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
