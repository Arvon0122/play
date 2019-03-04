package com.csj.ceshi.test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class NFDFlightDataTaskListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        new TimerManager();
    }
    }
//要执行的任务
class NFDFlightDataTimerTask extends TimerTask {
    @Override
    //此方法为具体要定时操作的方法
    public void run() {
        System.out.println("定时器测试:"+System.currentTimeMillis());
    }
}
class TimerManager{
    private static final long PERIOD_DAY=6 * 1000;  //每隔六秒执行一次
    public TimerManager() {
        Timer time1 = new Timer();     //定时器实例化
        NFDFlightDataTimerTask task = new NFDFlightDataTimerTask();   //要执行的任务
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。
        time1.schedule(task,new Date(),PERIOD_DAY);
    }
}
