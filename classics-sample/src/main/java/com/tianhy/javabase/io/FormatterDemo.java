package com.tianhy.javabase.io;

import java.util.Calendar;
import java.util.Date;

/**
 * {@link}
 *
 * @Desc: 输出格式
 * @Author: thy
 * @CreateTime: 2020/3/2 5:09
 **/
public class FormatterDemo {
    public static void main(String[] args) {
        /*        System.out.printf("%d - %f", 1, Math.PI);
         *//**
         * 1 - 3.141593
         */


        formatterDate();
    }

    //日期格式
    public static void formatterDate() {
        System.out.printf("%d-%02d-%02d%n", 2020, 3, 2);
        //2020-03-02


        //格式化输出Date
        Date today = Calendar.getInstance().getTime();
        System.out.printf("%1$tB  %1$td, %1$tY%n", today);
        //三月  02, 2020
    }
}
