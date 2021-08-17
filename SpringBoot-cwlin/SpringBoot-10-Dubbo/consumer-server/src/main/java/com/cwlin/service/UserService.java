package com.cwlin.service;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service //注入到容器中
public class UserService {
    //想要拿到provider-server提供的票，需要去拿注册中心的服务
    @DubboReference //引用，Pom坐标，可以定义路径相同的接口名
    TicketService ticketService;

    public void bugTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("在注册中心买到"+ticket);
    }
}
