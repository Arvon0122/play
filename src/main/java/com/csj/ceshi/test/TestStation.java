package com.csj.ceshi.test;

public class TestStation {
    public static void main(String[] args) {
        StationThread stationThread1 = new StationThread("滨江站");
        StationThread stationThread2 = new StationThread("西湖站");
        StationThread stationThread3 = new StationThread("萧山站");
        stationThread1.start();
        stationThread2.start();
        stationThread3.start();
    }
}
