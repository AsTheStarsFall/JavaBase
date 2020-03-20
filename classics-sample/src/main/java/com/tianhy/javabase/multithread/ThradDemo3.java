package com.tianhy.javabase.multithread;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/3/3 6:34
 **/
public class ThradDemo3 {
    private Thread t;
    private int count;

    public ThradDemo3(final String msg, int n) {
        count = n;
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(msg);
                while (count-- > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                System.out.println(msg + " done.");
            }
        });
        t.setName(msg + "runner thread");
        t.start();
    }

    public static void main(String[] args) {
        new ThradDemo3("X", 10);
    }
}
