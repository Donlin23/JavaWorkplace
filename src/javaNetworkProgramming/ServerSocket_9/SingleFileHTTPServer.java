package javaNetworkProgramming.ServerSocket_9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author:Donlin
 * @Description: 9.10 提供同一个文件的HTTP服务器
 * @Date: Created in 10:39 2018/3/27
 * @Version: 1.0
 */
public class SingleFileHTTPServer {
    private static final Logger logger = Logger.getLogger("SingleFileHTTPServer");

    private final byte[] content;
    private final byte[] header;
    private final int port;
    private final String encoding;

    public SingleFileHTTPServer(String data,String encoding,String mimeType,int port) throws UnsupportedEncodingException{
        this(data.getBytes(encoding),encoding,mimeType,port);
    }

    public SingleFileHTTPServer(byte[] data, String encoding, String mimeType, int port) {
        this.content = data;
        this.port = port;
        this.encoding = encoding;
        String header = "HTTP/1.0 200 OK\r\n"
                + "Server: OneFile 2.0\r\n"
                + "Content: " + this.content + "\r\n"
                + "Content-type: " + mimeType + "; charset=" + encoding + "\r\n\r\n";
        this.header = header.getBytes(Charset.forName("US-ASCII"));
    }

    public void start(){
        ExecutorService pool = Executors.newFixedThreadPool(100);
        try(ServerSocket serverSocket = new ServerSocket(this.port)){
            logger.info("Accepting connections on port " + serverSocket.getLocalPort());
            logger.info("Data to be sent:");
            logger.info(new String(this.content,encoding));

            while (true){
                try {
                    Socket connection = serverSocket.accept();
                    pool.submit(new HTTPHandler(connection));
                }catch (IOException ex){
                    logger.log(Level.WARNING ,"Exception accepting connection",ex);
                }catch (RuntimeException ex){
                    logger.log(Level.SEVERE ,"Unexcpetced error",ex);
                }
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE , "Could not start server ",ex);
        }
    }


    /**
     * 私有内部类 HTTPHandler
     */
    private class HTTPHandler implements Callable<Void>{
        private final Socket connetion;

        HTTPHandler(Socket connetion) {
            this.connetion = connetion;
        }

        @Override
        public Void call() throws Exception {
            try {
                OutputStream out = new BufferedOutputStream(connetion.getOutputStream());
                InputStream in = new BufferedInputStream(connetion.getInputStream());

                //只读取第一行，这是我们需要的全部内容
                StringBuilder request = new StringBuilder(80);
                while(true){
                    int c = in.read();
                    if (c == '\r' || c == '\n' || c == -1){
                        break;
                    }
                    request.append((char) c);
                }

                //如果是HTTP/1.0或以后版本，则发送一个MIME首部
                if (request.toString().indexOf("HTTP/") != -1){
                    out.write(header);
                }
                out.write(content);
                out.flush();

            }catch (IOException ex){
                logger.log(Level.WARNING,"Error writing to client",ex);
            }finally {
                connetion.close();
            }
            return null;
        }
    }

    public static void main(String[] args) {

        //设置要监听的端口，本地的80端口被占用了
        int port = 50000;
        //设置编码方式
        String encoding = "UTF-8";
        //设置访问URL
        String pathString = "";

        try {
            Path path = Paths.get(pathString);
            byte[] data = Files.readAllBytes(path);

            String contentType = URLConnection.getFileNameMap().getContentTypeFor(pathString);
            SingleFileHTTPServer server = new SingleFileHTTPServer(data,encoding,contentType,port);
            server.start();
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }

    }




}



