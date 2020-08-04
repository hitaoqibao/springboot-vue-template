package com.example.springboottemplate.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

  /**
   * 成功或失败时返回的错误信息
   */
  private String msg;
  /**
   */
  private Object data;
  /**
   * 返回的代码，200表示成功，其他表示失败
   */
  private int status;

  public Result(int status) {
    this.status = status;
  }

  public Result(int status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  public Result(int status, Object data) {
    this.status = status;
    this.data = data;
  }

  public static Result success() {
    return new Result(200);
  }

  public static Result success(String msg) {
    return new Result(200, msg);
  }

  public static Result success(Object data) {
    return new Result(200, data);
  }

  public static Result success(String msg, Object data) {
    return new Result(msg, data, 200);
  }

  public static Result fail(String msg) {
    return new Result(500, msg);
  }

  public static Result notfound() {
    return new Result(404, "请求地址不存在");
  }

  public static Result requireLogin() {
    return new Result(401, "请登录后重试");
  }

  public static Result noPermission() {
    return new Result(403, "没有权限进行该操作");
  }

  public static Result overload() {
    return new Result(503, "当前请求的人数过多，请稍后重试");
  }

  public static Result tooManyRequest() {
    return new Result(429, "操作过于频繁，请稍后重试");
  }

  public boolean isSuccess() {
    return this.status == 200;
  }
}
