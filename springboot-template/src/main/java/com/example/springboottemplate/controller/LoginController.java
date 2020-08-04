package com.example.springboottemplate.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.example.springboottemplate.constant.ShiroConstant;
import com.example.springboottemplate.entity.GetUser;
import com.example.springboottemplate.entity.User;
import com.example.springboottemplate.service.UserService;
import com.example.springboottemplate.util.RedisUtil;
import com.example.springboottemplate.util.TokenUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
@RequestMapping(value = "/user")
public class LoginController {

  @Autowired
  UserService userService;

  /**
   * 登录
   */
  // @RequestMapping(value = "/login", method = RequestMethod.POST)
  // public Map<String, Object> login(String username, String password) {
  // Map<String, Object> result = new HashMap<>();
  // Map<String, Object> gettoken = new HashMap<>();
  // // 用户信息
  // User user = userService.findUserAll(username);
  // // 账号不存在、密码错误
  // if (user == null) {
  // result.put("status", "400");
  // result.put("msg", "无该用户");
  // return result;
  // } else if (!user.getPassword().equals(password)) {
  // result.put("status", "400");
  // result.put("msg", "账号或密码有误");
  // return result;
  // } else {
  // // 生成token，并保存到reids
  // String token = TokenUtil.sign(username, user.getId());
  // user.setToken(token);
  // RedisUtil.set(ShiroConstant.LOGIN_SHIRO_CACHE + user.getId(), user);
  // gettoken.put("token", token);
  // result.put("status", 200);
  // result.put("msg", "登陆成功");
  // result.put("data", gettoken);
  // System.out.println(result.toString());
  // return result;
  // }
  // }

  /**
   * 已登录，token验证
   */
  // @RequestMapping(value = "/info", method = RequestMethod.POST)
  // public Map<String, Object> info() {
  // HashMap<String, Object> responseInfo = new HashMap<>();
  // HashMap<String, Object> responseData = new HashMap<>();
  // responseData.put("roles", "admin");
  // responseData.put("name", "Super admin");
  // responseData.put("avatar",
  // "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
  // responseInfo.put("status", 200);
  // responseInfo.put("msg", "登录成功");
  // responseInfo.put("data", responseData);
  // return responseInfo;
  // }

  // @RequestMapping(value = "/logout")
  // public Map loginout() {
  // HashMap<String, Object> response = new HashMap<>();
  // response.put("status", 200);
  // response.put("data", "success");
  // return response;
  // }

  /**
   * 退出
   */
  // @RequestMapping(value = "/logout", method = RequestMethod.POST)
  // public Map<String, Object> logout() {
  // Subject sub = SecurityUtils.getSubject();
  // User user = (User) sub.getPrincipal();
  // RedisUtil.del(ShiroConstant.LOGIN_SHIRO_CACHE + user.getId(),
  // ShiroConstant.ROLE_SHIRO_CACHE + user.getId());
  // sub.logout();
  // Map<String, Object> result = new HashMap<>();
  // // result.put("status", "200");
  // // result.put("msg", "登出成功");
  // result.put("status", 200);
  // // result.put("data", "success");

  // return result;

  // }

  // 保存用户
  // @RequestMapping(value = "/save")
  // @RequiresPermissions({ "1" })
  // public Map<String, String> saveUser(User user) {

  // tusermapper.insert(user);
  // Map<String, String> result = new HashMap<>();
  // result.put("status", "200");
  // result.put("msg", "用户操作成功");
  // result.put("obj", JSONObject.toJSONString(user));

  // return result;
  // }

  // // 删除用户
  // @RequestMapping(value = "/del")
  // @RequiresPermissions({ "2" })
  // public Map<String, String> deleteUser(Long userId) {
  // Map<String, String> result = new HashMap<>();

  // User user = tusermapper.selectById(userId);
  // if (user != null) {
  // tusermapper.deleteById(userId);
  // RedisUtil.del(ShiroConstant.ROLE_SHIRO_CACHE + userId,
  // ShiroConstant.LOGIN_SHIRO_CACHE + userId);
  // result.put("status", "200");
  // result.put("msg", "用户删除成功");
  // } else {
  // result.put("status", "400");
  // result.put("msg", "没有这个用户");
  // }

  // return result;
  // }

  // // 修改用户权限
  // @PostMapping(value = "/per")
  // @RequiresPermissions({ "3" })
  // public Map<String, String> permission(PermissionEntity permissionEntity) {
  // Map<String, String> result = new HashMap<>();

  // Optional<UserEntity> o =
  // userRepository.findById(permissionEntity.getUserId());
  // if (o.isPresent()) {
  // RedisUtil.del(ShiroConstant.ROLE_SHIRO_CACHE + permissionEntity.getUserId());
  // permissionRepsitory.save(permissionEntity);
  // result.put("status", "200");
  // result.put("msg", "权限添加成功");
  // } else {
  // result.put("status", "400");
  // result.put("msg", "没有这个用户");
  // }

  // return result;
  // }
}