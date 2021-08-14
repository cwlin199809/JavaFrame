package com.cwlin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.cwlin.mapper")
public class SpringBoot04DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot04DataApplication.class, args);
    }

}
