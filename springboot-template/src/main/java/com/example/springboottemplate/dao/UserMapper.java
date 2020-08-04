package com.example.springboottemplate.dao;

import com.example.springboottemplate.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-13
 */
public interface UserMapper extends BaseMapper<User> {

  User findUser(String username);

  void insertUser(String username, String password);
}
