package com.csj.ceshi.test;

public class Station extends Thread {
    private static int tickNum = 50;
    private static Object o = "aa";

    public Station(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        while (tickNum > 0) {
            synchronized (o) {
                if (tickNum > 0) {
                    System.out.println(getName() + "卖出了第" + tickNum + "张票");
                    tickNum--;
                } else {
                    System.out.println("所有票以卖完...");
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Station s1 = new Station("杭州东站窗口");
        s1.start();
        Station s2 = new Station("城站窗口");
        s2.start();
        Station s3 = new Station("余杭站窗口");
        s3.start();
    }
}
