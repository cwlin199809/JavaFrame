package com.cwlin.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {
    //配置Swagger的docket实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //获取项目环境
        //String[] activeProfiles = environment.getActiveProfiles();
        //通过环境监听判断是否处在设置显示的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(flag)
                .groupName("cwlin")
                .select()
                //RequestHandlerSelectors 配置扫描类的方式
                    //basePackage()：扫描指定包
                    //withClassAnnotation()：扫描类上的注解
                    //withMethodAnnotation()：扫描方法上的注解
                    //any()：扫描全部包
                    //none()：任何包都不扫描
                .apis(RequestHandlerSelectors.basePackage("com.cwlin.swagger.controller")
                        .and(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                        .and(RequestHandlerSelectors.withMethodAnnotation(RequestMapping.class)))
                //PathSelectors 配置扫描路径的方式
                    //ant(final String antPattern)：通过ant()控制过滤路径
                    //regex(final String pathRegex)：通过正则表达式控制扫描路径
                    //any()：任何路径都扫描
                    //none()：任何路径都不扫描
                .paths(PathSelectors.ant("/**"))
                .build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group1");
    }

    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group2");
    }

    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("group3");
    }

    //配置Swagger信息，即 apiInfo()
    private ApiInfo apiInfo(){
        Contact authorContact = new Contact("cwlin", "https://blog.csdn.net/coder_lcw", "xxxxxx@qq.com");
        return new ApiInfo(
                "cwlin's Swagger Api Documentation", //标题
                "愿世界依旧热闹，愿我永远是自己。", //描述
                "v1.0", //版本
                "https://blog.csdn.net/coder_lcw", //组织链接
                authorContact, //联系人信息
                "Apache 2.0", //许可
                "http://www.apache.org/licenses/LICENSE-2.0", //许可链接
                new ArrayList<>()); //扩展
    }
}
