package javaImooc.javaRegexLearn;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
* matches()方法和lookingAt()方法的比较
* @from： www.runoob.com
 */

public class RegexMatches03 {
    private static final String REGEX = "foo";
    private static final String INPUT01 = "foooooooooooooooooo";
    private static final String INPUT02 = "ooooooofooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher1;
    private static Matcher matcher2;

    public static void main(String args[]){
        pattern = Pattern.compile(REGEX);
        matcher1 = pattern.matcher(INPUT01);
        matcher2 = pattern.matcher(INPUT02);

        System.out.println("Current REGEX is:" + REGEX);
        System.out.println("Current INPUT01 is:" + INPUT01);
        System.out.println("Current INPUT02 is:" + INPUT02);

        System.out.println("lookingAt(): " + matcher1.lookingAt());
        System.out.println("matches(): " + matcher1.matches());
        System.out.println("lookingAt(): " + matcher2.lookingAt());
    }
}
