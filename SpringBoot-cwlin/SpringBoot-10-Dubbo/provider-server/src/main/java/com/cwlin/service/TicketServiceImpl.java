package com.cwlin.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService //可以被扫描到，在项目一启动就自动注册到注册中心
@Component //使用Dubbo后尽量不要用@Service注解，Dubbo包里也有@Service注解，容易出现导包问题！
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《觉醒年代》";
    }
}
