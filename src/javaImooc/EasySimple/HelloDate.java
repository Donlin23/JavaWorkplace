package javaImooc.EasySimple;// javaImooc.EasySimple.HelloDate.java
import java.util.*;


/** The first Thinking in Java example program.
 *  Dispalys a string and today"s date.
 *  @author Donlin
 *  @version 1.0
 */

public class HelloDate {
    /** Entry point to class & application.
     * @param args array of string arguments.
     * @throws exceptions No exceptions thrown
     */
    public static void main(String[] args){
        System.out.println("Hello, it's ");
        System.out.println(new Date());

        String str = new String("hello");
        String str1 = str.intern();
        System.out.println(str1 + " "+str);
    }
}
