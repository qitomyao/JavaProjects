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
import java.util.List;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis {
    @Test
    public void test01() throws IOException {
        //测试一个MyBatis框架的搭建情况
        //标记Mybatis的配置环境
        String resource ="mybatis-config.xml";
        //加载配置环境的信息, 将xml变成一个输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置信息, 生成sqlSessionFactory对象,相当于连接池
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
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
        //测试一个MyBatis框架的搭建情况
        //标记Mybatis的配置环境
        String resource ="mybatis-config.xml";
        //加载配置环境的信息, 将xml变成一个输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置信息, 生成sqlSessionFactory对象,相当于连接池
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
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
}


