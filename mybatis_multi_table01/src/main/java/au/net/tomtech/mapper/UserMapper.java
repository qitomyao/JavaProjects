package au.net.tomtech.mapper;

import au.net.tomtech.pojo.User;

import java.util.List;

/*
* XxxMapper就是对应Xxx表的数据的增删改查操作
*
* */
public interface UserMapper {
    User selectById(int id);
}
