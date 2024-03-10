package com.itheima.mapper;

import com.itheima.pojo.Brand;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

// 这个接口中的方法用于操作brand表
public interface BrandMapper {
    @Select("select * from tb_brand;")
    List<Brand> selectAll();
    // 查询所有品牌

    // 添加品牌
    @Insert("insert into tb_brand values(null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void add(Brand brand);

    // 根据id查询品牌
    @Select("select * from tb_brand where id=#{id}")
    Brand selectById(int id);

    // 修改品牌
    @Update("update tb_brand SET brand_Name=#{brandName}, company_Name=#{companyName}, ordered=#{ordered}, description=#{description} where id=#{id}")
    void update(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void delete(int id);
}
