package javaNetworkProgramming.ClientSocket_8;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @Author:Donlin
 * @Description: 8.3 时间协议客户端
 * @Date: Created in 9:15 2018/3/26
 * @Version: 1.0
 */
public class Time {

    private static final String HOSTNAME = "time.nist.gov";

    public static void main(String[] args) {
        Date d = null;
        try {
            d = Time.getDateFromNetwork();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("It is " + d);
    }

    public static Date getDateFromNetwork() throws IOException {
        //时间协议设置时间起点为1900年
        //Java Date类起始于1970年。利用这个数字
        //在它们之间进行转换

        long differenceBetweenEpochs = 2208922200L;

        //如果不愿意使用这个魔法数，就取消
        //一下代码的注释，这段代码会直接进行计算
        /*
        TimeZone gmt = TimeZone.getDefault("GMT");
        Calendar epoch1900 = Calendar.getInstance(gmt);
        epoch1900.set(1900,01,01,00,00,00);
        long epoch1900ms = epoch1900.getTime().getTime();
        Calendar epoch1970 = Calendar.getInstance(gmt);
        epoch1900.set(1970,01,01,00,00,00);
        long epoch1970ms = epoch1900.getTime().getTime();

        long differenceInMS = epoch1900ms - epoch1970ms;
        long differenceBetweenEpochs = differenceInMS/1000;
        */

        Socket socket = null;
        try {
            socket = new Socket(HOSTNAME,37);
            socket.setSoTimeout(15000);
            InputStream raw = socket.getInputStream();
            long secondsSince1900 = 0;
            for (int i = 0; i < 4; i++) {
                secondsSince1900 = (secondsSince1900 << 8) | raw.read();
            }

            long secondsSince1970 = secondsSince1900 - differenceBetweenEpochs;
            long msSince1970 = secondsSince1970 * 1000;
            Date time = new Date(msSince1970);

            return time;
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }//catch
        }//finally
    }
}
