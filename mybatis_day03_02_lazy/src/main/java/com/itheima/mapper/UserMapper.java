package com.itheima.mapper;

import com.itheima.pojo.Order;
import com.itheima.pojo.User;
import com.itheima.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/*
* XxxMapper就是对应Xxx表的数据的增删改查操作
*
* */
public interface UserMapper {

    // 1.查询User表的所有数据
    List<User> selectAll();

    // 2.根据id查询用户信息
    User selectById(int id);

    // 3.根据id查询用户的扩展信息
    UserInfo selectInfoById(int id);

    // 4.根据用户id查询Order订单信息
    List<Order> selectOrdersByUid(int uid);

}
