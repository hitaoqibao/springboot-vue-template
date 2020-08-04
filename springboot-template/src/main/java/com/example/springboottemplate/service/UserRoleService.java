package com.example.springboottemplate.service;

import com.example.springboottemplate.entity.UserRole;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户角色关系表 服务类
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-13
 */
public interface UserRoleService extends IService<UserRole> {

  List<UserRole> findUserByIdAll(int userid);
}
