package JVMDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Donlin
 * @Description: Java堆内存溢出异常测试，设置虚拟机参数：VM_Args.  注意：CPU温度将升高，慎做！
 * @VM_Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @Date: Created in 15:25 2018/3/1
 * @Version: 1.0
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while(true){
            list.add(new OOMObject());
        }
    }
}
