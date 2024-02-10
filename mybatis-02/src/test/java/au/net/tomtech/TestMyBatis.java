package au.net.tomtech;

import au.net.tomtech.mapper.EmpMapper;
import au.net.tomtech.mapper.UserMapper;
import au.net.tomtech.pojo.Emp;
import au.net.tomtech.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void test01() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从链接池获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法执行sql语句
        List<User> users = userMapper.selectAll();
        //释放资源
        sqlSession.close();
        System.out.println(users);
    }
    @Test
    public void test02() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从链接池获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取执行sql语句的对象
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        //调用方法执行sql语句
        List<Emp> emps = empMapper.selectAll();
        //释放资源
        sqlSession.close();
        System.out.println(emps);
    }
    @Test
    public void test03() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //从链接池获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法执行sql语句
        User user = userMapper.selectById(4);
        //释放资源
        sqlSession.close();
        System.out.println(user);
    }
    @Test
    public void test04() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true); //开启自动事务后就不需要commit方法
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteById(1);
        sqlSession.commit(); //删除语句默认需要手动提交事务，只有提交事务后才会起作用
        sqlSession.close();
    }
    @Test
    public void test05() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(1, "玉皇大帝", Date.valueOf("1900-01-01"), "男", "云霄宝殿");
        userMapper.update(user);
        sqlSession.commit(); //手动提交事务
        sqlSession.close(); //释放资源
    }
    @Test
    public void test06() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //因为SQL语句中的id是null, 所以这里的id值没有作用
        User user = new User(10, "高启强", Date.valueOf("1970-01-01"), "男", "旧厂街");
        userMapper.add(user);
        //返回自增的主键提供给后续的操作,比如注册后的登陆场景
        System.out.println("user.getId() = "+user.getId());
        //查询id对应的对象信息, 做登陆操作
        //userMapper.selectById(user.getId());
        sqlSession.commit(); //手动提交事务
        sqlSession.close(); //释放资源
    }

    @Test
    public void test07() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //生成SQL语句: select * from user where username like ? and sex = ?;
        //Parameters: %启%(String), 男(String)
        //List<User> userList = userMapper.selectByIf("%启%", "男");

        //生成SQL语句: select * from user;
        List<User> userList = userMapper.selectByIf("", "");
        sqlSession.close();
        userList.forEach(System.out::println);
    }

    @Test
    public void test08() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(9);
        user.setUsername("髙启兰");
        user.setSex("女");
        user.setBirthday(Date.valueOf("2005-01-01"));
        userMapper.update(user);
        sqlSession.commit();
        sqlSession.close();
    }


}


