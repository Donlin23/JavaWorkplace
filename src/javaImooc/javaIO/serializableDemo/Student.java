package javaImooc.javaIO.serializableDemo;

import java.io.Serializable;

/**
 * @Author:Donlin
 * @Description: 序列化类的演示。一个类实现了序列化的接口，那么其子类都可以进行序列化。
 *                transient 关键字可以屏蔽该字段的序列化
 * @Date: Created in 20:56 2018/3/16
 * @Version: 1.0
 */
public class Student implements Serializable{
    private String stuno;
    private String stuname;
    private int stuage;
    private transient int stugrade;

    public Student(String stuno, String stuname, int stuage) {
        super();
        this.stuno = stuno;
        this.stuname = stuname;
        this.stuage = stuage;
        this.stugrade = 0;
    }

    public String getStuno() {
        return stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public int getStuage() {
        return stuage;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public void setStuage(int stuage) {
        this.stuage = stuage;
    }

    public int getStugrade() {
        return stugrade;
    }

    public void setStugrade(int stugrade) {
        this.stugrade = stugrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuno='" + stuno + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuage=" + stuage +
                ", stugrade=" + stugrade +
                '}';
    }

    /**
     * 自定义序列化的操作
     * @param s
     * @throws java.io.IOException
     */
    private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException{
        s.defaultWriteObject();//把JVM能默认序列化的元素进行序列化操作
        s.writeInt(stugrade);//自己完成stugrage的序列化
    }

    /**
     * 自定义反序列化的操作
     * @param s
     * @throws java.io.IOException
     * @throws ClassNotFoundException
     */
    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException{
        s.defaultReadObject();//把JVM能默认反序列化的元素进行反序列化操作
        this.stugrade = s.readInt();//自己完成stugrade的反序列化操作
    }

}
