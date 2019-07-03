package com.csj.ceshi.test;

import com.csj.ceshi.Interface.TestLambda;

public class TestLambdaClass {
    public static void main(String[] args) {
        run(new TestLambda() {
            @Override
            public void test() {
                System.out.println("hello lambda");
            }
        });
        run(()-> System.out.println("hello lambda"));
    }
    static void run(TestLambda testLambda){
        testLambda.test();
    }
}
