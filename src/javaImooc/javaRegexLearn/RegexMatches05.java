package javaImooc.javaRegexLearn;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
*  appendReplacement()方法和appendTail()方法的使用，用于文本替换
*  @from：www.runoob.com
 */

public class RegexMatches05 {
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoob";
    private static String REPLACE = "-";
    public static void main(String args[]){
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
