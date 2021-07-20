package com.cwlin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component //注册bean到容器中
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    @Value("xiaoHei")
    private String name;
    @Value("3")
    private Integer age;
}
