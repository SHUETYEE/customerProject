package com.customer.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author 李靖宇
 * @Project customerProject
 * @date 2019/12/4 14:04
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket getDocket(Environment environment) {

        //设置要显示swagger的环境
        Profiles profiles = Profiles.of("dev","pro");
        //判断是否处在自己设定的环境
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否启用
                .groupName("在吗")
                .enable(flag)
                .select()
                //RequestHandlerSelectorspe配置要扫描接口的方式
                //basePackage指定要扫描的包
                //any()扫描全部
                //none()全不扫描
                //withMethodAnnotation扫描方法上的注解
                //withClassAnnotation扫描类上的注解

                .apis(RequestHandlerSelectors.basePackage("com.customer.controller"))
                //paths() 过滤不少苗的
                // .paths(PathSelectors.ant("/com/**"))
                .build();
    }

    @Bean
    public Docket getDocket2(Environment environment) {

        //设置要显示swagger的环境
        Profiles profiles = Profiles.of("dev","pro");
        //判断是否处在自己设定的环境
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否启用
                .groupName("在的")
                .enable(flag)
                .select()
                //RequestHandlerSelectorspe配置要扫描接口的方式
                //basePackage指定要扫描的包
                //any()扫描全部
                //none()全不扫描
                //withMethodAnnotation扫描方法上的注解
                //withClassAnnotation扫描类上的注解

                .apis(RequestHandlerSelectors.basePackage("com.customer.controller"))
                //paths() 过滤不少苗的
                // .paths(PathSelectors.ant("/com/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        //作者信息
        Contact contact = new Contact("李靖宇", "", "");
        return new ApiInfo("真香",
                "Api",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList());
    }
}
