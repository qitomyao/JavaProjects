package com.itheima;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// 封装mybatis的操作代码
public class MyBatisUtils {
    // 3.在外面定义工厂类
    public static SqlSessionFactory sqlSessionFactory = null;

    // 1.抽取的通用代码，每次被使用都只会加载一次
    static{
        try {
            // 测试一下MyBatis框架的搭建情况
            // 1.标记mybatis的配置环境
            String resource = "mybatis-config.xml";
            // 2.加载配置环境的信息
            InputStream inputStream = Resources.getResourceAsStream(resource);
            // 3.根据配置信息，生成sqlSessionFactory对象，相当于连接池
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 2.暴露可以获取sqlSession的方法
    public static SqlSession openSession(){
        return  sqlSessionFactory.openSession();
    }


    // 4.暴露可以获取自动开启事务的sqlSession的方法
    public static SqlSession openSession(boolean autoCommit){
        return  sqlSessionFactory.openSession(autoCommit);
    }
}
