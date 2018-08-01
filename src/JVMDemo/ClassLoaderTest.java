package JVMDemo;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author:Donlin
 * @Description: 不同类加载器对instanceof关键字运算的结果影响
 * @Date: Created in 8:45 2018/3/14
 * @Version: 1.0
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            //重写类加载器的加载函数
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".") + 1 ) + ".class";
                InputStream inputStream = getClass().getResourceAsStream(fileName);
                if (inputStream == null){
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("JVMDemo.ClassLoaderTest");

        System.out.println(obj.getClass());
        System.out.println(obj instanceof JVMDemo.ClassLoaderTest);
    }
}
