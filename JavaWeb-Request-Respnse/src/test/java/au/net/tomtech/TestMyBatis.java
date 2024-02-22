package au.net.tomtech;

import au.net.tomtech.mapper.UserMapper;
import au.net.tomtech.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        User user = userMapper.selectByName("zhangsan");
        //释放资源
        sqlSession.close();
        System.out.println(user);
    }
}
