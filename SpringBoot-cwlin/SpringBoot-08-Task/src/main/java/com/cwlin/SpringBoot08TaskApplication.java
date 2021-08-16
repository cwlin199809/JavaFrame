package com.cwlin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync //开启异步注解功能
@EnableScheduling //开启定时任务功能
public class SpringBoot08TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot08TaskApplication.class, args);
    }

}
