package com.cwlin.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等价于 <bean id="user" class="com.cwlin.pojo.User"/>
@Component //组件
@Scope("prototype")
public class User {
    //等价于 <property name="name" value="cwlin"/>
    @Value("cwlin")
    public String name;

    //在set方法上注解也可以
    public void setName(String name) {
        this.name = name;
    }
}
