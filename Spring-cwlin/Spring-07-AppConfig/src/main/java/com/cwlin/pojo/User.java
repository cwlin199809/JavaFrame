package com.cwlin.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component //这个注解的意思，就是说明这个类被Spring接管了，注册到容器中
public class User {
    @Value("cwlin")
    private String name;
}
