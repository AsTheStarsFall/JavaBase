package com.tianhy.javabase.multithread;

import java.util.concurrent.TimeUnit;

/**
 * {@link}
 *
 * @Desc: 停止一个线程
 * @Author: thy
 * @CreateTime: 2020/3/3 6:09
 **/
public class StopFlag extends Thread {
    protected volatile boolean flag = false;


    @Override
    public void run() {
        while (!flag) {
            System.out.println("Running");
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {

            }
        }

        System.out.println("Finished");
    }

    public void shutDown() {
        flag = true;
    }

    public static void main(String[] args) throws InterruptedException {
        StopFlag stopFlag = new StopFlag();
        stopFlag.start();
        TimeUnit.SECONDS.sleep(10);
        stopFlag.shutDown();
    }
}
