package javaImooc.EasySimple;

import java.sql.*;

/**
 * @Author:Donlin
 * @Description: 连接数据库的编码测试
 * @Date: Created in 16:47 2018/3/19
 * @Version: 1.0
 */
public class JDBCTest {

    private static final String HOST = "222.201.145.185";
    private static final String DATABASE = "mycat_185";
    private static final String URL = "jdbc:mysql://" + HOST + "/" + DATABASE;
    private static final String USER = "dlhe";
    private static final String PASSWORD = "donlin";
    private static Connection connection = null;

    public static void main(String[] args) {
        try {
            //加载JDBC-mysql驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            connection = DriverManager.getConnection(URL,USER, PASSWORD);
            //获取数据库声明statement
            Statement statement = connection.createStatement();
            //执行SQL语句，并获取结果集
            String selectSQL = "select * from test";
            ResultSet resultSet = statement.executeQuery(selectSQL);

            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
            statement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                //关闭数据库连接流
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
