package com.tianhy.javabase.strings;

import java.util.StringTokenizer;

/**
 * {@link}
 *
 * @Desc: 分隔字符串
 * @Author: thy
 * @CreateTime: 2020/2/29 5:27
 **/
public class StrTokDemo {

    public static void main(String[] args) {
//        strSplit();
//        strTok1();
        strTok3();
    }

    public static void strSplit() {
        String strs = "Hello World!";
        for (String word : strs.split(" ")) {
            System.out.println(word);
        }

        //在正则表达式中，如果要匹配多个空格或制表符，使用字符串 "\ s+"
    }

    //将字符串分解成词
    public static void strTok1() {
        StringTokenizer st = new StringTokenizer("Hello World of Java");
        while (st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }

    }

    public static void strTok2() {
        //会丢弃连续相邻的分隔符
        StringTokenizer st = new StringTokenizer("Hello,  World|of| Java", ",  |");
        while (st.hasMoreElements()) {
            System.out.println(st.nextToken());
        }

    }


    public static void strTok3() {
        StringTokenizer st = new StringTokenizer("Hello,  World|of| Java", ",  |", true);
        while (st.hasMoreElements()) {
            //打印出分隔符
            System.out.println(st.nextToken());
        }
    }

    public static void strTok4() {



    }
}
