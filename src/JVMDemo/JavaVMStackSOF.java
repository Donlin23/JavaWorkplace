package JVMDemo;

/**
 * @Author:Donlin
 * @Description: 虚拟机栈和本地方法栈OOM测试
 * @VM_Args： -Xss128k
 * @Date: Created in 15:59 2018/3/1
 * @Version: 1.0
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args){
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("srack Length:" + oom.stackLength);
            throw e;
        }
    }
}
