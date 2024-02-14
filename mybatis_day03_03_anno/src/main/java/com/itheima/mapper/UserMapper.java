package com.itheima.mapper;

import com.itheima.pojo.Order;
import com.itheima.pojo.User;
import com.itheima.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
* XxxMapper就是对应Xxx表的数据的增删改查操作
*
* */
public interface UserMapper {

    // 1.查询User表的所有数据
    List<User> selectAll();

    // 3.根据id查询用户信息

    // 写了注解的sql就不要有xml里面的sql
    @Select("select * from user where id = #{id}")
    User selectById(int id);

    // 4.根据用id删除用户
    @Delete("delete from user where id = #{id}")
    void deleteById(int id);

    // 5.根据id修改用户
    @Update("update user set username = #{username} where id = #{id}")
    void updateById(User user);

    // 6.添加用户
    @Insert("insert into user values (null,#{username},#{birthday},#{sex},#{address});")
    void add(User user);

    // 7.根据id查询用户信息带有多表查询
    @Select("select * from user where id = #{id}")
    @Results(value = {
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "address",property = "address"),
            @Result(property = "infoData",one = @One(select = "selectInfoById"),column = "id"),
            @Result(property = "orderList",many = @Many(select = "selectOrdersById"),column = "id")
    })
    User selectByIdAndOthers(int id);

    // 8.根据id查询用户扩展信息
    @Select("select * from user_info where id = #{id}")
    UserInfo selectInfoById(int id);

    // 9.根据id查询订单数据
    @Select("select * from `order` where user_id = #{id}")
    List<Order> selectOrdersById(int id);
}
