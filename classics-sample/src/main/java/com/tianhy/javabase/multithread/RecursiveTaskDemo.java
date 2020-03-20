package com.tianhy.javabase.multithread;


import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * {@link}
 *
 * @Desc: 求一个大数组平均值
 * @Author: thy
 * @CreateTime: 2020/3/4 0:30
 **/
public class RecursiveTaskDemo extends RecursiveTask<Long> {

    static final int N = 1000 * 1000 * 10;
    static final int THRESHOLD = 500;

    int[] data;
    int start, length;

    public RecursiveTaskDemo(int[] data, int start, int length) {
        this.data = data;
        this.start = start;
        this.length = length;
    }

    static void loadData(int[] data) {
        Random r = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = r.nextInt();
        }
    }

    @Override
    protected Long compute() {
        if (length < THRESHOLD) {
            long total = 0;
            for (int i = start; i < start + length; i++) {
                total += data[i];
            }
            return total;
        } else {
            int split = length / 2;
            RecursiveTaskDemo r1 = new RecursiveTaskDemo(data, start, split);
            r1.fork();
            RecursiveTaskDemo r2 = new RecursiveTaskDemo(data, start + split, length - split);
            return r2.compute() + r1.join();
        }
    }

    public static void main(String[] args) {
        int[] source = new int[N];
        loadData(source);
//        System.out.println("data size :" + source.length);
        RecursiveTaskDemo r = new RecursiveTaskDemo(source, 0, source.length);
        ForkJoinPool pool = new ForkJoinPool();
        long before = System.currentTimeMillis();
        pool.invoke(r);
        long after = System.currentTimeMillis();

        //结果
        long total = r.getRawResult();
//        System.out.println("total =" + total);
        //avg
        long avg = total / N;
        System.out.println("Average: " + avg);
        System.out.println("Time :" + (after - before) + "ms");
    }
}
