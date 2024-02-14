package com.itheima.mapper;

import com.itheima.pojo.Role;

// 关于角色信息的处理
public interface RoleMapper {

    // 1.根据角色id,查询对应的角色和用户信息
    Role selectRoleAndUserById(int id);
}
