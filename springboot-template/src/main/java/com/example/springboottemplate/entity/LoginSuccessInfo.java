package com.example.springboottemplate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginSuccessInfo {

  private String roles;
  private String name;
  private String avatar;

}