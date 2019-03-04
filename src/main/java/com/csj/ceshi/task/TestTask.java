package com.csj.ceshi.task;

import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {
    @Scheduled(cron ="4-40 * * * * ?")
    public void taskPrint(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        System.out.println( sdf.format(date));
    }
}
