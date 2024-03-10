package com.itheima.mapper;

import com.itheima.pojo.Brand;

import java.util.List;

import org.apache.ibatis.annotations.Select;

// 这个接口中的方法用于操作brand表
public interface BrandMapper {
    @Select("select * from tb_brand;")
    List<Brand> selectAll();
    // 查询所有品牌

    // 添加品牌
    void add(Brand brand);

    // 根据id查询品牌

    // 修改品牌
}
