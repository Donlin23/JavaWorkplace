package javaImooc.javaJSON;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Donlin
 * @Description: 使用JSON工具构建JSON数据格式
 * JSON 是一种与开发语言无关的、轻量级的数据格式。全程为JavaScript Object Notation.
 * 数据结构：Object、Array
 *      Object - 使用花括号{}包括的键值对结构，Key必须是string类型，value为任何基本类型或数据结构
 *      Array - 使用中括号[]包括，并用逗号来分隔元素
 * 基本类型：string、number、true、false、null
 * @Date: Created in 16:24 2018/1/23
 * @Version: 1.0
 */
public class JSONObjectSample {

    public static void main(String[] args) {
        jsonObject();
        createJSONByMap();
        //createJSONByBean();
    }

    /**
     * JSONObject原生库生成JSON数据格式
     */
    private static void jsonObject(){
        JSONObject wangxiaoer = new JSONObject();
        Object nullObj = null;
        wangxiaoer.put("name","王小二");
        wangxiaoer.put("age",25);
        wangxiaoer.put("birthday","1990-1-10");
        wangxiaoer.put("school","蓝翔");
        wangxiaoer.put("major",new String[]{"理发","挖掘机"});
        wangxiaoer.put("has_girlfriend",false);
        wangxiaoer.put("car",nullObj);
        wangxiaoer.put("house",nullObj);
        wangxiaoer.put("comment","这是一个注释");
        System.out.println(wangxiaoer.toString());

    }

    /**
     * 使用Map去生成JSON数据格式
     */
    private static void createJSONByMap(){
        Map<String,Object> wangxiaoer = new HashMap<String,Object>();
        Object nullObj = null;
        wangxiaoer.put("name","王小二");
        wangxiaoer.put("age",25);
        wangxiaoer.put("birthday","1990-1-10");
        wangxiaoer.put("school","蓝翔");
        wangxiaoer.put("major",new String[]{"理发","挖掘机"});
        wangxiaoer.put("has_girlfriend",false);
        wangxiaoer.put("car",nullObj);
        wangxiaoer.put("house",nullObj);
        wangxiaoer.put("comment","这是一个注释");
        System.out.println(new JSONObject(wangxiaoer).toString());
    }

    /**
     * 使用JavaBean去生成JSON数据
     */
    private static void createJSONByBean(){

    }
}
