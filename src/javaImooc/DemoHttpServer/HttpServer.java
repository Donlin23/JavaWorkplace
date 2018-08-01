package javaImooc.DemoHttpServer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author:Donlin
 * @Description: 一个简单的HttpServer服务端实例
 * @Date: Created in 21:56 2018/2/7
 * @Version: 1.0
 */
public class HttpServer {
    public static  final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutdown = false;

    public static void main(String[] args){
        //创建一个HTTP服务器实例
        HttpServer server = new HttpServer();
        //循环监听HTTP请求，并作出响应
        server.await();
    }

    public void await(){
        ServerSocket serverSocket = null;
        int port = 8888;
        //绑定IP地址和端口
        try {
            serverSocket = new ServerSocket(port,1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while(!shutdown){
            Socket socket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                //获取HTTP请求的socket
                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();

                //创建Request对象，获取请求传过来的数据
                Request request = new Request(inputStream);
                request.parse();

                //创建Response对象，响应Request对象的请求
                Response response = new Response(outputStream);
                response.setRequest(request);
                response.sendStaticResource();

                //关闭请求的socket
                socket.close();

                //在地址栏输入这个“/SHUTDOWN”就关闭了这个循环
                shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }

    }
}
