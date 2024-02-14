package com.itheima;

import com.itheima.mapper.RoleMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Role;
import com.itheima.pojo.User;
import javafx.scene.shape.HLineTo;
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
        // 6.调用方法，执行SQL语句
        User user = userMapper.selectById(1);
        // 7.释放资源
        sqlSession.close();
        System.out.println("user = " + user);
    }

    @Test
    public void test03() throws IOException {
        // 1.获取sqlSession
        // 做增删改要提交事务
        SqlSession sqlSession = MyBatisUtils.openSession(true);
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        userMapper.deleteById(3);

        // 手动提交事务
        // sqlSession.commit();
        // 7.释放资源
        sqlSession.close();
    }

    @Test
    public void test04() throws IOException {
        // 1.获取sqlSession
        // 做增删改要提交事务
        SqlSession sqlSession = MyBatisUtils.openSession(true);
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        User user = new User();
        user.setId(4);
        user.setUsername("孟钰");
        userMapper.updateById(user);

        // 手动提交事务
        // sqlSession.commit();
        // 7.释放资源
        sqlSession.close();
    }

    @Test
    public void test05() throws IOException {
        // 1.获取sqlSession
        // 做增删改要提交事务
        SqlSession sqlSession = MyBatisUtils.openSession(true);
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        User user = new User();
        user.setId(null);
        user.setBirthday(Date.valueOf("1999-01-01"));
        user.setUsername("陈书婷");
        user.setSex("女");
        user.setAddress("唐会涛家");
        userMapper.add(user);

        // 手动提交事务
        // sqlSession.commit();
        // 7.释放资源
        sqlSession.close();
    }

    @Test
    public void test06() throws IOException {
        // 1.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        User user = userMapper.selectByIdAndOthers(1);
        // 7.释放资源
        sqlSession.close();
        System.out.println("user = " + user);
    }
}
