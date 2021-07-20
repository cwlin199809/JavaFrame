package com.cwlin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication 来标注一个主程序类，启动类下的所有资源被导入
//说明这是一个Spring Boot应用
@SpringBootApplication
public class SpringBoot01HelloWorldApplication {

    public static void main(String[] args) {
        //以为是启动了一个方法，实际上是启动了一个服务
        //该方法返回一个 ConfigurableApplicationContext 对象
        //参数：当前应用的主程序类，命令行参数
        SpringApplication.run(SpringBoot01HelloWorldApplication.class, args);
    }

}
