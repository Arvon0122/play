package com.csj.ceshi.test;

import com.alibaba.fastjson.JSON;
import com.csj.ceshi.service.TaskService;
import org.apache.log4j.Logger;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTask {
     private static Logger logger=Logger.getLogger(TimeTask.class);
    public static void main(String[] args) {
//        Calendar calendar = Calendar.getInstance();
////        calendar.setTime(new Date());
//        calendar.add(Calendar.MONTH, 1);
//        Date newDate = calendar.getTime();
//        String date = new SimpleDateFormat("yyyy-MM-dd").format(newDate);
//        System.out.println(date);
////        if(date.equals(new Date())){
////            System.out.println("密码到期了");
////        }
        System.out.println(new Date());
    }
}
