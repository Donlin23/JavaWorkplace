package javaImooc.javaRegexLearn;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
* Pattern类和Matcher类的使用
* @from：www.runoob.com
 */

public class RegexMatches01 {
    public static void main(String args[]){
        String line = "This order was placed for QT3000！OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(line);
        if(m.find()){
            System.out.println("Found value:" + m.group(0));
            System.out.println("Found value:" + m.group(1));
            System.out.println("Found value:" + m.group(2));
            System.out.println("Found value:" + m.group(3));
        }
    }
}
