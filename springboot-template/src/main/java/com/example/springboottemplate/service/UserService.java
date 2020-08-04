package com.example.springboottemplate.service;

import com.example.springboottemplate.entity.User;
import com.example.springboottemplate.util.Result;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-13
 */
public interface UserService extends IService<User> {

  User findUserAll(String username);

  Result getLogin(String username, String password);

  Result getInfo();

  Result getlogout();

  boolean checkUsername(String username);

  Result registerUser(String username, String password);
}
