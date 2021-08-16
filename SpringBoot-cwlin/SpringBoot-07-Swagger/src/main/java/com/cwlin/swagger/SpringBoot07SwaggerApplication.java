package com.cwlin.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class SpringBoot07SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot07SwaggerApplication.class, args);
    }

}
