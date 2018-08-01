package javaNetworkProgramming.ClientSocket_8;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author:Donlin
 * @Description: 8.6 获得Socket的信息
 * @Date: Created in 11:23 2018/3/26
 * @Version: 1.0
 */
public class SocketInfo {
    public static void main(String[] args) {
        for (String host : args){
            try {
                Socket theSocket = new Socket(host,80);
                System.out.println("Connected to " + theSocket.getInetAddress()
                        + " on port " + theSocket.getPort() + " from port "
                        + theSocket.getLocalPort() + " of "
                        + theSocket.getLocalAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
