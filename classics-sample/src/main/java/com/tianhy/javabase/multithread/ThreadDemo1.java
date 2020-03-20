package com.tianhy.javabase.multithread;

/**
 * {@link}
 *
 * @Desc: Thread
 * @Author: thy
 * @CreateTime: 2020/3/3 6:25
 **/
public class ThreadDemo1 extends Thread {
    private String msg;
    private int count;

    @Override
    public void run() {
        while (count-- > 0) {
            System.out.println(msg);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                return;
            }
        }
        System.out.println(msg + " all done");
    }

    public ThreadDemo1(final String msg, int n){
        this.msg = msg;
        this.count = n;
        setName(msg + " runner thread");

    }
    public static void main(String[] args) {
        new ThreadDemo1("X",10).start();
        new ThreadDemo1("Y",20).start();

    }
}
