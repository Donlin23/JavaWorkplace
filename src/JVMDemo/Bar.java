package JVMDemo;

/**
 * @Author:Donlin
 * @Description: 该测试代码目的是为了使用HSDIS插件，对编译代码进行反汇编
 * @VM_Args: -XX:+PrintAssembly -Xcomp -XX:CompileCommand=dontinline,*Bar.sum -XX:CompileCommand=compileonly,*Bar.sum
 * @Date: Created in 11:38 2018/3/11
 * @Version: 1.0
 */
public class Bar {
    int a = 1;
    static int b = 2;

    public int sum(int c){
        return a + b + c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }
}
