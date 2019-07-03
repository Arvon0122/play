package com.csj.ceshi.test;

public class Excemple {
//    String str="good";
//    char [] ch={'a','b','c'};
//    public void change(String str,char [] ch){
//        str="test ok";
//        ch[0]='g';
//    }
//
//    public static void main(String[] args) {
//        Excemple ex=new Excemple();
//        ex.change(ex.str,ex.ch);
//        System.out.println(ex.str+"and");
//        System.out.println(ex.ch);
//    }
    static boolean foo(char c){
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        int i=0;
       for (foo('A');foo('B')&&(i<2);foo('C')){
           i++;
           foo('D');
       }
    }
}
