package com.tianhy.javabase.multithread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * {@link}
 *
 * @Desc: 分而治之计算数组中数字的平方，并放入目标数组中
 * @Author: thy
 * @CreateTime: 2020/3/4 0:01
 **/
public class RecursiveActionDemo extends RecursiveAction {
    static int[] raw = {
            19, 3, 0, -1, 57, 24, 65, Integer.MAX_VALUE, 42, 0, 3, 5};

    static int[] sorted = null;
    //源资源
    int[] source;
    //目标
    int[] dest;
    int length;
    int start;

    public RecursiveActionDemo(int[] source, int start, int length, int[] dest) {
        this.source = source;
        this.dest = dest;
        this.length = length;
        this.start = start;
    }

    //阈值
    static final int THRESHOLD = 4;

    @Override
    protected void compute() {
        System.out.println("ForkJoin computer");
        if (length < THRESHOLD) {
            for (int i = 0; i < start + length; i++) {
                //在目标数组中相乘
                dest[i] = source[i] * source[i];
            }
        } else { //分而治之
            int split = length / 2;
            invokeAll(
                    new RecursiveActionDemo(source, start, split, dest),
                    new RecursiveActionDemo(source, start + split, length - split, dest)
            );
        }
    }

    public static void main(String[] args) {
        sorted = new int[raw.length];
        RecursiveActionDemo r = new RecursiveActionDemo(raw, 0, raw.length, sorted);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(r);
        System.out.print('[');
        for (int i : sorted) {
            System.out.print(i + ",");
        }
        System.out.print(']');

    }
}
