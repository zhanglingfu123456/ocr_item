package com.aiguess.cronSchedule;

import com.aiguess.common.httpUrl.SendUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务的demo
 * @author kelen
 * @date 2018年4月22日 下午5:50:38
 */
@Component
public class cronDemo {
 
    private static final Logger logger = LoggerFactory.getLogger(cronDemo.class);

//    @Scheduled(cron="0 25 20 * * MON-FRI" )  //每周一到周五
    @Scheduled(cron="0 */1 * * * ?")  //每分钟
    public void executeFileDownLoadTask() {
 
        // 间隔2分钟,执行任务    
        Thread current = Thread.currentThread(); 
        System.out.println("定时任务1:"+current.getId());
        logger.info("demo 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }



}