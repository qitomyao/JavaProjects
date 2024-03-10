package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BrandService {
    //查询品牌所有数据
    public List<Brand> selectAll() {
        //1. 链接
        SqlSession sqlSession = MyBatisUtils.openSession();
        //2. 使用sqlSession对象获取BrandMapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //3. 使用BrandMapper进行数据查询 并且返回List<Brand>
        List<Brand> brands = brandMapper.selectAll();
        //4. 关闭链接
        sqlSession.close();
        //5. 返回数据
        return brands;
    }

    public void add(Brand brand)
    {
        //1. 链接
        SqlSession sqlSession = MyBatisUtils.openSession();
        //2. 使用sqlSession对象获取BrandMapper对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        //3. 使用mapper进行数据的添加
        brandMapper.add(brand);
        //4. 提交事物
        sqlSession.commit();
        //5. 关闭链接
        sqlSession.close();
    }

    public Brand selectById(int id)
    {
        SqlSession sqlSession = MyBatisUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = brandMapper.selectById(id);
        sqlSession.close();
        return brand;
    }

    public void update(Brand brand)
    {
        SqlSession sqlSession = MyBatisUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(int id)
    {
        SqlSession sqlSession = MyBatisUtils.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        brandMapper.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }




}

