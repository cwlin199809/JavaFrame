package com.cwlin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//程序的主启动类
@SpringBootApplication
public class SpringBoot01HelloWorldApplication {

    public static void main(String[] args) {
        //SpringApplication
        SpringApplication.run(SpringBoot01HelloWorldApplication.class, args);
    }

}
