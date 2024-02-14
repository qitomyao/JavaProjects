package com.itheima;

import com.itheima.mapper.RoleMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Role;
import com.itheima.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {

    @Test
    public void test01() throws IOException {
        // 1.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        List<User> userList = userMapper.selectAll();
        // 7.释放资源
        sqlSession.close();
        userList.forEach(System.out::println);
    }


    @Test
    public void test02() throws IOException {
        // 1.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语
        User user = userMapper.selectUserAndInfoById(1);
        System.out.println(user);
        // 7.释放资源
        sqlSession.close();
    }

    @Test
    public void test03() throws IOException {
        // 1.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语
        User user = userMapper.selectUserAndOrderById(1);
        System.out.println(user);

        // 单独打印orderList的信息
        user.getOrderList().forEach(System.out::println);
        // 7.释放资源
        sqlSession.close();
    }

    @Test
    public void test04() throws IOException {
        // 1.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语
        User user = userMapper.selectUserAndRoleById(1);
        System.out.println(user);

        // 单独打印orderList的信息
        user.getRoleList().forEach(System.out::println);
        // 7.释放资源
        sqlSession.close();
    }

    @Test
    public void test05() throws IOException {
        // 1.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        // 6.调用方法，执行SQL语
        Role role = roleMapper.selectRoleAndUserById(1);
        System.out.println("role = " + role);

        // 单独打印用户信息
        role.getUserList().forEach(System.out::println);
        // 7.释放资源
        sqlSession.close();
    }
}
