package com.csj.ceshi.test;

public class StationThread extends Thread {
    static Object ob = "aa";//唯一密匙
    static int tick = 20;//车票数

    public StationThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (tick > 0) {
            synchronized (ob) {
                if (tick > 0) {
                    System.out.println(getName() + "卖出了第" + tick + "张火车票!");
                    tick--;
                } else {
                    System.out.println("票卖完了");
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
