package au.net.tomtech.mapper;

import au.net.tomtech.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*
    xxxMapper 就是对应 xxx表的数据的增删改查操作
 */
public interface UserMapper {
    //1. 查询User表的所有数据
    List<User> selectAll(); //返回User对象的集合
    //2. 根据id查询用户信息
    User selectById(int id);
    //3. 根据id删除用户
    void deleteById(int id);
    //4. 更新用户
    void update(User user);
    //5. 添加用户
    void add(User user);
    //6. 使用多参数
    //方案五：使用Map键值对传参，要求键和参数位一致
    List<User> selectByCondition(Map<String, Object> map);
}



