package javaNetworkProgramming.ClientSocket_8;

import java.io.*;
import java.net.Socket;

/**
 * @Author:Donlin
 * @Description: 8.4 一个基于网络的英语-拉丁语翻译程序 dict协议
 * @Date: Created in 9:49 2018/3/26
 * @Version: 1.0
 */
public class DictClient {

    public static final String SERVER = "dict.org";
    public static final int PORT = 2628;
    public static final int TIMEOUT = 15000;

    public static void main(String[] args) {
        Socket socket = null;

        try {
            socket = new Socket(SERVER, PORT);
            socket.setSoTimeout(TIMEOUT);
            OutputStream out = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(out,"UTF-8");
            writer = new BufferedWriter(writer);
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in,"UTF-8"));
            for (String word : args){
                define(word,writer,reader);
            }

            writer.write("quit\r\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally { //释放socket资源
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void define(String word, Writer writer,BufferedReader reader) throws IOException {
        writer.write("DEFINE fd-eng-lat " + word + "\r\n");
        writer.flush();

        for (String line = reader.readLine(); line != null; line = reader.readLine()){
            if (line.startsWith("250")){  // OK
                return;
            }else if (line.startsWith("552")){ //无匹配
                System.out.println("No definition found for " + word);
                return;
            }else if (line.matches("\\d\\d\\d .*")){
                continue;
            }else if (line.trim().equals(".")){
                continue;
            }else {
                System.out.println(line);
            }

        }
    }


}
