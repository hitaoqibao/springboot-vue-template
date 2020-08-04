package com.example.springboottemplate.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger接口文档配置，访问地址http://localhost:(springboot端口)/swagger-ui.html#/
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())// 调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
        .enable(true)// 是否开启 (true 开启 false隐藏。生产环境建议隐藏)
        .select()
        // 控制暴露出去的路径下的实例
        // 如果某个接口不想暴露,可以使用以下注解
        // @ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
        .apis(RequestHandlerSelectors.basePackage("com.example.springboottemplate.controller"))
        .paths(PathSelectors.any()).build();
  }

  // 构建 api文档的详细信息函数
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        // 页面标题
        .title("Spring Boot Swagger2 构建RESTful API")
        // 文档描述
        .description("接口说明")
        // 服务条款地址
        .termsOfServiceUrl("http://localhost:7070/")
        // 版本号
        .version("1.0")
        // 描述
        .description("API 描述").build();
  }
}