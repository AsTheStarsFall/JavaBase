package com.tianhy.javabase.strings;

/**
 * {@link}
 *
 * @Desc: 将字符串划分为子字符串
 * @Author: thy
 * @CreateTime: 2020/2/29 5:18
 **/
public class SubStringDemo {

    public static void main(String[] args) {
        String a = "Java is nice";
//        String a = "0123456789";
        System.out.println(a);
        System.out.println(a.substring(5)); //is nice
        System.out.println(a.substring(5,7));
    }
}
