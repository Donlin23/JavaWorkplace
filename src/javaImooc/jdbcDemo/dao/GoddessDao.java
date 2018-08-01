package javaImooc.jdbcDemo.dao;

import javaImooc.jdbcDemo.db.DBUtil;
import javaImooc.jdbcDemo.model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author:Donlin
 * @Description: Data Access Object数据访问接口
 * @Date: Created in 10:35 2018/1/5
 * @Version: 1.0
 */
public class GoddessDao {

    /**
     * 往数据库添加一条数据记录
     * @param goddess
     * @return
     */
    public void addOneGoddess(Goddess goddess){
        Connection connection = DBUtil.getConnection();
        String sql = "insert into imooc_goddess" +
                    " (goddess_name,sex,age,birthday,email,mobile," +
                    " create_user,create_date,update_user,update_date,isdel)" +
                    " values("+
                    " ?,?,?,?,?,?,?,current_date(),?,current_date(),?)";

        try {
            //预编译SQL语句
            PreparedStatement ptmt = connection.prepareStatement(sql);

            //根据预编译的SQL语句中的“?”加入相对应的数据
            ptmt.setString(1, goddess.getGoddess_name());
            ptmt.setInt(2, goddess.getSex());
            ptmt.setInt(3,goddess.getAge());
            ptmt.setDate(4,new Date(goddess.getBirthday().getTime()));
            ptmt.setString(5,goddess.getEmail());
            ptmt.setString(6,goddess.getMobile());
            ptmt.setString(7,goddess.getCreate_user());
            ptmt.setString(8,goddess.getUpdate_user());
            ptmt.setInt(9,goddess.getIsDel());

            //执行SQL语句
            ptmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新数据库一条记录
     * @param goddess
     */
    public void updateGoddess(Goddess goddess){
        Connection connection = DBUtil.getConnection();
        String sql = "update imooc_goddess " +
                    " set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
                    " update_user=?,update_date=current_date(),isdel=? " +
                    " where id=? ";

        try {
            //预编译SQL语句
            PreparedStatement ptmt = connection.prepareStatement(sql);

            //根据预编译的SQL语句中的“?”加入相对应的数据
            ptmt.setString(1,goddess.getGoddess_name());
            ptmt.setInt(2,goddess.getSex());
            ptmt.setInt(3,goddess.getAge());
            ptmt.setDate(4,new Date(goddess.getBirthday().getTime()));
            ptmt.setString(5,goddess.getEmail());
            ptmt.setString(6,goddess.getMobile());
            ptmt.setString(7,goddess.getUpdate_user());
            ptmt.setInt(8,goddess.getIsDel());
            ptmt.setInt(9,goddess.getID());

            //执行SQL语句
            ptmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除指定ID的数据记录
     * @param id
     */
    public void delGoddess(Integer id){
        Connection connection = DBUtil.getConnection();
        String sql = "delete from imooc_goddess " +
                    " where id=? ";

        try {
            PreparedStatement ptmt = connection.prepareStatement(sql);

            ptmt.setInt(1,id);

            ptmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有的数据记录
     * @return
     */
    public List<Goddess> queryAll(){
        List<Goddess> result = new ArrayList<Goddess>();

        Connection connection = DBUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from imooc_goddess");

        try {
            PreparedStatement ptmt = connection.prepareStatement(sb.toString());

            ResultSet resultSet = ptmt.executeQuery();

            Goddess goddess = null;

            while(resultSet.next()){
                goddess = new Goddess();
                goddess.setID(resultSet.getInt("id"));
                goddess.setGoddess_name(resultSet.getString("goddess_name"));
                goddess.setAge(resultSet.getInt("age"));
                goddess.setSex(resultSet.getInt("sex"));
                goddess.setBirthday(resultSet.getDate("birthday"));
                goddess.setEmail(resultSet.getString("email"));
                goddess.setMobile(resultSet.getString("mobile"));
                goddess.setCreate_date(resultSet.getDate("create_date"));
                goddess.setCreate_user(resultSet.getString("create_user"));
                goddess.setUpdate_date(resultSet.getDate("update_date"));
                goddess.setUpdate_user(resultSet.getString("update_user"));
                goddess.setIsDel(resultSet.getInt("isDel"));
                result.add(goddess);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据姓名、电话、E-mail查询
     * @param name
     * @param mobile
     * @param email
     * @return
     */
    public List<Goddess> query(String name,String mobile,String email){
        List<Goddess> result = new ArrayList<Goddess>();

        Connection connection =DBUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from imooc_goddess ");
        sb.append(" where goddess_name like ? and like ? and email like ?");

        try {
            PreparedStatement ptmt = connection.prepareStatement(sb.toString());
            ptmt.setString(1,"%"+name+"%");
            ptmt.setString(2,"%"+mobile+"%");
            ptmt.setString(3,"%"+email+"%");
            System.out.println("SQL:"+sb.toString());
            ResultSet resultSet = ptmt.executeQuery();

            Goddess goddess = null;
            while(resultSet.next()){
                goddess = new Goddess();
                goddess.setID(resultSet.getInt("id"));
                goddess.setGoddess_name(resultSet.getString("goddess_name"));
                goddess.setAge(resultSet.getInt("age"));
                goddess.setSex(resultSet.getInt("sex"));
                goddess.setBirthday(resultSet.getDate("birthday"));
                goddess.setEmail(resultSet.getString("email"));
                goddess.setMobile(resultSet.getString("mobile"));
                goddess.setCreate_date(resultSet.getDate("create_date"));
                goddess.setCreate_user(resultSet.getString("create_user"));
                goddess.setUpdate_date(resultSet.getDate("update_date"));
                goddess.setUpdate_user(resultSet.getString("update_user"));
                goddess.setIsDel(resultSet.getInt("isDel"));

                result.add(goddess);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 根据给定的不同元素查询
     * @param params
     * @return
     */
    public List<Goddess> query(List<Map<String,Object>> params){
        List<Goddess> result = new ArrayList<Goddess>();

        Connection connection = DBUtil.getConnection();
        StringBuilder sb = new StringBuilder();
        sb.append("select * from imooc_goddess where 1=1 ");

        if (params!=null && params.size()>0){
            for (int i = 0; i < params.size(); i++) {
                Map<String,Object> map = params.get(i);
                sb.append("and " + map.get("name")+" "+ map.get("rela") + " "+ map.get("value") + " ");
            }
        }

        try {
            PreparedStatement ptmt = connection.prepareStatement(sb.toString());

            System.out.println("SQL:"+sb.toString());

            ResultSet resultSet = ptmt.executeQuery();

            Goddess goddess = null;
            while(resultSet.next()){
                goddess = new Goddess();
                goddess.setID(resultSet.getInt("id"));
                goddess.setGoddess_name(resultSet.getString("goddess_name"));
                goddess.setAge(resultSet.getInt("age"));
                goddess.setSex(resultSet.getInt("sex"));
                goddess.setBirthday(resultSet.getDate("birthday"));
                goddess.setEmail(resultSet.getString("email"));
                goddess.setMobile(resultSet.getString("mobile"));
                goddess.setCreate_date(resultSet.getDate("create_date"));
                goddess.setCreate_user(resultSet.getString("create_user"));
                goddess.setUpdate_date(resultSet.getDate("update_date"));
                goddess.setUpdate_user(resultSet.getString("update_user"));
                goddess.setIsDel(resultSet.getInt("isDel"));

                result.add(goddess);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 根据id查询一条数据
     * @param id
     * @return
     */
    public Goddess queryOne(Integer id){
        Goddess goddess = null;

        Connection connection = DBUtil.getConnection();
        String sql = "select * from imooc_goddess where id=?";

        try {
            PreparedStatement ptmt = connection.prepareStatement(sql);

            ptmt.setInt(1,id);

            ResultSet resultSet = ptmt.executeQuery();

            while(resultSet.next()){
                goddess = new Goddess();
                goddess.setID(resultSet.getInt("id"));
                goddess.setGoddess_name(resultSet.getString("goddess_name"));
                goddess.setAge(resultSet.getInt("age"));
                goddess.setSex(resultSet.getInt("sex"));
                goddess.setBirthday(resultSet.getDate("birthday"));
                goddess.setEmail(resultSet.getString("email"));
                goddess.setMobile(resultSet.getString("mobile"));
                goddess.setCreate_date(resultSet.getDate("create_date"));
                goddess.setCreate_user(resultSet.getString("create_user"));
                goddess.setUpdate_date(resultSet.getDate("update_date"));
                goddess.setUpdate_user(resultSet.getString("update_user"));
                goddess.setIsDel(resultSet.getInt("isDel"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goddess;
    }

}
