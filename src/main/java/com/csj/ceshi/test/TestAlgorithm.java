package com.csj.ceshi.test;

import com.csj.ceshi.pojo.Student;
import com.csj.ceshi.pojo.User;
import org.springframework.beans.BeanUtils;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestAlgorithm {
    public static void main(String[] args) {
//        //水仙花数
//        for (int i = 100; i < 999; i++) {
//            int b = i % 100 / 10;
//            int c = i % 10;
//            int a = i / 100;
//            if (i == a * a * a + b * b * b + c * c * c) {
//                System.out.println(i);
//            }
//        }
//        System.out.println(UUID.randomUUID().toString().replace("-",""));
//        System.out.println(String.format("%s 》》》 %s",1,2));
//        List list=new ArrayList();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
//        //判断d 第一次出现的位置
//        int index=list.indexOf("d");
//        System.out.println(index);
//        //判断list是否为空
//        if(!list.isEmpty()){
//            list.add(1,"1");
//        }
//        if(list.contains("a")){
//            list.remove("a");
//        }
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println(list.get(i));
//        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String s = sdf.format(new Date()) + "0001";
        Long l = Long.parseLong(s);
        System.out.println(l);
        System.out.println(TestEnum.一般账户.getStatus());
        System.out.println(Double.valueOf("0.111"));
        Student student = new Student();

    }
}
