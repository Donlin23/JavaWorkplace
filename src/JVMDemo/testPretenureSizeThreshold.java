package JVMDemo;

/**
 * @Author:Donlin
 * @Description: 大对象直接进入老年代 （最后一个参数表示超过3M的对象直接进入老年代）
 * @VM_Args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 * @Date: Created in 15:42 2018/3/10
 * @Version: 1.0
 */
public class testPretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }

    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[4 * _1MB];//直接分配在老年代中
    }
}
