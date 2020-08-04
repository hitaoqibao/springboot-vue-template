package com.example.springboottemplate.service.impl;

import com.example.springboottemplate.entity.LoginSuccessInfo;
import com.example.springboottemplate.entity.User;
import com.example.springboottemplate.constant.ShiroConstant;
import com.example.springboottemplate.dao.UserMapper;
import com.example.springboottemplate.service.UserService;
import com.example.springboottemplate.util.RedisUtil;
import com.example.springboottemplate.util.Result;
import com.example.springboottemplate.util.TokenUtil;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Autowired
  UserMapper usermapper;

  @Override
  public User findUserAll(String username) {
    // TODO Auto-generated method stub
    User user = usermapper.findUser(username);
    return user;
  }

  @Override
  public Result getLogin(String username, String password) {
    // TODO Auto-generated method stub
    JSONObject jsonObject = new JSONObject();
    // 用户信息
    User user = usermapper.findUser(username);
    // 账号不存在、密码错误
    if (user == null) {
      return Result.fail("无该用户");
    } else if (!user.getPassword().equals(password)) {
      return Result.fail("密码错误");
    } else {
      String token = TokenUtil.sign(username, user.getId());
      user.setToken(token);
      RedisUtil.set(ShiroConstant.LOGIN_SHIRO_CACHE + user.getId(), user);
      jsonObject.put("token", token);
      return Result.success("登录成功", jsonObject);
    }
  }

  @Override
  public Result getInfo() {
    // TODO Auto-generated method stub
    LoginSuccessInfo loginSuccessInfo = new LoginSuccessInfo("admin", "Super admin",
        "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    return Result.success(loginSuccessInfo);
  }

  @Override
  public Result getlogout() {
    // TODO Auto-generated method stub
    Subject sub = SecurityUtils.getSubject();
    User user = (User) sub.getPrincipal();
    RedisUtil.del(ShiroConstant.LOGIN_SHIRO_CACHE + user.getId(), ShiroConstant.ROLE_SHIRO_CACHE + user.getId());
    sub.logout();
    return Result.success("登出成功");
  }

  @Override
  public boolean checkUsername(String username) {
    // TODO Auto-generated method stub
    User user = usermapper.findUser(username);
    if (user == null) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public Result registerUser(String username, String password) {
    // TODO Auto-generated method stub
    usermapper.insertUser(username, password);
    return Result.success("注册成功");
  }
}
