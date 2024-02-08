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

    // 2.根据id查询用户信息
    User selectById(int id);

    // 3.根据Id删除用户
    void deleteById(int id);

    // 4.把删除语句写在select标签里，禁止,会导致没有对事务做检查
    void deleteById2(int id);

    // 5.修改用户数据
    void update(User user);

    // 6.添加用户数据
    void add(User user);

    // 7.多参数处理,根据用户的性别和用户姓名(模糊查询)查询用户信息
    // // 方案一:散装的方式 每一个参数都配置@Param注解
    // List<User> selectByCondition(@Param("username") String username,
    //                              @Param("sex") String sex);
    // 方案二:对象参数,把要作为参数的占位符封装成对象，传进去
    // List<User> selectByCondition(User user);

    // 方案三：使用Map键值对传参,要求键要和参数占位符一致
    List<User> selectByCondition(Map<String,Object> map);

    // 8.if条件判断去根据用户名和性别查询用户信息
    List<User> selectByIf(@Param("username") String username,
                                  @Param("sex") String sex);

    // 9.根据if判断结果修改用户数据
    void updateByIf(User user);

    // 10.批量删除用户 框架默认数组的变量名为array,如果不想使用可以自己设置注解
    void deleteByArray(@Param("ids") int[] ids);

    // 11.根据页面传入的性别查询用户信息 前端可能传入的是 0 代表男 1 代表女
    List<User> selectBySex(int sex);

    // 12.查询抽取的SQL
    List<User> selectBySQL();
}
