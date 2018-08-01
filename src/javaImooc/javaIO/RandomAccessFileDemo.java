package javaImooc.javaIO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @Author:Donlin
 * @Description: RamdonAccessFile 类的使用，该类可以随机读取、写入文件的内容，每次写入、读取一个字节
 * @Date: Created in 16:12 2018/3/16
 * @Version: 1.0
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        File demo = new File("FileDemo");
        if (!demo.exists()){
            demo.mkdir();
        }
        File file = new File(demo,"raf.dat");
        if (!file.exists()){
            file.createNewFile();
        }

        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        //指针的位置
        System.out.println(raf.getFilePointer());

        raf.write('A');//只写了一个字节
        System.out.println(raf.getFilePointer());
        raf.write('b');

        int i = 0x7fffffff;
        //用write方法每次只能写一个字节，如果要把i写进去就得写4次
        raf.write(i >>> 24);//高8位
        raf.write(i >>> 16);
        raf.write(i >>> 8);
        raf.write(i);
        System.out.println(raf.getFilePointer());

        //可以写一个int
        raf.writeInt(i);

        String s = "中";
        byte[] gbk = s.getBytes();
        raf.write(gbk);
        System.out.println(raf.length());

        //读文件，必须把指针移到头部
        raf.seek(0);
        //一次性读取，把文件的内容全部读到字节数组中
        byte[] buf = new byte[(int)raf.length()];
        raf.read(buf);

        System.out.println(Arrays.toString(buf));
        for (byte b :buf) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
        }
        raf.close();

    }
}
