package com.csj.ceshi.test;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
//        RunableDemno R1 = new RunableDemno( "Thread-1");
//        R1.start();
//
//        RunableDemno R2 = new RunableDemno( "Thread-2");
//        R2.start();
        System.out.println("begin");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("end");
    }
}
