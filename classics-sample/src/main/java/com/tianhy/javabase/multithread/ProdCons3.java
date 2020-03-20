package com.tianhy.javabase.multithread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * {@link}
 *
 * @Desc: 利用队列
 * @Author: thy
 * @CreateTime: 2020/3/3 9:19
 **/
public class ProdCons3 {

    protected volatile boolean flag = false;

    class Producer extends Thread {

        protected BlockingDeque<Object> queue;

        public Producer(BlockingDeque<Object> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Object produceObj = getRequestFromNetWork();
                    //生产了一个对象，并入队
                    queue.put(produceObj);
                    System.out.println("Produce new Obj :" + produceObj + "Queue size :" + queue.size());
                    if (flag) {
                        return;
                    }
                }
            } catch (InterruptedException e) {
                System.err.println("Producer INTERRUPTED");
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

    class Consuer implements Runnable {
        protected BlockingDeque<Object> queue;

        public Consuer(BlockingDeque<Object> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    //消费
                    Object take = queue.take();
                    int len = queue.size();
                    System.out.println("Queue size " + len);
                    process(take);
                }
            } catch (InterruptedException e) {
                System.err.println("Consumer INTERRUPTED");
            }

        }

        private void process(Object obj) {
            //模拟时间流逝
            System.out.println("Consuming object :" + obj);
        }
    }


    ProdCons3(int c, int p) {
        BlockingDeque<Object> queue = new LinkedBlockingDeque<>();
        for (int i = 0; i < p; i++) {
            new Thread(new Producer(queue)).start();
        }
        for (int i = 0; i < c; i++) {
            new Thread(new Consuer(queue)).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int consumer = 10;
        int producer = 5;
        ProdCons3 prodCons2 = new ProdCons3(consumer, producer);

        //processing....
        Thread.sleep(10 * 1000);

        prodCons2.flag = true;

    }
}
