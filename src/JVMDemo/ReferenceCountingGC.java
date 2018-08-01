package JVMDemo;

/**
 * @Author:Donlin
 * @Description: 垃圾回收中引用计算算法的缺陷：难以解决对象之间相互循环引用的问题
 * @VM_Args: -XX:+PrintGC
 * @Date: Created in 20:09 2018/3/1
 * @Version: 1.0
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    //这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        //对象之间相互循环引用
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
