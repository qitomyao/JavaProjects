package com.itheima;

import com.itheima.mapper.OrderMapper;
import com.itheima.mapper.UserMapper;
import com.itheima.pojo.Order;
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

public class TestMyBatis2 {

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
//        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
//        // 6.调用SQL语句
//        List<Order> orderList = orderMapper.selectAll();
//        // 7.释放资源
//        sqlSession.close();
//        orderList.forEach(System.out::println);
//    }

}
