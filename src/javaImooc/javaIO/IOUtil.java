package javaImooc.javaIO;

import java.io.*;

/**
 * @Author:Donlin
 * @Description: FileInputStream和FileOutputStream实践工具
 * @Date: Created in 16:52 2018/3/16
 * @Version: 1.0
 */
public class IOUtil {
    /**
     * 读取指定文件的内容，并按照16进制输出到控制台，每输出10个byte换行
     * @param fileName
     * @throws IOException
     */
    public static void printHex(String fileName)throws IOException{
        //把文件作为字节流进行读操作
        //文件找不到的异常处理
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException("文件"+file.getAbsolutePath()+"找不到");
        }
        FileInputStream in = new FileInputStream(fileName);

        int b;
        int i = 1;
        while((b = in.read())!=-1){
            if (b <= 0xf){
                //单位数前面补0
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + " ");
            //i用作换行的计数
            if ((i++) %10 ==0){
                System.out.println();
            }
        }
        in.close();
    }

    /**
     * 读取指定文件的内容，并按照16进制输入到控制台，每输出10个byte换行，使用字节数组接收数据
     * @param fileName
     * @throws IOException
     */
    public static void printHexByByteArray(String fileName)throws IOException{
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[8 * 1024];

        int bytes = 0;
        int j = 1;//每10行数据的计数标志
        while((bytes = in.read(buf))!=-1){
            for (int i = 0; i < bytes; i++) {
                System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");//加0xff是为了清空高位数据，只保留低8位
                //满10个换行
                if ((j++) %10 ==0){
                    System.out.println();
                }
            }
        }
        in.close();
    }

    /**
     * 复制文件内容，使用FileInputStream、FileOutputStream方式
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFile(File srcFile,File destFile)throws IOException{
        if (!srcFile.exists()){
            throw new IllegalArgumentException("文件 "+srcFile+" 不存在");
        }
        if (!srcFile.isFile()){
            throw new IllegalArgumentException("文件 "+srcFile+"不是一个文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int b;
        while((b = in.read(buf,0,buf.length))!=-1){
            out.write(buf,0,b);
            out.flush();
        }
        in.close();
        out.close();
    }

    /**
     * 复制文件内容，使用缓冲BufferedInputStream、BufferedOutputStream方式
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByBuffer(File srcFile,File destFile)throws IOException{
        if (!srcFile.exists()){
            throw new IllegalArgumentException("文件：" + srcFile + "不存在");
        }
        if (!srcFile.isFile()){
            throw new IllegalArgumentException("文件：" + srcFile + "不是一个文件");
        }
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(destFile));

        int b;
        while((b = bin.read())!=-1){
            bout.write(b);
            bout.flush();
        }
        bin.close();
        bout.close();
    }

    /**
     * 复制文件内容，直接使用字节
     * @param srcFile
     * @param destFile
     * @throws IOException
     */
    public static void copyFileByByte(File srcFile,File destFile)throws IOException{
        if (!srcFile.exists()){
            throw new IllegalArgumentException("文件："+srcFile+"不存在");
        }
        if (!srcFile.isFile()){
            throw new IllegalArgumentException("文件："+srcFile+"不是一个文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);

        int b ;
        while((b = in.read())!=-1){
            out.write(b);
            out.flush();
        }
        in.close();
        out.close();

    }
}
