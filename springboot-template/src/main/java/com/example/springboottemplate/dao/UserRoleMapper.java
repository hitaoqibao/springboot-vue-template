package com.example.springboottemplate.dao;

import com.example.springboottemplate.entity.UserRole;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户角色关系表 Mapper 接口
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-13
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

  List<UserRole> findUserById(int userid);

}
