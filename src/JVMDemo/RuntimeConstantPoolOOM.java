package JVMDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Donlin
 * @Description: 运行时常量池导致的内存溢出异常    JDK 1.8没有那两个参数了，1.6之前可以做这个实验
 * @VM_Args： -XX:PermSize=10M -XX:MaxPermSize=1024
 * @Date: Created in 17:20 2018/3/1
 * @Version: 1.0
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        //使用List保持着常量池的引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
