package au.net.tomtech.mapper;

import au.net.tomtech.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //查询用户
    User select(@Param("username") String username, @Param("password") String password);
    //根据用户名查询用户
    User selectByName(String username);
    //添加用户
    void add(User user);
}
