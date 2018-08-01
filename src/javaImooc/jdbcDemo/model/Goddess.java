package javaImooc.jdbcDemo.model;

import java.util.Date;

/**
 * @Author:Donlin
 * @Description: 模型层，根据数据库imooc中数据表imooc_goddess结构映射
 * @Date: Created in 10:13 2018/1/5
 * @Version: 1.0
 */
public class Goddess {

    private int ID;
    private String goddess_name;
    private Integer sex;
    private Integer age;
    private Date birthday;
    private String email;
    private String mobile;
    private String create_user;
    private String update_user;
    private Date create_date;
    private Date update_date;
    private Integer isDel;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGoddess_name() {
        return goddess_name;
    }

    public void setGoddess_name(String goddess_name) {
        this.goddess_name = goddess_name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        return "Goddess [id = " + ID + ",goddess_name = " + goddess_name +",sex = " + sex
                + ",email = " + email + ",mobile =" + mobile + ",create_user = " + create_user
                + ",update_user = " + update_user + ",create_date = " + create_date + ",update_date"
                + update_date + ",isDel = " + isDel + "]";
    }
}
