package com.tianhy.javabase.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * {@link}
 *
 * @Desc:
 * @Author: thy
 * @CreateTime: 2020/3/3 7:53
 **/
public class ReadWriteDemo {
    //读线程数
    private static final int NUM_READER_THREADS = 3;

    //结束标志
    private volatile boolean flag;

    //受保护的数据
    private BallotBox data;
    //读写锁
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //构造函数，设置一些随机参数

    public ReadWriteDemo() {
        List<String> questionList = new ArrayList<>();
        questionList.add("Agree");
        questionList.add("Disagree");
        questionList.add("No opinion");
        data = new BallotBox(questionList);
    }

    private void demo() {
        //启动两个线程读
        for (int i = 0; i < NUM_READER_THREADS; i++) {
            new Thread(() -> {
                while (!flag) {
                    //获取锁
                    lock.readLock().lock();
                    try {
                        //遍历数据
                        for (BallotPosition datum : data) {
//                            System.out.printf("%s, %dn", datum.getQuestion(), datum.getVotes());
                            System.out.println(datum.getQuestion());
                            System.out.println(datum.getVotes());
                        }
                    } finally {
                        lock.readLock().unlock();
                    }
                    try {
                        Thread.sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                    }
                }

            }).start();
        }

        new Thread(() -> {
            //写
            while (!flag) {
                lock.writeLock().lock();
                try {
                    data.voteFor((int) (Math.random() * data.getCandidateCount()));
                } finally {
                    lock.writeLock().unlock();
                }
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                }
            }

        }).start();
        //main thread
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
        } finally {
            flag = true;
        }
    }

    public static void main(String[] args) {
        new ReadWriteDemo().demo();
    }
}
