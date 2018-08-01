package JVMDemo;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author:Donlin
 * @Description: 本机直接内存溢出异常测试，使用unsafe分配本机内存
 * @VM_Args: -Xmx20M -XX:MaxDirectMemorySize=10M
 * @Date: Created in 19:48 2018/3/1
 * @Version: 1.0
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
