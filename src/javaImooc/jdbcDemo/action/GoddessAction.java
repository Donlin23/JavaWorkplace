package javaImooc.jdbcDemo.action;

import javaImooc.jdbcDemo.dao.GoddessDao;
import javaImooc.jdbcDemo.model.Goddess;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Author:Donlin
 * @Description: 业务逻辑层，命名为action
 * @Date: Created in 18:12 2018/1/7
 * @Version: 1.0
 */
public class GoddessAction {

    /**
     * 添加一个女神信息记录
     * @param goddess
     * @throws Exception
     */
    public void add(Goddess goddess) throws Exception{
        GoddessDao dao=new GoddessDao();
        goddess.setSex(1);
        goddess.setCreate_user("ADMIN");
        goddess.setUpdate_user("ADMIN");
        goddess.setIsDel(0);
        dao.addOneGoddess(goddess);
    }

    /**
     * 根据id获取一个女神信息
     * @param id
     * @return
     * @throws SQLException
     */
    public Goddess get(Integer id) throws SQLException {
        GoddessDao dao=new GoddessDao();
        return dao.queryOne(id);
    }

    /**
     * 更新一条女神信息
     * @param goddess
     * @throws Exception
     */
    public void edit(Goddess goddess) throws Exception{
        GoddessDao dao=new GoddessDao();
        dao.updateGoddess(goddess);
    }

    /**
     * 删除一个女神信息
     * @param id
     * @throws SQLException
     */
    public void del(Integer id) throws SQLException{
        GoddessDao dao=new GoddessDao();
        dao.delGoddess(id);
    }

    /**
     * 获取数据库中全部女神信息
     * @return
     * @throws Exception
     */
    public List<Goddess> query() throws Exception{
        GoddessDao dao=new GoddessDao();
        return dao.queryAll();
    }

    /**
     * 获取指定的女神信息
     * @param params
     * @return
     * @throws Exception
     */
    public List<Goddess> query(List<Map<String, Object>> params) throws Exception{
        GoddessDao dao=new GoddessDao();
        return dao.query(params);
    }

}
