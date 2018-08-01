package JVMDemo;

/**
 * @Author:Donlin
 * @Description: String.intern()返回引用的测试
 * @Date: Created in 17:30 2018/3/1
 * @Version: 1.0
 */
public class RuntimeConstantPoolTest {
    public static void main(String[] args) {
        //String.intern()返回的是运行时常量池中已经存在的字符，如果没有那么添加进去，如果已经存在，就返回已经存在的那个字符串引用
        String str1= new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1 );

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
