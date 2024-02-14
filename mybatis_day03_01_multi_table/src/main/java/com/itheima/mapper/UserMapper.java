package com.itheima.mapper;

import com.itheima.pojo.User;
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

    // 2.查询用户及其扩展信息
    User selectUserAndInfoById(int id);

    // 3.一对多 查询用户及其名下的订单信息
    User selectUserAndOrderById(int id);

    // 4.多对多，从用户角度看，查询用户及其角色信息
    User selectUserAndRoleById(int id);


}
