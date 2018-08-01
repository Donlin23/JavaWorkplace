package javaImooc.javaIO;

/**
 * @Author:Donlin
 * @Description: 编码问题的演示编程
 * @Date: Created in 16:30 2018/3/16
 * @Version: 1.0
 */
public class EncodeDemo {
    public static void main(String[] args)throws Exception {
        String s = "慕课abcdefg";
        byte[]  b = s.getBytes(); //转换成字节序列用的是项目默认的编码gbk
        for(byte b1 : b){
            //把字节转换成以16进制的方式显示
            //utf-8编码中文占用三个字节，英文占用1个字节
            System.out.print(Integer.toHexString(b1 & 0xff) + " ");
        }

        System.out.println();

        //gbk编码中文占用两个字节，英文占用一个字节
        byte[] b2 = s.getBytes("gbk");
        for (byte b1:b2) {
            System.out.print(Integer.toHexString(b1 & 0xff ) + " ");
        }

        System.out.println();

        byte[] b3 = s.getBytes("utf-16be");
        for(byte b1:b3){
            //java是双字节编码utf-16be，中文占用2个字节，英文占用2个字节
            System.out.print(Integer.toHexString(b1 & 0xff)+ " ");
        }
    }
    /*
    文本文件 就是字节序列
    可以是任意编码的字节序列
    如果我们在中文机器上直接创建文本文件，那么该文本文件只认识ansi编码
    * */
}
