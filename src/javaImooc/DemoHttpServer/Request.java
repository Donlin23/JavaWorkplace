package javaImooc.DemoHttpServer;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:Donlin
 * @Description: Request类表示一个HTTP请求，可以传递InputStream对象，来创建Request对象
 * @Date: Created in 9:02 2018/2/8
 * @Version: 1.0
 */
public class Request {
    private InputStream input;
    private String uri;

    /**
     * 构造方法
     * @param input
     */
    public Request(InputStream input){
        this.input = input;
    }

    /**
     * 解析HTTP请求中原始数据
     */
    public void parse(){
        StringBuilder request = new StringBuilder(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            //读取input的数据到buffer，并返回一个长度i
            i = input.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
            i = -1;
        }
        //循环从字节数组中获取字符
        for (int j=0;j<i;j++){
            request.append((char)buffer[j]);
        }
        System.out.print(request.toString());
        uri = parseUri(request.toString());
    }

    /**
     * 解析HTTP请求的uri，请求头的第一个空格和第二个空格之间就是资源目录
     * @param requestString
     * @return
     */
    private String parseUri(String requestString){
        int index1,index2;
        //获取请求头的第一个空格
        index1 = requestString.indexOf(' ');
        if(index1!=-1){
            //获取请求头的第二个空格
            index2 = requestString.indexOf(' ',index1+1);
            if(index2 > index1){
                return requestString.substring(index1+1,index2);
            }
        }
        return null;
    }

    public String getUri(){
        return uri;
    }
}
