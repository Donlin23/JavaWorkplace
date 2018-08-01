package javaImooc.DemoHttpServer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Author:Donlin
 * @Description: Response类表示HTTP的一个响应
 * @Date: Created in 9:15 2018/2/8
 * @Version: 1.0
 */
public class Response {
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream outputStream;

    public Response(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    /**
     * 接收一个HTTP请求，并对这个请求做响应处理
     * @param request
     */
    public void setRequest(Request request){
        this.request = request;
    }

    /**
     * 对Request对象发送静态资源
     * @throws IOException
     */
    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];
        //获取目标文件的路径
        FileInputStream fileInputStream = null;
        File file = new File(HttpServer.WEB_ROOT,request.getUri());
        System.out.println("web_root:"+HttpServer.WEB_ROOT + request.getUri());
        try {
            if(file.exists()){
                //读取目标文件，作为响应
                fileInputStream = new FileInputStream(file);
                int ch = fileInputStream.read(bytes,0,BUFFER_SIZE);
                while(ch!=-1){
                    outputStream.write(bytes,0,ch);
                    ch = fileInputStream.read(bytes,0,BUFFER_SIZE);
                }
            }
            else{
                //找不到目标资源文件
                String erroeMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Context-Type:text/html\r\n" +
                        "Context-Length:23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                outputStream.write(erroeMessage.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fileInputStream!=null){
                fileInputStream.close();
            }
        }
    }
}
