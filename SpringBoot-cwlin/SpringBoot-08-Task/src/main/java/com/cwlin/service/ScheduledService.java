package com.cwlin.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //在约定时间执行计划好的方法，需要用到Cron表达式
    //Cron表达式：秒 分 时 日 月 星期 {年}（0-7均表示星期日）
    @Scheduled(cron = "0 27 14 * * ?") //每天14点27分执行一次
    //@Scheduled(cron = "0 * * * * 0-7") //每分钟执行一次
    //@Scheduled(cron = "30 0/10 10,18 * * ?") //每天10点和18点，每隔10分钟执行一次
    //@Scheduled(cron = "15 30 10 ? * 1-6") //每个月的周一到周六10点30分15秒执行一次
    public void hello(){
        System.out.println("Hello, Scheduler!");
    }
}
