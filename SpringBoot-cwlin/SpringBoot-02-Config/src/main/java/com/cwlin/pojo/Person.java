package com.cwlin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
/* @ConfigurationProperties作用：
     将配置文件中配置的每一个属性的值，映射到这个组件中；
     告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定
     参数 prefix = “person”: 将配置文件中的person下面的所有属性一一对应
*/
//绑定配置文件：指定yml配置中的配置名称装配
@ConfigurationProperties(prefix = "person")
//加载指定的配置文件
//@PropertySource(value="classpath:application.properties")
@Validated //数据校验
public class Person {
    //@Value("${name}") //SpringEL表达式取出配置文件中的值
    @Email(message="邮箱格式错误") //name必须是邮箱格式
    private String name;
    //@Value("#{9*2}")
    private Integer age;
    private Boolean feeling;
    private Date birthday;
    private Map<String,Object> maps;
    private List<Object> list;
    private Dog dog;
}
