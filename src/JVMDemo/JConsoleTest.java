package JVMDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Donlin
 * @Description: JConsole监视代码，这段代码的作用是以64KB/50ms的速度往Java堆中填充数据，一共填充1000次
 * @VM_Args: -Xms100M -Xmx100M -XX:+UseSerialGC
 * @Date: Created in 9:05 2018/3/12
 * @Version: 1.0
 */
public class JConsoleTest {
    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++){
            //稍作延时，令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
