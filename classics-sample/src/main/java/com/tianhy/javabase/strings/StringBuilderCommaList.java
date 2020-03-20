package com.tianhy.javabase.strings;

import java.util.StringTokenizer;

/**
 * {@link}
 *
 * @Desc: 将多个列表项转为以逗号分开的列表，同时避免最后一个元素后有多余的逗号
 * @Author: thy
 * @CreateTime: 2020/3/2 1:18
 **/
public class StringBuilderCommaList {
    static String sample = "this is java";

    //StringBuilder的方式
    public static void stringBuilderPrint() {
        StringBuilder sb1 = new StringBuilder();
        for (String word : sample.split(" ")) {
            if (sb1.length() > 0) {
                sb1.append(",  ");
            }
            sb1.append(word);
        }

        System.out.println(sb1);
        /*
        this,  is,  java
         */
    }

    public static void stringTokenizerPrint() {
        StringTokenizer st = new StringTokenizer(sample);
        StringBuilder sb2 = new StringBuilder();
        while (st.hasMoreElements()) {
            sb2.append(st.nextToken());
            if (st.hasMoreElements()) {
                sb2.append(",  ");
            }
        }
        System.out.println(sb2);
    }

    public static void main(String[] args) {

//        stringBuilderPrint();
        stringTokenizerPrint();
    }
}
