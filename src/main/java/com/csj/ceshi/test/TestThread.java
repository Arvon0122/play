package com.csj.ceshi.test;

public class TestThread {
    public static void main(String[] args) {
        RunableDemno R1 = new RunableDemno( "Thread-1");
        R1.start();

        RunableDemno R2 = new RunableDemno( "Thread-2");
        R2.start();
    }
}
