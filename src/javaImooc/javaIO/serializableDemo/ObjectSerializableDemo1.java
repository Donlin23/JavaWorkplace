package javaImooc.javaIO.serializableDemo;

import java.io.*;

/**
 * @Author:Donlin
 * @Description:
 * @Date: Created in 21:01 2018/3/16
 * @Version: 1.0
 */
public class ObjectSerializableDemo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "FileDemo/obj.dat";

        //对象序列化到文件中
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Student stu = new Student("10001","小明",20);
        oos.writeObject(stu);
        oos.flush();
        oos.close();

        //从文件中反序列化成为对象
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//        Student stu = (Student)ois.readObject();
//        System.out.println(stu);
//        ois.close();
    }
}
