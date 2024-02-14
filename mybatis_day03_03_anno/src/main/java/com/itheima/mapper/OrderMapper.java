package com.itheima.mapper;


import com.itheima.pojo.Order;

import java.util.List;

public interface OrderMapper {

    // 1.查询
    List<Order> selectAll();
}
