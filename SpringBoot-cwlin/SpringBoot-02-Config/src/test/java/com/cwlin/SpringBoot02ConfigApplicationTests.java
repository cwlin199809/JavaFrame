package com.cwlin;

import com.cwlin.pojo.Dog;
import com.cwlin.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot02ConfigApplicationTests {
    @Autowired
    private Dog dog;
    @Autowired
    private Person person;

    //编写测试类
    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(person);
    }

}
