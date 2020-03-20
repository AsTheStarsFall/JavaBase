package com.tianhy.javabase.Arithmetic;

import lombok.var;

import java.util.Arrays;

/**
 * {@link}
 *
 * @Desc: 冒泡排序
 * @Author: thy
 * @CreateTime: 2019/4/23
 **/
public class BubbleSort {

    public static void main(String[] args) {

        int[] ints = {1, 12, 55, 6, 47, 9, 555, 23, 45, 89};
        System.out.println(Arrays.toString(sort(ints)));
    }

    public static int[] sort(int[] args) {
        var len = args.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                //比较相邻元素的大小
                if (args[j] > args[j + 1]) {
                    //元素交换
                    var temp = args[j + 1];
                    //将较大的值放在后一位
                    args[j + 1] = args[j];
                    //将较小的值放在当前位置
                    args[j] = temp;
                }
            }
        }
        return args;
    }
}
