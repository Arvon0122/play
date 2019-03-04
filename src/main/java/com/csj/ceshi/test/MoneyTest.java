package com.csj.ceshi.test;

import java.text.DecimalFormat;

public class MoneyTest {
    public static void main(String[] args) {
        double money = 123456789.4649999;

        // DecimalFormat的用法 #,###是三位分割一下
        // .00是小数点后保留两位 四舍五入
        DecimalFormat df = new DecimalFormat("#,###.00");
        String m = df.format(money);
        System.out.println(m);
        String s="a\\'a";
        System.out.println(s);

    }
}
