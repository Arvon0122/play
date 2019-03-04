package com.csj.ceshi.test;

import java.math.BigDecimal;

public class TestBigDicim {
    public static void main(String[] args) {
//        BigDecimal b=new BigDecimal(0.1);
//        BigDecimal b1=BigDecimal.valueOf(0.1);
//        String s="0.1";
//        BigDecimal b2=new BigDecimal(s);
//        System.out.println(b);
//        System.out.println(b1);
//        System.out.println(b2);
//        String s="";
//        s=6+s;
//        System.out.println(s);
        int [] arr={4,1,6,5,8,3,9,2,11,7};
        int max=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(max);

    }
}
