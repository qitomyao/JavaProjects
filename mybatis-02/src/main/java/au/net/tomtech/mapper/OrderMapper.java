package au.net.tomtech.mapper;

import au.net.tomtech.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> selectAll();
}
