package com.itheima;

import com.itheima.mapper.UserMapper;
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
//
//    @Test
//    public void test01() throws IOException {
//        // 测试一下MyBatis框架的搭建情况
//        // 1.标记mybatis的配置环境
//        String resource = "mybatis-config.xml";
//        // 2.加载配置环境的信息
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 4.从连接池获取连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 5.获取执行sql语句的对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        // 6.调用方法，执行SQL语句
//        List<User> userList = userMapper.selectAll();
//        // 7.释放资源
//        sqlSession.close();
//        userList.forEach(System.out::println);
//    }
//
//    @Test
//    public void test02() throws IOException {
//        // 测试一下MyBatis框架的搭建情况
//        // 1.标记mybatis的配置环境
//        String resource = "mybatis-config.xml";
//        // 2.加载配置环境的信息
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 4.从连接池获取连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 5.获取执行sql语句的对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        // 6.调用方法，执行SQL语句
//        User user = userMapper.selectById(4);
//        System.out.println("user = " + user);
//        // 7.释放资源
//        sqlSession.close();
//    }
    /*
    * 在MyBatis框架里面，增删改是不会自动提交事务的
    *
    * */
    @Test
    public void test03() throws IOException {
        // 测试一下MyBatis框架的搭建情况
        // 1.标记mybatis的配置环境
        String resource = "mybatis-config.xml";
        // 2.加载配置环境的信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 4.从连接池获取连接
        // 4.1 可以设置自动提交openSession(true);
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        // userMapper.deleteById2(4);
        userMapper.deleteById(1);
        // 6.1 需要手动提交事务
        // sqlSession.commit();
        // 7.释放资源
        sqlSession.close();
    }

    @Test
    public void test04() throws IOException {
        // 测试一下MyBatis框架的搭建情况
        // 1.标记mybatis的配置环境
        String resource = "mybatis-config.xml";
        // 2.加载配置环境的信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 4.从连接池获取连接
        // 4.1 可以设置自动提交openSession(true);
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        User user = new User(1, "玉皇大帝", Date.valueOf("1900-01-01"), "男", "云霄殿");
        userMapper.update(user);
        // 6.1 需要手动提交事务
        sqlSession.commit();
        // 7.释放资源
        sqlSession.close();
    }
//
    @Test
    public void test05() throws IOException {
        // 测试一下MyBatis框架的搭建情况
        // 1.标记mybatis的配置环境
        String resource = "mybatis-config.xml";
        // 2.加载配置环境的信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 4.从连接池获取连接
        // 4.1 可以设置自动提交openSession(true);
        // SqlSession sqlSession = sqlSessionFactory.openSession(true);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.调用方法，执行SQL语句
        User user = new User(8, "高晓晨", Date.valueOf("1993-01-01"), "男", "旧厂街");
        System.out.println("user.getId() = " + user.getId());
        userMapper.add(user);
        // 返回自增的主键提供给后续的操作，比如注册后的自动登录场景
        System.out.println("user.getId() = " + user.getId());
        // 查询id对应的对象信息，做登录操作
        // userMapper.selectById(user.getId());
        // 6.1 需要手动提交事务
        sqlSession.commit();
        // 7.释放资源
        sqlSession.close();
    }
    @Test
    public void test06() throws IOException {
        // 测试一下MyBatis框架的搭建情况
        // 1.标记mybatis的配置环境
        String resource = "mybatis-config.xml";
        // 2.加载配置环境的信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 4.从连接池获取连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5.获取执行sql语句的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.执行方法
        // 方案一：
        // List<User> userList = userMapper.selectByCondition("%启%", "男");
        // 方案二:
        // User user = new User();
        // user.setUsername("%启%");
        // user.setSex("男");
        // List<User> userList = userMapper.selectByCondition(user);

        // 方案三
        Map<String,Object> map = new HashMap<>();
        map.put("username","%启%");
        map.put("sex","男");
        List<User> userList = userMapper.selectByCondition(map);
        // 6.1 需要手动提交事务
        // sqlSession.commit();
        // 7.释放资源
        sqlSession.close();

        userList.forEach(System.out::println);
    }
