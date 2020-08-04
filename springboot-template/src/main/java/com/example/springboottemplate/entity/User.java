package com.example.springboottemplate.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import org.springframework.data.annotation.Transient;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author baochengkang
 * @since 2020-07-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 用户表ID
   */
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  /**
   * 用户名
   */
  private String username;

  /**
   * 密码
   */
  private String password;

  /**
   * 临时token
   */
  @Transient
  String token;
}
