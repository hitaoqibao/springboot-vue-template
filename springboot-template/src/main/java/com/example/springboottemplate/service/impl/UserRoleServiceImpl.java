package com.example.springboottemplate.service.impl;

import com.example.springboottemplate.entity.UserRole;
import com.example.springboottemplate.dao.UserRoleMapper;
import com.example.springboottemplate.service.UserRoleService;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-13
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

  @Autowired
  UserRoleMapper userrolemapper;

  @Override
  public List<UserRole> findUserByIdAll(int userid) {
    // TODO Auto-generated method stub
    List<UserRole> list = userrolemapper.findUserById(userid);
    return list;
  }

}
