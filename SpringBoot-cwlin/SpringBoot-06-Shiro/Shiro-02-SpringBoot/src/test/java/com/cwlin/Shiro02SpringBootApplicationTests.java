package com.cwlin;

import com.cwlin.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Shiro02SpringBootApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        System.out.println(userService.selectUserByName("cwlin"));
    }

}
