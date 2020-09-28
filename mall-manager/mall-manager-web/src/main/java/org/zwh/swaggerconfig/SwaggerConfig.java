package org.zwh.swaggerconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableWebMvc
@ComponentScan(basePackages="org.zwh.controller") //需要扫描的包路径
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())  //显示所有类
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        		.title("范夕晨的接口文档")  //粗标题
                .description("HTTP对外开放接口")   //描述
                .version("1.0.0")   //api version
                .termsOfServiceUrl("http://www.baidu.com")
                .license("LICENSE")   //链接名称
                .licenseUrl("http://www.baidu.com")   //链接地址
                .build();
    }


}
