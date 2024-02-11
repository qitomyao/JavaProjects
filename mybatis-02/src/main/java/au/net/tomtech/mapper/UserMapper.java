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

    // 8.if条件判断去根据用户名和性别查询用户信息
    List<User> selectByIf(@Param("username") String username,
                          @Param("sex") String sex);
    //9.根据if判断结果修改用户数据
    void updateByIf(User user);

    //10. 批量删除用户 框架默认数组的变量名为array,如果不想使用可以自己设置注解
    void deleteByArray(@Param("ids") int[] ids);

    //11. 根据页面传入的性别查询用户信息 前端可能传入的是 0 代表男 1 代表女
    List<User> selectBySex(int sex);

    //12. 查询抽取的SQL
    List<User> selectBySQL();

    //13. 查询某个字段
    List<String> selectField(@Param("address") String address);

    //14. 查询某个字段
    List<String> selectField2(@Param("address") String address);
}



