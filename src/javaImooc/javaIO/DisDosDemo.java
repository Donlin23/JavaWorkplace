package javaImooc.javaIO;

import java.io.*;

/**
 * @Author:Donlin
 * @Description: 数据字节流的输入输出：DataInputStream、DataOutputStream使用
 * @Date: Created in 19:49 2018/3/16
 * @Version: 1.0
 */
public class DisDosDemo {
    public static void main(String[] args) throws IOException {
        String fileName = "FileDemo/dos.dat";
        File file = new File(fileName);

        //DosDemo内容
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
        dos.writeInt(10);
        dos.writeInt(-10);
        dos.writeLong(101);
        dos.writeDouble(10.512);
        //使用UTF8编码
        dos.writeUTF("中国");
        //使用Java编码
        dos.writeChars("中国");
        dos.close();
        IOUtil.printHex(fileName);
        System.out.println();

        //DisDemo内容
        IOUtil.printHexByByteArray(fileName);
        DataInputStream dis = new DataInputStream(new FileInputStream(file));
        int i = dis.readInt();
        System.out.println(i);
        i = dis.readInt();
        System.out.println(i);
        long l = dis.readLong();
        System.out.println(l);
        double d = dis.readDouble();
        System.out.println(d);
        String s = dis.readUTF();
        System.out.println(s);
        dis.close();
    }
}
