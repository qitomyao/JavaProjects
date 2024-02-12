package au.net.tomtech.pojo;

import java.sql.Date;
import java.util.List;

// 封装User表的数据的实体类
public class User {
    private Integer id;
    private String username;
    private Date birthday;  //java.sql.Date;
    private String sex;
    private String address;

    // 一对一查询，把其中的一个对象作为属性放到另一个对象里面
    // 每次添加属性的时候，删除原有的javabean，重新生成一下
    private UserInfo infoData;

    // 添加order的对象属性，一对多
    private List<Order> orderList;

    // 添加Role的对象属性
    private List<Role> roleList;


    public User() {
    }

    public User(Integer id, String username, Date birthday, String sex, String address, UserInfo infoData, List<Order> orderList, List<Role> roleList) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.infoData = infoData;
        this.orderList = orderList;
        this.roleList = roleList;
    }

    /**
     * 获取
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     *
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     *
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     *
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     *
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     *
     * @return infoData
     */
    public UserInfo getInfoData() {
        return infoData;
    }

    /**
     * 设置
     *
     * @param infoData
     */
    public void setInfoData(UserInfo infoData) {
        this.infoData = infoData;
    }

    /**
     * 获取
     *
     * @return orderList
     */
    public List<Order> getOrderList() {
        return orderList;
    }

    /**
     * 设置
     *
     * @param orderList
     */
    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    /**
     * 获取
     *
     * @return roleList
     */
    public List<Role> getRoleList() {
        return roleList;
    }

    /**
     * 设置
     *
     * @param roleList
     */
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", birthday = " + birthday + ", sex = " + sex + ", address = " + address + ", infoData = " + infoData + ", orderList = " + orderList + ", roleList = " + roleList + "}";
    }
}
