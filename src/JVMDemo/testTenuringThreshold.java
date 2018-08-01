package JVMDemo;

/**
 * @Author:Donlin
 * @Description: 长期存活的对象进入老年代/动态对象年龄判定 （MaxTenuringThreshold参数设置新生代进入老年代的年龄，默认15）
 * @VM_Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 * @Date: Created in 15:51 2018/3/10
 * @Version: 1.0
 */
public class testTenuringThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        //testTenuringThreshold();
        testTenuringThreshold2();
    }

    /**
     * 长期存活的对象进入老年代
     */
    public static void testTenuringThreshold(){
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4];
        //什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }

    /**
     * 动态对象年龄判定
     */
    public static void testTenuringThreshold2(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        //allocation1+allocation2大于survivor空间一半
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }
}