//
//    @Test
//    public void test07() throws IOException {
//        // 测试一下MyBatis框架的搭建情况
//        // 1.标记mybatis的配置环境
//        String resource = "mybatis-config.xml";
//        // 2.加载配置环境的信息
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 4.从连接池获取连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 5.获取执行sql语句的对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        // 6.调用方法，执行SQL语句
//        // select * from user where username like ? and sex = ?;
//        // List<User> userList = userMapper.selectByIf("%启%", "男");
//        // select * from user where username like ?
//        // List<User> userList = userMapper.selectByIf("%启%", null);
//        // select * from user where username like ?
//        // List<User> userList = userMapper.selectByIf("%启%", "");
//        // select * from user where
//       //List<User> userList = userMapper.selectByIf("", "");
//        // select * from user where and sex = ?;
//        // select * from user WHERE sex = ?;
//        List<User> userList = userMapper.selectByIf("","");
//       userList.forEach(System.out::println);
//        // 7.释放资源
//        sqlSession.close();
//
//        for (User user : userList) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void test08() throws IOException {
//        // 测试一下MyBatis框架的搭建情况
//        // 1.标记mybatis的配置环境
//        String resource = "mybatis-config.xml";
//        // 2.加载配置环境的信息
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 4.从连接池获取连接
//        // 4.1 可以设置自动提交openSession(true);
//        // SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 5.获取执行sql语句的对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        // 6.调用方法，执行SQL语句
//        User user = new User();
//        user.setId(10);
//        user.setUsername("高启兰");
//        user.setSex("女");
//        user.setBirthday(Date.valueOf("2005-01-01"));
//        // update user set username=?,birthday=?, sex=?,address=? where id = ?;
//        // update user SET username=?, sex=? where id = ?;
//        userMapper.updateByIf(user);
//        // 6.1 需要手动提交事务
//        sqlSession.commit();
//        // 7.释放资源
//        sqlSession.close();
//    }
//
//    @Test
//    public void test09() throws IOException {
//        // 测试一下MyBatis框架的搭建情况
//        // 1.标记mybatis的配置环境
//        String resource = "mybatis-config.xml";
//        // 2.加载配置环境的信息
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 4.从连接池获取连接
//        // 4.1 可以设置自动提交openSession(true);
//        // SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 5.获取执行sql语句的对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        // 6.调用方法，执行SQL语句
//        // userMapper.deleteById2(4);
//        userMapper.deleteByArray(new int[]{6,7,10});
//        // 6.1 需要手动提交事务
//        sqlSession.commit();
//        // 7.释放资源
//        sqlSession.close();
//    }
//
//    @Test
//    public void test10() throws IOException {
//        // 测试一下MyBatis框架的搭建情况
//        // 1.标记mybatis的配置环境
//        String resource = "mybatis-config.xml";
//        // 2.加载配置环境的信息
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 4.从连接池获取连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 5.获取执行sql语句的对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        // 6.调用方法，执行SQL语句
//        // select * from user WHERE sex = '女' otherwise
//        // select * from user WHERE sex = '男' when sex == 0
//        // select * from user WHERE sex = '女'
//        List<User> userList = userMapper.selectBySex(1);
//        userList.forEach(System.out::println);
//        // 7.释放资源
//        sqlSession.close();
//    }
//
//    @Test
//    public void test11() throws IOException {
//        // 测试一下MyBatis框架的搭建情况
//        // 1.标记mybatis的配置环境
//        String resource = "mybatis-config.xml";
//        // 2.加载配置环境的信息
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        // 4.从连接池获取连接
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        // 5.获取执行sql语句的对象
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        // 6.调用方法，执行SQL语句
//        List<User> userList = userMapper.selectBySQL();
//        userList.forEach(System.out::println);
//        // 7.释放资源
//        sqlSession.close();
//    }
}
