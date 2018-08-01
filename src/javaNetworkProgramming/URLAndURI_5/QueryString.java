package javaNetworkProgramming.URLAndURI_5;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author:Donlin
 * @Description: 编码类
 * @Date: Created in 20:10 2018/3/23
 * @Version: 1.0
 */
public class QueryString {
    private StringBuilder query = new StringBuilder();

    public QueryString(){

    }

    public synchronized void add(String name,String value){
        query.append('&');
        encode(name,value);
    }

    public synchronized void encode(String name,String value){
        try {
            query.append(URLEncoder.encode(name,"UTF-8"));
            query.append('=');
            query.append(URLEncoder.encode(value,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getQuery(){
        return query.toString();
    }

    @Override
    public String toString() {
        return getQuery();
    }

    public static void main(String[] args) {
        QueryString qs = new QueryString();
        qs.add("h1","en");
        qs.add("as_q","Java");
        qs.add("as_epq","I/0");
        String url = "http://www.google.com/search?" + qs;
        System.out.println(url);
    }
}
