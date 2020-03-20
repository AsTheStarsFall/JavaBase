package com.tianhy.javabase.multithread;

import java.io.IOException;

/**
 * {@link}
 *
 * @Desc: Join
 * @Author: thy
 * @CreateTime: 2020/3/3 6:40
 **/
public class JoinThreadDemo {
    public static void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                System.out.println("Reading");
                try {
                    System.in.read();
                } catch (IOException e) {
                    System.err.println();
                }
                System.out.println("Thread finished.");
            }
        };

        System.out.println("Starting");
        t.start();
        System.out.println("Joining");
        try {
            //目标线程调用join阻塞当前线程，直到目标线程完成
            t.join();
        } catch (InterruptedException e) {
            System.err.println("never happened");
        }

        System.out.println("Main finished.");
    }
}
