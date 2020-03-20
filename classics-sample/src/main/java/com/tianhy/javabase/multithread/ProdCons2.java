package com.tianhy.javabase.multithread;

import java.util.LinkedList;

/**
 * {@link}
 *
 * @Desc: 多线程
 * @Author: thy
 * @CreateTime: 2020/3/3 8:42
 **/
public class ProdCons2 {

    //这是生产者与消费者需要同步的对象，也正是wait()/notify()的对象
    protected LinkedList<Object> list = new LinkedList<>();
    protected int max = 50;
    protected boolean flag = false;

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                Object produceObj = getRequestFromNetWork();
                synchronized (list) {
                    while (list.size() == max) {
                        try {
                            System.out.println("Producer WAITING.");
                            list.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Producer INTERRUPTED");
                        }
                    }
                    list.addFirst(produceObj);
                    list.notifyAll();
                    System.out.println("Producer produced new obj");
                    if (flag) {
                        break;
                    }
                }
            }
        }

        //模拟从客户端读取
        Object getRequestFromNetWork() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.err.println("Producer INTERRUPTED");
            }
            return new Object();
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            _flag:
            while (true) {
                Object obj = null;
                synchronized (list) {
                    while (list.size() == 0) {
                        try {
                            System.out.println("Consumer WAITING");
                            list.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Consumer INTERRUPTED");
                        }
                    }
                    obj = list.removeLast();
                    list.notifyAll();
                    int len = list.size();
                    System.out.println("List size :" + len);
                    if (flag) {
                        break _flag;
                    }
                }
                //
                process(obj);
            }
        }

        private void process(Object obj) {
            //模拟时间流逝
            System.out.println("Consuming object :"+ obj);
        }
    }


    ProdCons2(int c, int p) {
        for (int i = 0; i < p; i++) {
            new Producer().start();
        }
        for (int i = 0; i < c; i++) {
            new Consumer().start();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        int consumer = 10;
        int producer = 5;
        ProdCons2 prodCons2 = new ProdCons2(consumer, producer);

        //processing....
        Thread.sleep(10 * 1000);

        synchronized (prodCons2.list) {
            prodCons2.flag = true;
            prodCons2.list.notifyAll();
        }
    }

}
