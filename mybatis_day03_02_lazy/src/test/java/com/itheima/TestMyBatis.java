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
        // System.out.println("user = " + user);

        //打印OrderList数据
        user.getOrderList().forEach(System.out::println);
        // 7.释放资源
        sqlSession.close();
    }

    /*
    * 演示懒加载
    *
    * */
    @Test
    public void test03() throws IOException {
        // 1.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        User user = userMapper.selectById(1);
        // 演示懒加载不要直接打印user,相当于把里面所有的成员变量都用上了
        // System.out.println("user = " + user);

        System.out.println("user.getUsername() = " + user.getUsername());
        // 这是一条华丽的分割线
        System.out.println("----------------------------");
        System.out.println("user.getOrderList() = " + user.getOrderList());
        //打印OrderList数据
        user.getOrderList().forEach(System.out::println);
        // 7.释放资源
        sqlSession.close();
    }

    /*
     * 演示一级缓存
     * */
    @Test
    public void test04() throws IOException {
        // 1.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
        // 一级缓存失效的情况
        // 提交事务，相当于有增删改操作
        // sqlSession.commit();
        // 手动清除缓存
        sqlSession.clearCache();
        // 这是一条华丽的分割线
        System.out.println("----------------------------");
        // 查询一模一样的数据，会直接从一级缓存里面获取内容
        User user1 = userMapper.selectById(1);
        // 查询不一样的数据，会重新访问数据库
        // User user2 = userMapper.selectById(2);
        System.out.println("user1 = " + user1);
        // System.out.println("user2 = " + user2);
        // 7.释放资源
        sqlSession.close();
    }


    /*
    * 演示二级缓存
    * */
    @Test
    public void test05() throws IOException {
        // 1.获取sqlSession
        SqlSession sqlSession = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        List<User> userList = userMapper.selectAll();
        // User user = userMapper.selectById(1); 只要用到二级缓存的类，都需要实现序列化

        // 7.释放资源
        sqlSession.close();

        // 这是一条华丽的分割线
        System.out.println("----------------------------");

        // 1.获取sqlSession
        SqlSession sqlSession2 = MyBatisUtils.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        List<User> userList2 = userMapper2.selectAll();
        // 7.释放资源
        sqlSession2.close();
        userList.forEach(System.out::println);
    }
}
