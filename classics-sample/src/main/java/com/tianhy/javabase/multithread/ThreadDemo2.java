package com.tianhy.javabase.multithread;

/**
 * {@link}
 *
 * @Desc: Runnable
 * @Author: thy
 * @CreateTime: 2020/3/3 6:29
 **/
public class ThreadDemo2 implements Runnable {

    private String msg;
    private Thread t;
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
        System.out.println(msg + "   all done");

    }

    public ThreadDemo2(String msg, int count) {
        this.msg = msg;
        this.t = new Thread(this);
        this.count = count;
        t.setName(msg + " runner thread");
        t.start();
    }

    public static void main(String[] args) {
        new ThreadDemo2("X", 10);
        new ThreadDemo2("Y", 10);

    }
}
