package JVMDemo;

/**
 * @Author:Donlin
 * @Description: 新生代 Minor GC ：指发生在新生代的垃圾收集动作，因为Java对象大多数都具备朝生夕灭的特性，所以Minor GC非常频繁，回收速度也比较快
 * @VM_Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @Date: Created in 15:27 2018/3/10
 * @Version: 1.0
 */
public class testAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testAllocation();
    }

    public static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }
}
