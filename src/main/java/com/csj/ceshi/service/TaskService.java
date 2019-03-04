package com.csj.ceshi.service;

import com.csj.ceshi.dao.StudentMapper;
import com.csj.ceshi.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
public class TaskService {
    @Autowired
    private StudentMapper studentMapper;
    public Integer a=30;
    @Scheduled(cron = "*/5 * * * * ?")
    public void printTime(){
//       String nowTime= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        System.out.println("现在时间是"+nowTime);
//        Student student=new Student();
//        student.setStuid(null);
//        student.setStuname("Arvon");
//        student.setStusex("男");
//        student.setHeight("178cm");
//        student.setStuage(new BigDecimal(25));
//        student.setWeight("68kg");
//        List<Student> students=studentMapper.getList();
//        System.out.println(students.get(0).getStuname());
//        System.out.println(studentMapper.getList().toString());
        a--;
        if(a==0){
            System.out.println("执行完毕");
        }

    }


}
