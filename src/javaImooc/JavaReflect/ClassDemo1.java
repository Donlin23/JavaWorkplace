package javaImooc.JavaReflect;

public class ClassDemo1 {
    public static void main(String args[]){
        //Foo 的实例对象如何表示
        Foo foo1 = new Foo();//foo1表示出来了
        //Foo这个类也是一个实例对象，Class类的实例对象，如何表示呢
        //任何一个类都是Class的实例对象，这个实例对象有三种表示方式

        //第一种表示方式，实际告诉我们任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;

        //第二种表示方式 已经知道该类的实例对象可以通过getClass方法调用
        Class c2 = foo1.getClass();

        //c1 c2 都表示了Foo类的类类型（class type）
        System.out.println(c1 == c2);

        //第三种表达方式，动态加载类类型
        Class c3 = null;
        try{
            c3 = Class.forName("javaImooc.JavaReflect.Foo");
        }catch(ClassNotFoundException e ){
            e.printStackTrace();
        }

        System.out.println(c3 == c2);

        //我们完全可以通过类的类类型创建该类的对象实例---->通过c1 or c2 or c3创建Foo的实例对象
        try {
            Foo foo = (Foo)c1.newInstance();//需要有无参数的构造方法
            foo.print();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class Foo{
    void print(){
        System.out.println("foo");
    }
}