package javaImooc.javaRegexLearn;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
*  replaceFirst()方法和replaceAll()方法的使用
*  @from：www.runoob.com
 */
public class RegexMatches04 {
    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow." + "All dogs say meow.";
    private static String REPLACE = "cat";

    public static void main(String args[]){
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }
}
