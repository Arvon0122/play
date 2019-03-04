package com.csj.ceshi.test;

import com.csj.ceshi.utils.MD5Utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ExpressTest {
    public static void main(String[] args) {
//        String password="12345678";
//        String newPassword=MD5Utils.MD5Encode(password,"utf-8");
//        System.out.println(newPassword);
        Map<String,Object> map=new HashMap<>();
        map.put("xiaoming",23);
        map.put("ahuang",28);
        map.put("xiaohong",29);
        map.put("daming",88);
        map.put("erguai",99);
//        for (Map.Entry<String,Object> entry:map.entrySet()) {
//            System.out.println(entry.getKey()+":"+entry.getValue());
//        }
        Iterator<Map.Entry<String,Object>> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Object> entry=iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
