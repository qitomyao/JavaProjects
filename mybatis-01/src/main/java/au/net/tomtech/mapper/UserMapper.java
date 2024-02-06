package au.net.tomtech.mapper;

import au.net.tomtech.pojo.User;

import java.util.List;

/*
    xxxMapper 就是对应 xxx表的数据的增删改查操作
 */
public interface UserMapper {
    //1. 查询User表的所有数据
    List<User> selectAll(); //返回User对象的集合
}



