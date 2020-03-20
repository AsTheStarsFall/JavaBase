package com.tianhy.javabase.multithread;

import java.io.IOException;
import java.util.LinkedList;

/**
 * {@link}
 *
 * @Desc: wait/notify 生产/消费 ，单线程
 * @Author: thy
 * @CreateTime: 2020/3/3 8:19
 **/
public class ProdCons1 {
    protected LinkedList<Object> list = new LinkedList<>();

    //生产
    protected void produce() {
        int len = 0;
        synchronized (list) {
            Object produceObj = new Object();
            list.addFirst(produceObj);
            len = list.size();
            list.notifyAll();
        }
        System.out.println("List size :" + len);
    }

    //消费
    protected void consume() {
        Object obj = null;
        int len = 0;
        synchronized (list) {
            //当链表为空，阻塞等待
            while (list.size() == 0) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
            //消费
            obj = list.removeLast();
            len = list.size();
        }

        System.out.println("Consuming obj :" + obj);
        System.out.println("List size :" + len);
    }

    public static void main(String[] args) throws IOException {
        ProdCons1 prodCons1 = new ProdCons1();
        int i;
        while ((i = System.in.read()) != -1) {
            char c = (char) i;
            switch (c) {
                case 'p':
                    prodCons1.produce();
                    break;
                case 'c':
                    prodCons1.consume();
                    break;
            }
        }
    }
}
