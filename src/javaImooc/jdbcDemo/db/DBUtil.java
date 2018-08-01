package javaImooc.jdbcDemo.db;

import java.sql.*;

/**
 * @Author:Donlin
 * @Description: 实现JDBC连接MySQL数据库的简单操作
 * @Date: Created in 9:14 2018/1/5
 * @Version: 1.0
 */
public class DBUtil {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc";
    private static final String USER = "root";
    private static final String PASSWORD = "donlin";
    private static Connection connection = null;

    static {
        try {
            //1.加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 获取一个数据库连接
     * @Params:
     * @return:
     */
    public static Connection getConnection(){
        return connection;
    }

    /**
     * 这是第一次使用JDBC进行连接数据库的实验
     */
//    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc";
//    private static final String USER = "root";
//    private static final String PASSWORD = "donlin";
//
//    public static void main(String[] args) throws Exception {
//        //1.加载驱动程序
//        Class.forName("com.mysql.jdbc.Driver");
//        //2.获得数据库的连接
//        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
//        //3.通过数据库的连接操作数据库，实现增删改查
//        Statement stmt = conn.createStatement();
//        //4.获取结果集
//        ResultSet rs = stmt.executeQuery("select user_name,age from imooc_goddess");
//
//        while (rs.next()){
//            System.out.println(rs.getString("user_name")+","+rs.getInt("age"));
//        }
//    }

}
